function find(nums) {

	//set (let)  initial vars equal 0
	let maxCount = 0;
	let currentCount = 0;

	//loop through nums list
	for (let i = 0; i < nums.length; i++){
		//increase count if 33
		if (nums[i] === 33 || nums[i] === 33.0) {
			currentCount++;
			//if new count exceeds max, update max
			if(currentCount > maxCount){
				maxCount = currentCount;
			}
		}
		//if streak dies then reset current count to 0
		else {
			currentCount = 0;
		}
	}

	//return max
	return maxCount;

}

//testing ... 1 2 3
console.log(find([33, 33, 30, 33, 33, 33]));
console.log(find([33, 0, 33, 33, 0, 33]));
console.log(find([33,-10,33,33,8,3,33,33,9,33,33,33,33,33,33]));
console.log(find([33,33,5,33,33,33]));
console.log(find([null, "house", 9, undefined, "33"]))
console.log(find([33,33,30,33,33,33.0]));