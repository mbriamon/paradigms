//function to make a specific amount of water from bottles
function solve(amount, bottles) {	
	//empty bottles
	let initialBots = Array(bottles.length).fill(0); //start with the empty bottles
	//need to store somewhere... in queue
	let queue = [[initialBots, [initialBots]]]; 
	let visited = new Set();
	//need to be string: checking by reference tracking and avoiding revisiting
	visited.add(initialBots.toString());

	//BFS AHHHH!
	while (queue.length > 0) {
		let [curr, path ] = queue.shift(); 
		if (curr.includes(amount)) {
			let finalBots = [...curr]; //copy
			for (let i = 0; i < finalBots.length; i++) {
    			if (finalBots[i] !== amount) {
        			finalBots[i] = 0; // all others 0
    			}
			}
		path.push(finalBots);
		return path;
	}

		for (let i = 0; i < bottles.length; i++) {  
			let nextBots; 

			//fill bottle 
			nextBots = [...curr]; // copy
			nextBots[i] = bottles[i];

			if (!visited.has(nextBots.toString())) {
				queue.push([nextBots, [...path, nextBots]]);
				visited.add(nextBots.toString());
			}

			//empty 
	
			nextBots = [...curr]; // copy
			nextBots[i] = 0;

			if (!visited.has(nextBots.toString())) {
				queue.push([nextBots, [...path, nextBots]]);
				visited.add(nextBots.toString());
			}

			for (let j = 0; j < bottles.length; j++) { //transfer ;)
				if (i !== j) { 
					nextBots = [...curr];

					let pourAmount = Math.min(curr[i], bottles[j] - curr[j]); //how much water
					nextBots[i] -= pourAmount;
					nextBots[j] += pourAmount; //change

					if (!visited.has(nextBots.toString())) {
						queue.push([nextBots, [...path, nextBots]]);
						visited.add(nextBots.toString());
					}
				}
			}
		}
	}
	
	return null;
}


// testing...1 2 3
console.log(solve(2, [5, 3])); // Expected: [[0,0], [5,0], [2,3], [2,0]]
console.log(solve(1, [2, 4])); // Expected: null
console.log(solve(8, [10, 2, 1])); // Expected: [[0,0,0], [10,0,0], [8,2,0], [8,0,0]]
console.log(solve(8, [3, 4, 2, 1])); // Expected: null



