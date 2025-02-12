var users = [
    {id: 1, name: "Marta", height: 1.74, weight: 59}, 
    {id: 2, name: "Josh", height: 1.80, weight: 88},
    {id: 3, name: "Achilles", height: 1.68, weight: 63}, 
    {id: 4, name: "Julius", height: 1.93, weight: 97},
];

// Function 1: findUserById
function findUserById(users, id) {
    const user = users.find(user => user.id === id);
    return user ? user.name : null;
}

// Function 2: computeBMIs
function computeBMIs(users) {
    return users.map(user => user.weight / (user.height * user.height));
}

//testing... 1 2 3
console.log(findUserById(users, 2)); // Output: "Josh"
console.log(computeBMIs(users)); // Output: [19.48, 27.16, 22.32, 26.03]