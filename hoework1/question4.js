function reversedSum(num1, num2){
	//helper function to reverse numbers
	function reverseNumber(num){
		//convert to string and then reverse string and then convert back to number
		const reversedString = String(num).split('').reverse().join('');
		return Number(reversedString);
	}

	//reverse them
	const reverse1 = reverseNumber(num1);
	const reverse2 = reverseNumber(num2);
	
	//sum them 
	const sum = reverse1 + reverse2;
	
	//reverse sum and return 
	return reverseNumber(sum);

}

//testing...1 2 3
console.log(reversedSum("24", 1));
console.log(reversedSum(4358, "754"));
console.log(reversedSum(305, 794));