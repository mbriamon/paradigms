function enumerate(i, j) { 
	
	let arr = [];

	// if i > j return empty array 
	if (i > j) { 
		return [];
	}

	//set (letting :) ) vars, array to hold terms
	let direction = 'down';
	let place = 1;
	let pos = [];
	let numer = 2;
	let denom = 2;
    
	while (place <= j) {
		//current fraction to array 
		pos.push(`${numer}/${denom}`);

	//find next fraction in the chart 
		if (direction === 'down') {
      numer = numer + 2;
			//change direction
			direction = 'upRightDiagonal'; 
	 	} 
		else if (direction === 'upRightDiagonal') {
			numer = numer - 2;
			denom = denom + 2;
			if (numer < 2) {	
				numer = 2;
				direction = 'right';
			}
	 	} 
		else if (direction === 'right') {
			denom = denom - 2;
			numer = numer + 2;
			//change direction
			direction = 'downLeftDiagonal';

	 	} 
		else if (direction === 'downLeftDiagonal') {
			numer = numer + 2;
			denom = denom - 2;
			if (denom < 2) {
				denom = 2;
				//start pattern over 
				direction = 'down';
			}
		}

		place++;
	}

	//get the terms
	for (let ind = i; ind <= j; ind++) {
		if (ind < 1) { 
			arr.push(null); 
	 	} 
		else {
			arr.push(pos[ind - 1]);
		}
	}
    
    return arr;
}

			
//testing ... 1 2 3 
console.log(enumerate(1, 2)); 
console.log(enumerate(3, 6)); 
console.log(enumerate(-1, 4)); 
console.log(enumerate(-4, 0));
console.log(enumerate(1, 1));
