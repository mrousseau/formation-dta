<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edition de pizza</title>

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
	<%
		Pizza p = (Pizza) request.getAttribute("pizza");
	%>

	<header>
	<h1>
		Modification de la pizza :
		<%=p.getNom().toUpperCase()%></h1>
	</header>
	<div class="row formulaire_modi_pizza">
		<form method="post">
			<div class="form-group ">
				<div class="col-md-12" ><label class="col-md-offset-2 col-md-2">Code</label><input class="col-md-6" type="text" name="id" placeholder="ID de la pizza" value="<%=p.getId()%>" /></div>
				<div class="col-md-12" ><label class="col-md-offset-2 col-md-2">Code</label><input class="col-md-6" type="text" name="code" placeholder="Code de la pizza" value="<%=p.getCode()%>" /></div> 
				<div class="col-md-12" ><label class="col-md-offset-2 col-md-2">Nom</label><input class="col-md-6" type="text" name="nom" placeholder="Nom de la pizza" value="<%=p.getNom()%>" /></div> 
				<div class="col-md-12" ><label class="col-md-offset-2 col-md-2">Prix</label><input class="col-md-6" type="text" name="prix" placeholder="Prix de la pizza" value="<%=p.getPrix()%>" /></div>
				<div class="col-md-12" ><label class="col-md-offset-2 col-md-2">Categorie</label><input class="col-md-6" type="text" name="categorie" placeholder="Prix de la pizza" value="<%=p.getCategoriePizza().getValue()%>" /></div>
				<div class="col-md-12" ><label class="col-md-offset-2 col-md-2">url</label><input class="col-md-6" type="text" name="url" placeholder="Image de la pizza" value="<%=p.getUrl()%>" /></div>
				<div class="col-md-12">
					<img src="<%=p.getUrl()%>" class="col-md-offset-4 col-md-4"/>
				</div>
			</div>
			<button type=submit class="btn btn-success col-md-offset-2 col-md-8 toUP" >Valider</button>
		</form>
	</div>
</body>
</html>