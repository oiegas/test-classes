<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<title>Classes Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	text-align: center;
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

.h4 {
	width: 40px;
}

body {
	background-color: #f0f0f0;
	font-family: helvetica;
}

a {
	display: block;
	color: #ad5482;
	margin-top: 60px;
	text-decoration: none;
	font-weight: bold;
	text-align: center;
}

#bg {
	position: absolute;
	background:
		url('http://stolenbabiestheband.com/wp-content/uploads/2012/12/sbSiteBackgroundPaper.jpg');
	background-size: cover;
	margin-left: auto;
	margin-right: auto;
	top: 0;
	left: 0;
	min-width: 100%;
	min-height: 100%;
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

.button1 {
	height: 50px;
	width: 100%;
	margin-top: 0;
	border-radius: 3px;
	border: rgba(0, 0, 0, .3) 0px solid;
	box-sizing: border-box;
	padding: 10px;
	background: #90c843;
	color: #FFF;
	font-weight: bold;
	font-size: 12pt;
	transition: background .4s;
	cursor: pointer;
	border-radius: 3px;
}

.classname {
	margin-top: 100px;
	margin-left: 150px;
}

.submitbutton {
	margin-top: 25px;
	margin-left: 270px;
}

.classesList {
	margin-left: 280px;
}

.tableList {
	margin-left: 220px;
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

.a:iconHome {
	margin-top: 0px;
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

			rules : {
				className : "required"

			},

			messages : {
				className : "Please enter a class name!!!"

			},

			submitHandler : function(form) {
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

			<c:url var="add" value="/class/add"></c:url>

			<form:form action="${add}" commandName="aClass" id="register-form"
				novalidate="novalidate" class="form">
				<div class="classname">
					<h4>
						Class Name:
						<form:input path='className' placeholder="Class Name"
							name="className"></form:input>
					</h4>
				</div>
				<div class="submitbutton">
					<input type="submit" class="button" value="Add Class" />
				</div>


			</form:form>

			<br>
			<div class="classesList">
				<h3>Classes List</h3>
			</div>

			<div class="tableList">
				<c:if test="${!empty listClasses}">
					<table class="tg">
						<tr>
							<th width="80">Class ID</th>
							<th width="80">Class Name</th>
							<th width="60">Delete</th>
						</tr>
						<c:forEach items="${listClasses}" var="aClass">
							<tr>
								<td>${aClass.classId}</td>
								<td>${aClass.className}</td>

								<td><a class="button1"
									href="<c:url value='/class/remove/${aClass.classId}' />"
									onclick='confirmUser()'>Delete</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>

			<c:url value="/j_spring_security_logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm"></form>
			<script>
				function confirmUser() {

					var ask = confirm("Are you sure?");

				}
			</script>
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