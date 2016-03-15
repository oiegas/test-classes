<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<title>Test Page</title>

<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css"
	rel="stylesheet">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<!-- Load jQuery and the validate plugin -->
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.iconAdd {
	height: 24px;
	width: 24px;
	opacity: 4;
}

.searchTest {
	float: left;
	margin-left: 10;
	margin-top: 0;
	margin-bottom: 30;
}

.searchForm {
	margin-top: 50;
}

.listTabel {
	float: right;
	position: absolute;
	display: block;
	padding: 10px 15px;
	margin-top: 25;
	margin-left: 10;
	margin-right: 250;
}

.buttons {
	margin-top: 0;
	margin-left: 10;
	float: right;
}

a {
	color: #337ab7;
	text-decoration: none;
	margin: 0;
	display: inline-block;
}

.list-group-item {
	position: relative;
	display: block;
	padding: 30px 15px;
	margin-bottom: -1px;
	background-color: #fff;
	border: 1px solid #ddd;
}

.rightPanel {
	float: left;
	margin-left: 250;
	margin-top: 50;
}

.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover
	{
	background-color: rgb(128, 201, 38) !important;
}

.nav-tabs>li>a:hover {
	border-color: rgb(132, 202, 104);
}

.nav>li>a:focus, .nav>li>a:hover {
	background-color: #ACEF91;
}

.rightPanelEdit {
	float: right;
	margin-right: 200;
	margin-top: 80;
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

.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
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
	top: 20px;
	background:
		url('http://stolenbabiestheband.com/wp-content/uploads/2012/12/sbSiteBackgroundPaper.jpg')
		repeat-x fixed center top;
	background-size: cover;
	margin-left: auto;
	margin-right: auto;
	border: #fff 15px solid;
}

.module {
	position: relative;
	top: 5%;
	height: 150%;
	width: 80%;
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

.button:hover {
	background: #80b438;
}

.rightPanel {
	float: none;
	margin-left: 0;
	margin-top: 0;
	border: 1px solid rgb(209, 240, 196);
	width: auto;
	position: absolute;
	top: 150px;
	left: 450px;
	bottom: 10px;
	right: 10px;
	padding: 10px;
	border-radius: 5px;
}

.listTabel {
	float: none;
	position: absolute;
	padding: 0;
	margin-top: 0;
	margin-left: 0;
	margin-right: 0;
	top: 150px;
	bottom: 10px;
	left: 10px;
	width: 420px;
}

.list-group-item {
	position: static;
	display: block;
	padding: 10px;
	margin-bottom: 0;
	background-color: #fff;
	border: 1px solid #ddd;
	height: 50px;
}

a {
	display: inline-block;
	margin-top: 0;
}

.buttons {
	margin-top: 0;
	margin-left: 0;
	float: none;
}

.name {
	width: 50px;
}

.user-icons {
	margin-left: 200px;
	display: inline-block;
}
</style>
<script>
	$(function() {

	// Setup form validation on the #register-form element
	$("#register-form").validate({

		rules : {
			name : "required",
			

		},

		messages : {
			name : "Please enter your Yonder code ",
			

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
		
			<br>
			<div id="topListMenu" class="topListMenu">
				<div class="searchStudent">
					<c:url var="searchUserAction" value="/studentStatistics/search/"></c:url>
				</div>
				<form:form action="${searchUserAction}" commandName="studentSearch"
					id="searchForm" class="searchForm">
					<span><form:input type="text" path="name" placeholder="Name"
							class="searchStudent" style="width:20%" /></span>
					<span> <a class="searchStudent"> <img
							src=" http://icons.iconarchive.com/icons/fasticon/isimple-system/128/search-icon.png"
							onclick='document.getElementById("searchForm").submit();' alt=""
							class="iconAdd">
					</a>
					</span>
				</form:form>
			</div>
			<c:if test="${!empty listStudents}">
				<div class="listTabel">

					<ul class="list-group">
						<c:forEach items="${listStudents}" var="student">

							<li class="list-group-item"><a class="buttons name"
								href="<c:url value='/studentStatistics/get/${student.userId}' />">${student.name}</a>
								<div class="user-icons">
									<a class="buttons"
										href="<c:url value='/editTest/${test.testId}' />">
										<img
										src=" http://icons.iconarchive.com/icons/fasticon/freestyle/48/pencil-icon.png"
										alt="Edit" class="iconAdd">
									</a> <a class="buttons"
										href="<c:url value='/studentStatistics/remove/${student.userId}' />"
										onclick='confirmUser()'> <img
										src="http://icons.iconarchive.com/icons/dryicons/aesthetica-2/48/user-remove-icon.png"
										alt="Remove" class="iconAdd">
									</a>



								</div></li>
						</c:forEach>
					</ul>
				</div>
			</c:if>



		<%-- 	<c:if test="${not empty listTestsSearch}">
				<h2>list search tests</h2>
				<table class="tg">
					<tr>

						<th width="80">Test Name</th>
						<th width="80">Test Date</th>
						<th width="80">Question 1</th>
						<th width="100">Question 2</th>
						<th width="80">Question 3</th>
						<th width="40">Question 4</th>
						<th width="70">Question 5</th>
					</tr>

					<c:forEach items="${listTestsSearch}" var="test">
						<tr>
							<td>${test.name}</td>
							<td>${test.startDate}</td>
							<td>${test.firstQuestion.question}</td>
							<td>${test.secondQuestion.question}</td>
							<td>${test.thirdQuestion.question}</td>
							<td>${test.fourthQuestion.question}</td>
							<td>${test.fifthQuestion.question}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>

			<div class="rightPanel">
				<c:if test="${not empty testB}">
					<table>
						<tr>
							<h3>ID: ${testB.testId}</h3>
							<h3>Name:${testB.name}</h3>
							<h3>Surname:${testB.startDate}</h3>
							<h3>Email:${testB.firstQuestion.question}</h3>
							<h3>Address:${testB.secondQuestion.question}</h3>
							<h3>Phone:${testB.thirdQuestion.question}</h3>
							<h3>Recruiter Code:${testB.fourthQuestion.question}</h3>
							<h3>Action:${personB.fifthQuestion.question}</h3>
							<br></br>
						</tr>
					</table>
				</c:if>
			</div>
		</div>
	</div>

	<script>
				function loadEditTest(id) {
					$('input[name="testId"]', '#dialogEditTest').val(id)
					$("#dialogEditTest").dialog();
					
				}
				
			</script>
	<script>
				function loadAddQuestion(id) {
					$('input[name="testId"]', '#dialogAddQuestion').val(id)
					$("#dialogAddQuestion").dialog();
				}
			</script>

	<script>
				function loadCloneQuestion(id) {
					$('input[name="testId"]', '#dialogCloneQuestion').val(id)
					$("#dialogCloneQuestion").dialog();
				}
			</script> --%>
</body>

</html>