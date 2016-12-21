
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
	<header>
		<h1>Gestionnaire de Pizzeria</h1>
	</header>
	<div class="col-lg-offset-2 col-md-8 container_list_pizza">
		
		<h2>Liste de pizzas</h2>
		<button class="btn btn-success" >Ajouter une pizza</button> <button class="btn btn-success" >Retour</button>
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
					<td><a type="button" class="col-md-offset-0s btn btn-warning" href="<%=request.getContextPath() %>/pizzas/edit?pizzasID=<%=item.getId()%>">Editer</a> <a type="button" class="col-md-offset-1 btn btn-danger">Supprimer</a>
					</td>
				</tr>
				<%
					}
					;
				%>
			</tbody>
		</table>
	</div>


	<%-- 	<div class="table_pizza">
		<h1></h1>
		<div class="row">
			<div class="col-lg-offset-2 col-md-8">
				<div class="col-md-1">Id.</div>
				<div class="col-md-1">Code</div>
				<div class="col-md-2">Nom</div>
				<div class="col-md-2">Prix</div>
				<div class="col-md-2">Image</div>
				<div class="col-md-4">
					<p>Action</p>
				</div>
				<%
					ArrayList<Pizza> alPizzas = (ArrayList<Pizza>) request.getAttribute("listePizzas");
					for (Pizza item : alPizzas) {
				%>
				<div class="col-md-1"><%=item.getId()%></div>
				<div class="col-md-1"><%=item.getCode()%></div>
				<div class="col-md-2"><%=item.getNom()%></div>
				<div class="col-md-2"><%=item.getPrix()%></div>
				<div class="col-md-2">
					<img class="col-md-12" src="<%=item.getUrl()%>" />
				</div>
				<div class="col-md-4">
					<button type="button" class="btn btn-success">Ajouter</button>
					<p></p>
					<button type="button" class="btn btn-success">Supprimer</button>
				</div>

				<%
					}
					;
				%>
			</div>
		</div>
	</div> --%>
</body>
</html>