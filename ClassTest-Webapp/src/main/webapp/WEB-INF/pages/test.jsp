<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<script
	src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<title>Person Page</title>

<link
	href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css"
	rel="stylesheet">
<script
	src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
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
.searchPerson {
  float: left;
  margin-left: 10;
  margin-top: 0;
  margin-bottom: 30;
}
.searchForm{
  margin-top: 50;
}

.listTabel{
  float: right;
  position: absolute;
  display: block;
  padding: 10px 15px;
  margin-top: 25;
  margin-left: 10;
  margin-right: 250;
  }
  
  .buttons{
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
  .rightPanel{
  float:left;
  margin-left: 250;
  margin-top: 50;
  }
  
  .nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover {
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
		url('http://stolenbabiestheband.com/wp-content/uploads/2012/12/sbSiteBackgroundPaper.jpg')  repeat-x fixed center top;
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
.name{
 width: 50px;
}
.user-icons{
	margin-left: 200px;
	display:inline-block;
}
</style>

<script>
	$(function() {

		// Setup form validation on the #register-form element
		$("#register-form").validate({

			rules : {
				person_id : "required",
				name : "required",
				address : "required",
				phone : "required",
				recruiterId : "required",
				action : "required",
				sourceChanel : "required",

			},

			messages : {
				person_id : "Please enter your Yonder code ",
				name : "Please enter your name ",
				address : "Please enter your address ",
				phone : "Please enter your phone no. ",
				recruiterId : "Please enter your recruiterId ",
				action : "Please enter  action ",
				sourceChanel : "Please enter source channel. ",

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
		<div>
		
		<ul class="nav nav-tabs">
  <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
					<li role="presentation" class="active"><a><img src="http://i.imgur.com/Fk1Urva.png"
						onclick="location.href='employees'" alt="" class="icon" /></a></li>
</c:if>
		
				<c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
					<li role="presentation" ><a><img src="http://i.imgur.com/Fk1Urva.png"
						onclick="location.href='employees'" alt="" class="icon" /></a></li>
			
			</c:if>
	
				<c:if test="${pageContext.request.isUserInRole('ROLE_HR')}">
					<li role="presentation" class="active"><a><img src="http://i.imgur.com/Fk1Urva.png"
						onclick="location.href='hremployees'" alt="" class="icon" /></a></li>
			</c:if>
			
		
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<li role="presentation">
					<a><span  onclick="javascript:formSubmit()">Logout</span></a>
					</li>
			</c:if>
			</ul>
		
		

</div>
			<c:url var="addAction" value="/persons/add"></c:url>
			<div id="dialogAddPerson" title="Add person" hidden='true'>
			<form:form action="${addAction}"  commandName="personAdd"
				id="register-form" novalidate="novalidate">
			<c:if test="${not empty personAdd}">
				<table>
					<tr>
						<td>Name:</td>
						<td><form:input path='name'></form:input></td>
					</tr>
					<tr>
						<td>Surname:</td>
						<td><form:input path='surname'></form:input></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><form:input path='email'></form:input></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><form:input path='address'></form:input></td>
					</tr>

					<tr>
						<td>Phone:</td>
						<td><form:input path='phone'></form:input></td>

					</tr>

					<tr>
						<td>Recruiter id:</td>
						<td><form:input path='recruiterCode'></form:input></td>

					</tr>
					<tr>
						<td>Action:</td>
						<td><form:input path='action'></form:input></td>
					</tr>
					<tr>
						<td>Source Channel:</td>
						<td><form:input path='sourceChanel'></form:input></td>
					</tr>
					<tr>
					<tr>
						<td>Last Contact:</td>
						<td><form:input path='date'></form:input></td>
					</tr>
						<td colspan="2">
								<input type="submit" class="button" value="Add Person" />
						</td>
					</tr>
				</table>
				</c:if>
			</form:form>
			</div>
			<c:url var="editAction" value="/persons/edit"></c:url>
		<c:if test="${not empty personEdit}">
		<div class="rightPanelEdit">
			<form:form action="${editAction}" class="form" commandName="personEdit"
				id="register-form" novalidate="novalidate">
			
				<table>
						<tr>
							<td><form:label path="person_id">
									<spring:message text="ID" />
								</form:label></td>
							<td><form:input path="person_id" size="8"
									disabled="true" /> <form:hidden path="person_id" /></td>
						</tr>	

					<tr>
						<td>Name:</td>
						<td><form:input path='name'></form:input></td>
					</tr>
					<tr>
						<td>Surname:</td>
						<td><form:input path='surname'></form:input></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><form:input path='email'></form:input></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><form:input path='address'></form:input></td>
					</tr>

					<tr>
						<td>Phone:</td>
						<td><form:input path='phone'></form:input></td>

					</tr>

					<tr>
						<td>Recruiter id:</td>
						<td><form:input path='recruiterCode'></form:input></td>

					</tr>
					<tr>
						<td>Action:</td>
						<td><form:input path='action'></form:input></td>
					</tr>
					<tr>
						<td>Source Channel:</td>
						<td><form:input path='sourceChanel'></form:input></td>
					</tr>
					<tr>
						<td>Last contact:</td>
						<td><form:input path='date'></form:input></td>
					</tr>
					<tr>
						<td colspan="2">
								<input type="submit" class="button" value="Edit Person" />
						</td>
					</tr>
				</table>
			</form:form>
			</div>
			</c:if>
			<c:url var="addInterviewAction" value="/persons/addInterview"></c:url>

			<div id="dialogInterview" title="Assign Interview" hidden='true'>
			
			<form:form class="form" commandName="InterviewUI1" id="interviewFormId"			
					action="${addInterviewAction}">
							<c:if test="${not empty InterviewUI1}">
					<form:select path='code'>
						<form:options items="${EmployeesList1}" />
					</form:select>
					<form:select path='interviewType'>
						<form:options items="${TypeList}" />
					</form:select>
					<form:input path='id' type="hidden"></form:input>
					<div>Date:</div>
					<form:input path='date'></form:input>
					<input type="submit" class="button" value="Add Interview" />
					</c:if>
				</form:form>
			</div>

			<br>
			<div id="topListMenu" class="topListMenu">
			<div class="searchPerson">
		 <img src="http://icons.iconarchive.com/icons/custom-icon-design/office/48/add-2-icon.png" onclick='$("#dialogAddPerson").dialog({width: 500});' alt="" class="iconAdd">
			<c:url var="searchAction" value="/persons/search/"></c:url>
			</div>
			<form:form action="${searchAction}"  commandName="personAdd" id="searchForm" class="searchForm">
						<span><form:input type="text" path="name" placeholder="Name" class="searchPerson" style="width:20%"/></span>
						<span>
						  <a class="searchPerson">
						  <img src=" http://icons.iconarchive.com/icons/fasticon/isimple-system/128/search-icon.png" onclick='document.getElementById("searchForm").submit();' alt="" class="iconAdd">
            </a>
            </span>
			</form:form>
		</div>
			<c:if test="${!empty listPersons}">
			<div  class="listTabel">
			
			<ul class="list-group">
					<c:forEach items="${listPersons}" var="person">
					
					<li class="list-group-item">
							<a class="buttons name"
								href="<c:url value='/persons/get/${person.person_id}' />"
								>${person.name}</a>
							<div class="user-icons">
							<a class="buttons"
								href="<c:url value='/persons/edit/${person.person_id}' />"
								>
											  <img src=" http://icons.iconarchive.com/icons/fasticon/freestyle/48/pencil-icon.png" alt="Edit" class="iconAdd">
								</a>
							<a class="buttons"
								href="<c:url value='/persons/remove/${person.person_id}' />"
								onclick='confirmUser()'>
											  <img src="http://icons.iconarchive.com/icons/dryicons/aesthetica-2/48/user-remove-icon.png" alt="Remove" class="iconAdd">
								</a>
							<c:if test="${pageContext.request.isUserInRole('ROLE_HR')}">
								<a class="buttons"
									href="<c:url value='/CVs/${person.person_id}' />"
									>
												  <img src="http://icons.iconarchive.com/icons/fasticon/green-ville/48/folder-documents-icon.png" alt="Upload CV" class="iconAdd">
								
									</a>
							</c:if>
							<c:if test="${pageContext.request.isUserInRole('ROLE_HR')}">
								<a class="buttons"
									href="<c:url value='/CVView/${person.person_id}' />"
									>
												  <img src="http://icons.iconarchive.com/icons/danrabbit/elementary/48/Document-download-icon.png" alt="View CV" class="iconAdd">
								
									</a>
							</c:if>

							<c:if test="${pageContext.request.isUserInRole('ROLE_HR')}">
								<a class="buttons" onclick='loadAddInterview(${person.person_id})'>
											  <img src="http://icons.iconarchive.com/icons/ampeross/qetto-2/48/add-contact-icon.png" alt="Assign Interview" class="iconAdd" >
								
									
								</a>
							</c:if>
							</div>
						</li>
					</c:forEach>
				</ul>
				    </div>
			</c:if>

		
			<c:if test="${not empty listPersonsSearch}">
				<h2>list search pers</h2>
				<table class="tg">
					<tr>

						<th width="80">Person Name</th>
						<th width="80">Person Surname</th>
						<th width="80">Email</th>
						<th width="100">Address</th>
						<th width="80">Phone</th>
						<th width="40">Recruiter Code</th>
						<th width="70">Action</th>
						<th width="80">LastContact</th>
					</tr>

					<c:forEach items="${listPersonsSearch}" var="person">
						<tr>
							<td>${person.name}</td>
							<td>${person.surname}</td>
							<td>${person.email}</td>
							<td>${person.address}</td>
							<td>${person.phone}</td>
							<td>${person.recruiterCode}</td>
							<td>${person.action }</td>
							<td>${person.sourceChanel}</td>
							<td>${person.lastDateContact}</td>
					</c:forEach>
					</tr>
				</table>
			</c:if>


			<c:url value="/j_spring_security_logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm"></form>

			<script>
				function loadAddInterview(id) {
					$('input[name="id"]', '#dialogInterview').val(id)
					$("#dialogInterview").dialog();
					
				}
				
			</script>
			<script>
				function confirmUser() {

					var ask = confirm("Are you sure");

					if (!ask) {
						'redirect:/persons';
				   }
				}
			</script>
			<script>
				function formSubmit() {
					document.getElementById("logoutForm").submit();
				}
			</script>
<div class="rightPanel">
			<c:if test="${not empty personB}">
				<table>
					<tr>
						<h3>ID: ${personB.person_id}</h3>
						<h3>Name:${personB.name}</h3>
						<h3>Surname:${personB.surname}</h3>
						<h3>Email:${personB.email}</h3>
						<h3>Address:${personB.address}</h3>
						<h3>Phone:${personB.phone}</h3>
						<h3>Recruiter Code:${personB.recruiterCode}</h3>
						<h3>Action:${personB.action}</h3>
						<h3>SourceChannel;${personB.sourceChanel}</h3>
						<h3>Last contact:${personB.date}</h3>
						
						<br>
						<br>
					</tr>
				</table>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>