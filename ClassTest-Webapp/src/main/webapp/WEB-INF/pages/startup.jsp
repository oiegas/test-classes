<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Choose</title>
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
	top: -5px;
	left: 0px;
	right: 0px;
	bottom: 0px;
	width: auto;
	height: auto;
	background-image:
		url(http://fc09.deviantart.net/fs20/i/2008/034/3/4/Cluj_Napoca_night_Panorama_by_Andrei_Joldos.jpg);
	background-size: cover;
	z-index: 0;
}
.submit {
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

.submit:hover {
	opacity: 0.8;
}
</style>
</head>
<body>

	<div class="body">
	<div align="center">
	<input type="button" class="submit"  onclick="location.href='test'" value="Test" >
    <input type="button" class="submit" onclick="location.href='class'" value="Classes" >
    <input type="button" class="submit" onclick="location.href='user'" value="Users" >


	</div>	
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | 
			<a href="javascript:formSubmit()" class="submit"> Logout </a>
		</h2>
	</c:if>
	</div>
</body>
</html>

