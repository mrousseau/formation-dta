<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/dist/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/dist/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="<%=request.getContextPath()%>dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/dist/app.css">

</head>
<body class="container">
	<div class="auth">
		<form method="post">
				<div class="form-group ">
					<div class="col-md-12" ><label class="col-md-offset-2 col-md-2">Login</label><input class="col-md-offset-1 col-md-6" type="text" name="login" placeholder="Login" /></div>
					<div class="col-md-12" ><label class="col-md-offset-2 col-md-2">Mot de passe</label><input class="col-md-offset-1 col-md-6" type="text" name="mdp" placeholder="Mot de passe" /></div> 
				</div>
				<button type=submit class="btn btn-success col-md-offset-2 col-md-9 toUP" >Valider</button>
		</form>
	</div>
</body>
</html>