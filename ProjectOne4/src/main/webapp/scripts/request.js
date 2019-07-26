let user = {};

window.onload = function() {
	populateUser();
}

function populateUser() {
	// send a GET request to SessionServlet to obtain session information
	fetch("http://localhost:8084/ProjectOne4/ViewPendingRequests").then(function(response) {
		return response.json(); // parsing json data in the response as a JS object
	}).then(function(data) {
		console.log(data);
		// check whether there is a valid session
		//define behavior for when there is no valid user
		if(data.session === null) {
			window.location = "http://localhost:8084/ProjectOne4/ViewPendingRequests.html"

//			window.location = "http://localhost:8084/ProjectOne4/loginpage"
		} else {
			//define behavior for when a user is returned
			user = data;
			 var mylist= "<ul>";
			let text = "";
			 var textnode = document.createTextNode("Water");
			 var node = document.createElement("P");
			for(let i =0 ; i < user.length; i++){
				//user[i].reqState
				
				 textnode = document.createTextNode(" reqid: "+user[i].reqid+" amount: "+user[i].amount+" reqState: "+user[i].reqState+" *********************");
				 node.appendChild(textnode);
				
			    mylist+="<li> reqid: "+user[i].reqid+" amount: "+user[i].amount+" reqState: "+user[i].reqState+"   </li>";
			    
			};
			
			  mylist+="</ul><br>";
			  document.getElementById("myList").appendChild(node);
			  //document.getElementById("mylist").innerText = "mylist: "+mylist;
			  //document.write( mylist, text);
//			
//			document.getElementById("firstname").innerText = "firstname: "+user.user_FirstName;
//			document.getElementById("lastname").innerText = "lastname: "+user.user_LastName;
//			document.getElementById("username").innerText = "username: "+user.user_name;
//			document.getElementById("Password").innerText = "Password: "+user.pass;
//			document.getElementById("User_ID").innerText = "User_ID: "+user.user_id;
//			document.getElementById("Position").innerText = "Position: "+user.user_position;
//			document.getElementById("Phone").innerText = "Phone: "+user.user_Phone;
//			document.getElementById("Email").innerText = "Email: "+user.user_email;
		}
	})
}