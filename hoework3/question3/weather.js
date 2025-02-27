function toCelsius(){

	// grabs the input from the user
	let input =  document.getElementById("temperature").value;
	let resultParent = document.getElementById("result-parent");
	let result = document.getElementById("result");

	let currentWarning = document.getElementById("warning");
	if (currentWarning) {
		currentWarning.remove();
	}
	
	//check if input is a valid number
	if(isNaN(input) || input.trim === ""){
		let warning = document.createElement("div");
		warning.id = "warning";
		
		warning.innerText("Please input a valid number!");
		warning.style.color("red");
		warning.style.fontWeight("bold");
		resultParent.style.visibility("hidden"); //hides result if the input is not a number
		resultParent.ParentNode.insertBefore(warning, resultParent);
	} else {
		// converts the temperature to C
		let celsius = (input - 32) * 5/9;
		// show back to the user, on the <span> element
		document.getElementById("result").innerText = celsius;
		// makes the div visible
		// element.style can be used to change CSS properties of an HTML document
		document.getElementById("result-parent").style.visibility = "visible";
	}
}
