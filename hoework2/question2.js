//import the Node JS modules
const fs = require('fs');								// module for file I/O
const readline = require("readline");		// module for reading line by line from file

//create input streams
let defectsCSV = fs.readFileSync("defects.csv","utf8");        
let dependsCSV = fs.readFileSync("defect_depends.csv","utf8");
let blocksCSV = fs.readFileSync("defect_blocks.csv","utf8");
let developersCSV = fs.readFileSync("developers.csv","utf8");

//object to store associated info
class Defect {
    constructor(bug_id, component, status, resolution, summary, blocks, depends, fixed_by_username, fixed_by_real_name) {
        this.bug_id = Number(bug_id);
        this.component = String(component);
        this.status = String(status);
        this.resolution = String(resolution);
        this.summary = String(summary);
        this.blocks = blocks;
        this.depends = depends;
        this.fixed_by_username = String(fixed_by_username);
        this.fixed_by_real_name = String(fixed_by_real_name);
    }
}

function loadObjects() {
    let defects_arr = [];

    // Read and parse defects CSV
    defectsCSV.split("\n").forEach(row => {
        if (row.startsWith("bug_id")) return;

        let fields = row.split(",");
        let bug_id = Number(fields[0]);
        let component = fields[1];
        let status = fields[2];
        let resolution = fields[3];
        let summary = fields[4];
        let username = fields[13];

        let defect = new Defect(bug_id, component, status, resolution, summary, [], [], username, null);
        defects_arr.push(defect);
    });

    // Read and parse dependencies CSV
    dependsCSV.split("\n").forEach(row => {
        if (row.startsWith("from_defect_id")) return;

        let [from_defect_id, to_defect_id] = row.split(",").map(Number);
        if (!from_defect_id || !to_defect_id) return;

        let defect = defects_arr.find(d => d.bug_id === from_defect_id);
        if (defect) defect.depends.push(to_defect_id);
    });

    // Read and parse blocks CSV
    blocksCSV.split("\n").forEach(row => {
        if (row.startsWith("from_defect_id")) return;

        let [from_defect_id, to_defect_id] = row.split(",").map(Number);
        if (!from_defect_id || !to_defect_id) return;

        let defect = defects_arr.find(d => d.bug_id === from_defect_id);
        if (defect) defect.blocks.push(to_defect_id);
    });

    // Read and parse developers CSV
    developersCSV.split("\n").forEach(row => {
        if (row.startsWith("real_name")) return;

        let [real_name, username] = row.split(",");
        defects_arr.forEach(defect => {
            if (defect.fixed_by_username === username) {
                defect.fixed_by_real_name = real_name;
            }
        });
    });

    return defects_arr;
}

function query1(defects) {
    return defects.filter(d => d.status === 'RESOLVED' && d.resolution === 'FIXED').length;
}

function query2(defects) {
    return defects.filter(d => d.summary.toLowerCase().includes('buildbot')).length;
}

function query3(defects) {
    const total = defects.length;
    const backlog = defects.filter(d => d.status !== 'RESOLVED').length;
    return (backlog / total * 100).toFixed(2);
}

function query4(defects) {
    const counts = defects.reduce((acc, d) => {
        acc[d.component] = (acc[d.component] || 0) + 1;
        return acc;
    }, {});
    return Object.keys(counts).reduce((a, b) => counts[a] > counts[b] ? a : b);
}

function query5(defects) {
    const docFixes = defects.filter(d => d.status === 'RESOLVED' && d.resolution === 'FIXED' && d.component === 'Documentation');
    const counts = docFixes.reduce((acc, d) => {
        if (d.fixed_by_username) {
            acc[d.fixed_by_username] = (acc[d.fixed_by_username] || 0) + 1;
        }
        return acc;
    }, {});
    //console.log("Documentation fixes count per developer:", counts);
    return Object.entries(counts).sort((a, b) => b[1] - a[1])[0]?.[0] || null;
}

function query6(defects) {
    const visited = new Set();
    function hasCycle(defect, stack = new Set()) {
        if (stack.has(defect.bug_id)) return true;
        if (visited.has(defect.bug_id)) return false;
        visited.add(defect.bug_id);
        stack.add(defect.bug_id);
        for (let blockedId of defect.blocks) {
            if (hasCycle(defects.find(d => d.bug_id === blockedId), stack)) return true;
        }
        stack.delete(defect.bug_id);
        return false;
    }
    return defects.some(d => hasCycle(d));
}

//testing ...  1 2 3
let defects = loadObjects();
console.log(query1(defects)); // 8330
console.log(query2(defects)); // 2681
console.log(query3(defects)); // 7.73
console.log(query4(defects)); // GTK+ UI
console.log(query5(defects)); // jeff.morriss.ws
console.log(query6(defects)); // false

