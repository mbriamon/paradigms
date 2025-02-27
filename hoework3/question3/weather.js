function toCelsius() {
	// Grabs the input from the user
	let input = document.getElementById("temperature").value;
	let resultParent = document.getElementById("result-parent");
	let result = document.getElementById("result");

	// Remove any existing warning
	let currentWarning = document.getElementById("warning");
	if (currentWarning) {
		currentWarning.remove();
	}

	// Check if input is a valid number
	if (isNaN(input) || input.trim() === "") {
		let warning = document.createElement("div");
		warning.id = "warning";
		warning.innerText = "Please input a valid number!";
		warning.style.color = "red";
		warning.style.fontWeight = "bold";

		// Hide result if the input is not a number
		resultParent.style.visibility = "hidden";

		// Insert warning above the result
		resultParent.parentNode.insertBefore(warning, resultParent);
	} else {
		// Converts the temperature to Celsius
		let celsius = (Number(input) - 32) * 5 / 9;

		// Show back to the user, on the <span> element
		result.innerText = celsius.toFixed(2); // Optionally rounds to 2 decimal places

		// Makes the div visible
		resultParent.style.visibility = "visible";
	}
}
