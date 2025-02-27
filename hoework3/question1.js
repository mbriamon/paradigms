//function to return fibonacci sequence each time it is invoked (CLOSURES)

function fibonacci() {

	let start = 0;
	let next = 1;

	return function () {
		//need to store current value so you can return it
		let current = start;
		//update the next value in the sequence
		[start, next] = [next, start + next]; 
		return current;
	};
}
		
//Test Cases 

let fibonacciGenerator1 = fibonacci(); // fibonacci() returns a closure
let fibonacciGenerator2 = fibonacci(); // fibonacci() returns a closure

console.log(fibonacciGenerator1()); // prints 0, i.e., F(0)
console.log(fibonacciGenerator1()); // prints 1, i.e., F(1)
console.log(fibonacciGenerator1()); // prints 1, i.e., F(2)
console.log(fibonacciGenerator1()); // prints 2, i.e., F(3)
console.log(fibonacciGenerator1()); // prints 3, i.e., F(4)

console.log(fibonacciGenerator2()); // prints 0, i.e., F(0)
console.log(fibonacciGenerator2()); // prints 1, i.e., F(1)
console.log(fibonacciGenerator2()); // prints 1, i.e., F(2)
console.log(fibonacciGenerator2()); // prints 2, i.e., F(3)
console.log(fibonacciGenerator2()); // prints 3, i.e., F(4)