<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des clients</title>
	<script src="https://code.jquery.com/jquery-3.1.1.js"
		integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
		crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/dist/css/bootstrap.min.css">
<!-- Optional theme -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/dist/css/bootstrap-theme.min.css">
<!-- Latest compiled and minified JavaScript -->
<script src="<%=request.getContextPath()%>/dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/dist/app.css">

</head>
<body class="container-fuild">


	<div class="bg_white">
		<header>
			<h1>Gestionnaire de Pizzeria</h1>
		</header>
		<div class="col-lg-offset-2 col-md-8 container_list_pizza">
			
			<h2>Liste de clients</h2>
			
			<table class="table table-bordered tableau_pizza">
				<thead>
					<tr>
						<th class="col-md-2 hidden">Id.</th>
						<th class="col-md-2">Nom</th>
						<th class="col-md-2">Prenom</th>
						<th class="col-md-2">Adresse</th>
						<th class="col-md-2">Téléphone</th>
						<th class="col-md-2">Date de naissance</th>
					</tr>
				</thead>
				<tbody id="row" style="background-color: gray; ">
				</tbody>

	<script>
		(function() {
			var flickerAPI = "http://localhost:8080/mathieu-pizzeria-web/api/rest/clients";
			$.getJSON(flickerAPI, {
				format : "json"
			}).done(function(data) {
				console.log(data);
				$.each(data, function(i, item) {
					 $("#row").append('<tr>').append('<td>'+ item.id +'</td>').append('<td>'+ item.nom +'</td>').append('<td>'+ item.prenom +'</td>').append('<td>'+ item.telephone +'</td>').append('<td>'+ new Date(item.dateNaissance*1000).getDay() + new Date(item.dateNaissance).getDate() +' ' + new Date(item.dateNaissance).getMonth() + ' ' + new Date(item.dateNaissance).getFullYear() + ' ' +  +'</td>').append('</tr>');
				});
			});
		})();
	</script>

</body>
</html>