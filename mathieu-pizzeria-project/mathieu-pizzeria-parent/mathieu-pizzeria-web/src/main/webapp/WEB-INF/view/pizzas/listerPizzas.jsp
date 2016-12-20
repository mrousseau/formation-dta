
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/dist/app.css">

</head>
<body class="container-fuild">
	<div class="table_pizza">
		<h1>Liste de pizzas</h1>
		<div class="row">
			<div class="col-lg-offset-2 col-md-8">
				<div class="col-md-2">Id.</div>
				<div class="col-md-2">Code</div>
				<div class="col-md-2">Nom</div>
				<div class="col-md-2">Prix</div>
				<div class="col-md-4">Image</div>
				<%
					ArrayList<Pizza> alPizzas = (ArrayList<Pizza>) request.getAttribute("listePizzas");
				%>
				<!--<p><%=alPizzas.stream().count()%></p>-->

				<%
					for (Pizza item : alPizzas) {
				%>
				<div class="col-md-2"><%=item.getId()%></div>
				<div class="col-md-2"><%=item.getCode()%></div>
				<div class="col-md-2"><%=item.getNom()%></div>
				<div class="col-md-2"><%=item.getPrix()%></div>
				<div class="col-md-4">
					<p>Image</p>
				</div>

				<%
					}
					;
				%>
			</div>
		</div>
	</div>
</body>
</html>