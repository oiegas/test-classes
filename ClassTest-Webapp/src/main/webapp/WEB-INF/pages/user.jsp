<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<title>User</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}

* {
	margin: 0;
	padding: 0;
}

body {
	background-color: #f0f0f0;
	font-family: helvetica;
}

a {
	display: block;
	color: #ad5482;
	text-decoration: none;
	font-weight: bold;
	margin-top: 40px;
	text-align: center;
}

#bg {
	position: relative;
	background:
		url('http://stolenbabiestheband.com/wp-content/uploads/2012/12/sbSiteBackgroundPaper.jpg');
	background-size: cover;
	margin-left: auto;
	margin-right: auto;
}

.module {
	position: relative;
	top: 5%;
	height: 95%;
	width: 750px;
	margin-left: auto;
	margin-right: auto;
	border-radius: 5px;
	background: RGBA(255, 255, 255, 1);
	-webkit-box-shadow: 0px 0px 15px 0px rgba(0, 0, 0, .45);
	box-shadow: 0px 0px 15px 0px rgba(0, 0, 0, .45);
}

.module ul {
	list-style-type: none;
	margin: 0;
}

.tab {
	float: left;
	height: 60px;
	width: 25%;
	padding-top: 20px;
	box-sizing: border-box;
	background: #eeeeee;
	text-align: center;
	cursor: pointer;
	transition: background .4s;
}

.tab:first-child {
	-webkit-border-radius: 5px 0px 0px 0px;
	border-radius: 5px 0px 0px 0px;
}

.tab:last-child {
	-webkit-border-radius: 0px 5px 0px 0px;
	border-radius: 0px 5px 0px 0px;
}

.tab:hover {
	background-color: rgba(0, 0, 0, .1);
}

.activeTab {
	background: #fff;
}

.activeTab .icon {
	opacity: 1;
}

.icon {
	height: 24px;
	width: 24px;
	opacity: .2;
}

.form {
	float: left;
	height: 50%;
	width: 100%;
	box-sizing: border-box;
	padding: 40px;
}

.textbox {
	height: 50px;
	border-radius: 3px;
	border: rgba(0, 0, 0, .3) 2px solid;
	box-sizing: border-box;
	padding: 10px;
	margin-bottom: 30px;
}

.textbox:focus {
	outline: none;
	border: rgba(24, 149, 215, 1) 2px solid;
	color: rgba(24, 149, 215, 1);
}

.button {
	height: 50px;
	width: 100%;
	border-radius: 3px;
	border: rgba(0, 0, 0, .3) 0px solid;
	box-sizing: border-box;
	padding: 10px;
	margin-bottom: 30px;
	background: #90c843;
	color: #FFF;
	font-weight: bold;
	font-size: 12pt;
	transition: background .4s;
	cursor: pointer;
}

.userName {
	margin-top: 100px;
	margin-left: 150px;
}
.userEmail {
	margin-left: 195px;
}
.userPassword {
	margin-left: 158px;
}
.userUserName {
	margin-left: 157px;
}

.submitbutton {
	margin-top: 25px;
	margin-left: 270px;
}

.userList {
	margin-left: 280px;
}

.tableList {
	margin-left: 120px;
	margin-top: 40px;
}

.iconHome {
	height: 40px;
	width: 40px;
	opacity: 4;
}

.homepage {
	margin-top: -40px;
}

.button:hover {
	background: #80b438;
}
</style>

<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css"
	rel="stylesheet">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>

<!-- Load jQuery and the validate plugin -->
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>

<!-- jQuery Form Validation code -->

<script>

   $(function() {
   
     // Setup form validation on the #register-form element
     $("#register-form").validate({
     
         rules: {
             name:{ 
                 	required: true},
         },
         

         messages: {
        	 name: {
                 required: "Please enter a name",
         },
         
         submitHandler: function(form) {
             form.submit();
         }
     });

   });
   
   </script>
</head>
<body>

	<div id="bg">

		<div class="module">

			<div class="homepage">
				<a class="buttons" href="<c:url value='/startup' />"> <img
					src="http://icons.iconarchive.com/icons/custom-icon-design/mono-general-3/72/home-icon.png"
					alt="Home" class="iconHome"></a>
			</div>

			<c:url var="add" value="/user/add"></c:url>

			<form:form action="${add}" commandName="user" id="register-form"
				novalidate="novalidate" class="form">

				<div class="userName">
					<h4>
						User Name:
						<form:errors path="name" cssClass="error"/>
						<form:input path='name' required="required"></form:input>
					</h4>
				</div>
				<div class="userEmail">
					<h4>
						Email:
						<form:input path='email'></form:input>
					</h4>
				</div>
				<div class="userUserName">
					<h4>
						Username:
						<form:input path='username'></form:input>
					</h4>
				</div>
				<div class="userPassword">
					<h4>
						Password:
						<form:input path='password'></form:input>
					</h4>
				</div>
				<h5>The role will be ADMINISTRATOR</h5>


				<div class="submitbutton">
					<input type="submit" class="button" value="Add Admin" />
				</div>
			</form:form>

			<br>
			<div class="userList">
				<h3>Users List</h3>
			</div>
			<div class="tableList">
				<c:if test="${!empty listUsers}">
					<table class="tg">
						<tr>
							<th width="80">User ID</th>
							<th width="80">User Name</th>
							<th width="80">User Email</th>
							<th width="80">User Username</th>
							<th width="60">Delete</th>
						</tr>
						<c:forEach items="${listUsers}" var="user">
							<tr>
								<td>${user.userId}</td>
								<td>${user.name}</td>
								<td>${user.email}</td>
								<td>${user.username}</td>

								<td><a class="button"
									href="<c:url value='/user/remove/${user.userId}' />"
									onclick='confirmUser()'>Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>


			<c:url value="/j_spring_security_logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm"></form>
			<script>
	function confirmUser(){
		
	    var ask=confirm("Are you sure");

		   if(ask)
			   {  alert("ok!");}}</script>
			<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<h4>
					<a class="button" href="javascript:formSubmit()">Logout</a>

				</h4>
			</c:if>

		</div>
	</div>
</body>
</html>