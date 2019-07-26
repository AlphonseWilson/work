let user = {};

window.onload = function() {
	populateUser();
}

function populateUser() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8084/ProjectOne4/session").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8084/ProjectOne4/loginpage"
		} else {
			//define behavior for when a user is returned
			user = data;
			document.getElementById("firstname").innerText = "firstname: "+user.user_FirstName;
			document.getElementById("lastname").innerText = "lastname: "+user.user_LastName;
			document.getElementById("username").innerText = "username: "+user.user_name;
			document.getElementById("Password").innerText = "Password: "+user.pass;
			document.getElementById("User_ID").innerText = "User_ID: "+user.user_id;
			document.getElementById("Position").innerText = "Position: "+user.user_position;
			document.getElementById("Phone").innerText = "Phone: "+user.user_Phone;
			document.getElementById("Email").innerText = "Email: "+user.user_email;
		}
	})
}