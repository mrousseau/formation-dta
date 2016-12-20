
<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.ArrayList"%>
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
</head>
<body class="container-fuild">
	<h1>Liste de pizzas :</h1>

	<div class="row">
		<div class="offset-lg-2 col-md-8">
			<p class="col-md-2">Id.</p>
			<p class="col-md-2">Code</p>
			<p class="col-md-2">Nom</p>
			<p class="col-md-2">Prix</p>
			<div class="col-md-8">Image</div>
			<%
				ArrayList<Pizza> alPizzas = (ArrayList<Pizza>) request.getAttribute("listePizza");
				for (Pizza p : alPizzas) {
			%>
			<p class="col-md-2"><% p.getId(); %></p>
			<p class="col-md-2"><% p.getCode(); %></p>
			<p class="col-md-2"><% p.getNom(); %></p>
			<p class="col-md-2"><% p.getPrix(); %></p>
			<div class="col-md-8">Image</div>

			<%
				}
				;
			%>
		</div>
	</div>
</body>
</html>