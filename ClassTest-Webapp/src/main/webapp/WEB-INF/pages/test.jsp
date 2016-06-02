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

.iconHome {
	height: 40px;
	width: 40px;
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
	background-color: #000000;
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

.bg {
	position: relative;
	background:
		url('http://stolenbabiestheband.com/wp-content/uploads/2012/12/sbSiteBackgroundPaper.jpg')
		repeat-x fixed center top;
	background-size: cover;
	margin-left: auto;
	margin-right: auto;
}

.module {
	position: relative;
	top: 5%;
	height: 180%;
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
	font-size: 18pt;
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
	bottom: 120px;
	right: 10px;
	padding: 10px;
	border-radius: 5px;
}

.logoutButton {
	bottom: 0px;
	position: absolute;
	width: 260px;
	left: 40%;
}

.listTabel {
	float: none;
	position: absolute;
	padding: 0;
	margin-top: 0;
	margin-left: 0;
	margin-right: 0;
	top: 150px;
	bottom: 80px;
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

.button1{
height: 50px;
	width: 100%;
	border-radius: 3px;
	border: rgba(0, 0, 0, .3) 0px solid;
	box-sizing: border-box;
	padding: 15px;
	margin-top: 15px;
	margin-left: 15px;
	margin-bottom: 30px;
	background: #90c843;
	color: #FFF;
	font-weight: bold;
	font-size: 18pt;
	transition: background .4s;
	cursor: pointer;
}
.name {
	width: 50px;
}

.user-icons {
	margin-left: 200px;
	display: inline-block;
}

.inputs {
	width: 100%;
	padding: 0 2%;
}
</style>
<script>
	$(function() {

	// Setup form validation on the #register-form element
	$("#dialogAddTest").validate({

		rules : {
			testName : "required",
		},

		messages : {
			testName : "Please enter your Yonder code ",

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
			<c:url var="addAction" value="/test/add"></c:url>
			<div id="dialogAddTest1" title="Add test" hidden='true'>
				<form:form action="${addAction}" commandName="testAdd"
					id="dialogAddTest" novalidate="novalidate">
					<c:if test="${not empty testAdd}">
						<table>
							<tr>
								<td></td>
								<td>Name:</td>
								<td><form:input path='name' class="inputs" name="testName"></form:input></td>
							</tr>
							<tr>
								<td></td>
								<td>Start:</td>
								<td><form:input path='startDate' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td></td>
								<td>For Class:</td>
								<td><form:select path='nameClass'>
										<form:options items="${classList}" />
									</form:select></td>
							</tr>
							<tr>
								<td></td>
								<td>First Question:</td>
								<td><form:input path='firstQuestion.question' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="firstQuestion.firstAnswer.good" />
								<td>Answer 1:</td>
								<td><form:input path='firstQuestion.firstAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="firstQuestion.secondAnswer.good" />
								<td>Answer 2:</td>
								<td><form:input path='firstQuestion.secondAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="firstQuestion.thirdAnswer.good" />
								<td>Answer 3:</td>
								<td><form:input path='firstQuestion.thirdAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="firstQuestion.fourthAnswer.good" />
								<td>Answer 4:</td>
								<td><form:input path='firstQuestion.fourthAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td></td>
								<td>Second Question:</td>
								<td><form:input path='secondQuestion.question' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="secondQuestion.firstAnswer.good" />
								<td>Answer 1:</td>
								<td><form:input path='secondQuestion.firstAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="secondQuestion.secondAnswer.good" />
								<td>Answer 2:</td>
								<td><form:input path='secondQuestion.secondAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="secondQuestion.thirdAnswer.good" />
								<td>Answer 3:</td>
								<td><form:input path='secondQuestion.thirdAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="secondQuestion.fourthAnswer.good" />
								<td>Answer 4:</td>
								<td><form:input path='secondQuestion.fourthAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td></td>
								<td>Third Question:</td>
								<td><form:input path='thirdQuestion.question' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="thirdQuestion.firstAnswer.good" />
								<td>Answer 1:</td>
								<td><form:input path='thirdQuestion.firstAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="thirdQuestion.secondAnswer.good" />
								<td>Answer 2:</td>
								<td><form:input path='thirdQuestion.secondAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="thirdQuestion.thirdAnswer.good" />
								<td>Answer 3:</td>
								<td><form:input path='thirdQuestion.thirdAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="thirdQuestion.fourthAnswer.good" />
								<td>Answer 4:</td>
								<td><form:input path='thirdQuestion.fourthAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td></td>
								<td>Fourth Question:</td>
								<td><form:input path='fourthQuestion.question' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="fourthQuestion.firstAnswer.good" />
								<td>Answer 1:</td>
								<td><form:input path='fourthQuestion.firstAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="fourthQuestion.secondAnswer.good" />
								<td>Answer 2:</td>
								<td><form:input path='fourthQuestion.secondAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="fourthQuestion.thirdAnswer.good" />
								<td>Answer 3:</td>
								<td><form:input path='fourthQuestion.thirdAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="fourthQuestion.fourthAnswer.good" />
								<td>Answer 4:</td>
								<td><form:input path='fourthQuestion.fourthAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td></td>
								<td>Fifth Question:</td>
								<td><form:input path='fifthQuestion.question' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="fifthQuestion.firstAnswer.good" />
								<td>Answer 1:</td>
								<td><form:input path='fifthQuestion.firstAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="fifthQuestion.secondAnswer.good" />
								<td>Answer 2:</td>
								<td><form:input path='fifthQuestion.secondAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="fifthQuestion.thirdAnswer.good" />
								<td>Answer 3:</td>
								<td><form:input path='fifthQuestion.thirdAnswer.answer' class="inputs"></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="fifthQuestion.fourthAnswer.good" />
								<td>Answer 4:</td>
								<td><form:input path='fifthQuestion.fourthAnswer.answer' class="inputs"></form:input></td>
							</tr>

							<tr></tr>
							<tr>
								<td></td>
								<td></td>
								<td colspan="2"><input name="submit" type="submit" class="button"
									value="Add Test" /></td>
							</tr>
						</table>
					</c:if>
				</form:form>
			</div>

			<div class="homepage">
				<a class="buttons" href="<c:url value='/startup' />"
					onclick='confirmUser()'> <img
					src="http://icons.iconarchive.com/icons/custom-icon-design/mono-general-3/72/home-icon.png"
					alt="Home" class="iconHome"></a>
			</div>

			<c:url var="addQuestionAction" value="/test/addQuestion/"></c:url>
			<div id="dialogAddQuestion" title="Add question" hidden='true'>
				<form:form action="${addQuestionAction}" commandName="questionAdd"
					id="register-form">
					<c:if test="${not empty questionAdd}">
						<table>
							<tr>
								<td></td>
								<td>First Question:</td>
								<td><form:input path='question'></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="firstAnswer.good" />
								<td>Answer 1:</td>
								<td><form:input path='firstAnswer.answer'></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="secondAnswer.good" />
								<td>Answer 2:</td>
								<td><form:input path='secondAnswer.answer'></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="thirdAnswer.good" />
								<td>Answer 3:</td>
								<td><form:input path='thirdAnswer.answer'></form:input></td>
							</tr>
							<tr>
								<td><form:checkbox path="fourthAnswer.good" />
								<td>Answer 4:</td>
								<td><form:input path='fourthAnswer.answer'></form:input></td>
								<td><form:input path='testId' type="hidden"></form:input></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td colspan="2"><input type="submit" class="button"
									value="Add Question" /></td>
							</tr>
						</table>
					</c:if>
				</form:form>
			</div>


			<c:url var="cloneAction" value="/test/clone"></c:url>
			<div id="dialogCloneQuestion" title="Clone test" hidden='true'>
				<form:form class="form" commandName="testClone" id="testCloneid"
					action="${cloneAction}">
					<c:if test="${not empty testClone}">
						<form:select path='nameClass'>
							<form:options items="${classList}" />
						</form:select>
						<form:input path='testId' type="hidden"></form:input>
						<input type="submit" class="button1" value="Create Test" />
					</c:if>
				</form:form>
			</div>


			<br>
			<div id="topListMenu" class="topListMenu">
				<div class="searchTest">
					<img
						src="http://icons.iconarchive.com/icons/custom-icon-design/office/48/add-2-icon.png"
						onclick='$("#dialogAddTest").dialog({width: 500});' alt=""
						class="iconAdd">
					<c:url var="searchAction" value="/test/search/"></c:url>
				</div>
				<form:form action="${searchAction}" commandName="testAdd"
					id="searchForm" class="searchForm">
					<span><form:input type="text" path="name" placeholder="Name"
							class="searchTest" style="width:20%" /></span>
					<span> <a class="searchTest"> <img
							src=" http://icons.iconarchive.com/icons/fasticon/isimple-system/128/search-icon.png"
							onclick='document.getElementById("searchForm").submit();' alt=""
							class="iconAdd">
					</a>
					</span>
				</form:form>
			</div>
			<c:if test="${!empty listTests}">
				<div class="listTabel">

					<ul class="list-group">
						<c:forEach items="${listTests}" var="test">

							<li class="list-group-item"><a class="buttons name"
								href="<c:url value='/test/get/${test.testId}' />">${test.name}</a>
								<div class="user-icons">
									<a class="buttons"
										href="<c:url value='/editTest/${test.testId}' />"> <img
										src=" http://icons.iconarchive.com/icons/fasticon/freestyle/48/pencil-icon.png"
										alt="Edit" class="iconAdd">
									</a> <a class="buttons" onclick='loadAddQuestion(${test.testId})'>
										<img
										src=" http://icons.iconarchive.com/icons/custom-icon-design/pretty-office-8/24/Comment-add-icon.png"
										alt="AddQuestion" class="iconAdd">
									</a> <a class="buttons"
										href="<c:url value='/test/remove/${test.testId}' />"
										onclick='confirmUser()'> <img
										src="http://icons.iconarchive.com/icons/dryicons/aesthetica-2/48/user-remove-icon.png"
										alt="Remove" class="iconAdd">
									</a> <a class="buttons" onclick='loadCloneQuestion(${test.testId})'>
										<img
										src="http://icons.iconarchive.com/icons/hopstarter/soft-scraps/24/Document-Copy-icon.png"
										alt="Clone" class="iconAdd">
									</a>

								</div></li>
						</c:forEach>
					</ul>
				</div>
			</c:if>

			<div class="logoutButton">
				<c:url value="/j_spring_security_logout" var="logoutUrl" />
				<form action="${logoutUrl}" method="post" id="logoutForm"></form>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<h4>
						<a class="button" href="javascript:formSubmit()">Logout</a>

					</h4>
				</c:if>

			</div>

			<div class="rightPanel">
				<c:if test="${not empty testB}">
					<table>
						<tr>
							<td>ID:</td>
							<td>${testB.testId}</td>
						</tr>
						<tr>
							<td>Name:</td>
							<td>${testB.name}</td>
						</tr>
						<tr>
							<td>Start date:</td>
							<td>${testB.startDate}</td>
						</tr>
						<c:forEach items="${testB.questions}" varStatus="status"
							var="quest">
							<tr>
								<td></td>
								<td>Question:</td>
								<td>${quest.text}</td>
							</tr>
							<c:forEach items="${quest.answers}" varStatus="loop" var="answer">
								<tr>
									<td>${answers.good}</td>
									<td>Answer:</td>
									<td>${answer.answer}</td>
							</c:forEach>
						</c:forEach>


					</table>
				</c:if>
			</div>
		</div>
	</div>


	<script>
				function loadAddQuestion(id) {
					$('input[name="testId"]', '#dialogAddQuestion').val(id)
					$("#dialogAddQuestion").dialog({width: 400});
				}
			</script>

	<script>
				function loadCloneQuestion(id) {
					$('input[name="testId"]', '#dialogCloneQuestion').val(id)
					$("#dialogCloneQuestion").dialog();
				}
			</script>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
</body>

</html>