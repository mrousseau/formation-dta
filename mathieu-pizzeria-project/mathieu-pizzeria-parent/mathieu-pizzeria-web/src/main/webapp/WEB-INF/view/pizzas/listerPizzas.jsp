
<%@page import="fr.pizzeria.model.Pizza"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="bg_white">
		<header>
			<h1>Gestionnaire de Pizzeria</h1>
		</header>
		<div class="col-lg-offset-2 col-md-8 container_list_pizza">
			
			<h2>Liste de pizzas</h2>
			<a type="button" class="col-md-offset-0s btn btn-primary" href="<%=request.getContextPath() + "/pizzas/create"%>">Ajouter une pizza</a> <a type="button" class="col-md-offset-0s btn btn-primary" href="<%=request.getContextPath() + request.getAttribute("link")%>"><%=request.getAttribute("btnList")%></a>
			<table class="table table-bordered tableau_pizza">
				<thead>
					<tr>
						<th class="col-md-1">Id.</th>
						<th class="col-md-1">Code</th>
						<th class="col-md-2">Nom</th>
						<th class="col-md-2">Prix</th>
						<th class="col-md-2">Picture</th>
						<th class="col-md-4"></th>
					</tr>
				</thead>
				<tbody>
					<% 
						ArrayList<Pizza> alPizzas = (ArrayList<Pizza>) request.getAttribute("listePizzas");
						for (Pizza item : alPizzas) {
					%>
					<tr>
						<td><%=item.getId()%></td>
						<td><%=item.getCode()%></td>
						<td><%=item.getNom()%></td>
						<td><%=item.getPrix()%></td>
						<td><img src="<%=item.getUrl()%>" class="col-md-12" alt="image de pizza"></td>
						<td><a type="button" class="col-md-offset-0s btn btn-warning" href="<%=request.getContextPath() %>/pizzas/edit?pizzasID=<%=item.getId()%>">Editer</a> <a type="button" class="col-md-offset-1 btn btn-danger" href="<%=request.getContextPath() %>/pizzas/delete?pizzasID=<%=item.getId()%>">Supprimer</a>
						</td>
					</tr>
					<%
						};
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>