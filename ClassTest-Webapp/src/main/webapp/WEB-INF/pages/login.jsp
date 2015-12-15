<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<html>
<head>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<meta charset="UTF-8">
<title>Login Form</title>

<style>
body {
	margin: 0;
	padding: 0;
	background: #fff;
	color: #fff;
	font-family: Arial;
	font-size: 12px;
}

.body {
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background-image:
		url(http://fc09.deviantart.net/fs20/i/2008/034/3/4/Cluj_Napoca_night_Panorama_by_Andrei_Joldos.jpg);
	background-size: cover;
	-webkit-filter: blur(5px);
	z-index: 0;
}

.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.logout {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #F442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.grad {
	position: absolute;
	top: -20px;
	left: -20px;
	right: -40px;
	bottom: -40px;
	width: auto;
	height: auto;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, rgba(0, 0
		, 0, 0)), color-stop(100%, rgba(0, 0, 0, 0.65)));
	/* Chrome,Safari4+ */
	z-index: 1;
	opacity: 0.7;
}

.header {
	position: absolute;
	top: calc(50% - 35px);
	left: calc(50% - 255px);
	z-index: 2;
}

.header div {
	float: left;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 35px;
	font-weight: 200;
}

.header div span {
	color: #5379fa !important;
}

.login {
	position: absolute;
	top: calc(50% - 75px);
	left: calc(50% - 50px);
	height: 150px;
	width: 350px;
	padding: 10px;
	z-index: 2;
}

.login input[type=text] {
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255, 255, 255, 0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
}

.login input[type=password] {
	width: 250px;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255, 255, 255, 0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
	margin-top: 10px;
}

.login input[type=submit] {
	width: 260px;
	height: 35px;
	background: #fff;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: #a18d6c;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 6px;
	margin-top: 10px;
}

.login input[type=submit]:hover {
	opacity: 0.8;
}

.login input[type=submit]:active {
	opacity: 0.6;
}

.login input[type=text]:focus {
	outline: none;
	border: 1px solid rgba(255, 255, 255, 0.9);
}

.login input[type=password]:focus {
	outline: none;
	border: 1px solid rgba(255, 255, 255, 0.9);
}

.login input[type=button]:focus {
	outline: none;
}

::-webkit-input-placeholder {
	color: rgba(255, 255, 255, 0.6);
}

::-moz-input-placeholder {
	color: rgba(255, 255, 255, 0.6);
}
</style>

  <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
  <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
  

  <!-- Load jQuery and the validate plugin -->
  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
  
  <!-- jQuery Form Validation code -->
  <script>
  

  $(function() {
  
    // Setup form validation on the #register-form element
    $("#register-form").validate({
    
        rules: {
            username: "required",
   
            password: {
                required: true,
                minlength: 3
            }
        },
        

        messages: {
            username: "Please enter your Yonder code ",
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 3 characters long"
            }
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });

  });
  
  </script>
</head>
<body onload='document.loginForm.username.focus();'>



	<div class="body"></div>
	<div class="grad">x</div>
	<div class="header">
	</div>
	<br>

	<div class="login">
		<form name='loginForm' action="<c:url value='/j_spring_security_check'/>" method='POST' id="register-form" novalidate="novalidate">
		
			<input type="text" placeholder="username" name="username"><br>
			<input type="password" placeholder="password" name="password"><br>
			<input name="submit" type="submit" value="Login">
		
			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
		</form>
	</div>



</body>
</html>

