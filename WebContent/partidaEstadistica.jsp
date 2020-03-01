<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Informacion de partida</title>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
src="https://code.jquery.com/jquery-3.4.1.js"
integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
crossorigin="anonymous"></script>
<script src="source/script.js"></script>
<link href="source/estilo.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet"> 

<title>SpaceY</title>
</head>
<body>

<%@ include file="includes/header.jsp" %>

<%@ page import="Modelo.Tools" %>
<%@ page import="Modelo.EstadisticaData" %>

<%

	

	Tools tl = new Tools();

	ArrayList<EstadisticaData> statData = new ArrayList<EstadisticaData>();
	statData = (ArrayList<EstadisticaData>) request.getAttribute("estadisticaData");
	
	EstadisticaData equipoRojo;
	EstadisticaData equipoAzul;
	
	if(statData.get(0).equipo == "rojo"){
		equipoRojo = statData.get(0);
		equipoAzul = statData.get(1);
	} else {
		equipoRojo = statData.get(1);
		equipoAzul = statData.get(0);
	}
	
%>
	<main class="main">
		<section class="container">
			<span class="winner">Vencedor: <% out.println(request.getAttribute("vencedor")); %></span>
			<table class="statistics" cellspacing="0">
				<thead>
					<tr>
						<th></th>
						<th><% out.println(equipoRojo.nombre);  %></th>
						<th><% out.println(equipoAzul.nombre); %></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>Naves seleccionadas</th>
						<th></th>
						<th></th>
					</tr>
					<tr>
						<td>Viper</td>
						<td><% out.println(equipoRojo.cantidad_viper); %></td>
						<td><% out.println(equipoAzul.cantidad_viper); %></td>
					</tr>
					<tr>
						<td>Escolta</td>
						<td><% out.println(equipoRojo.cantidad_escolta); %></td>
						<td><% out.println(equipoAzul.cantidad_escolta); %></td>
					</tr>
					<tr>
						<td>Linea</td>
						<td><% out.println(equipoRojo.cantidad_linea); %></td>
						<td><% out.println(equipoAzul.cantidad_linea); %></td>
					</tr>
					<tr>
						<th>Supervivientes</th>
						<th></th>
						<th></th>
					</tr>
					<tr>
						<td>Viper</td>
						<td><% out.println(equipoRojo.superviviente_viper); %></td>
						<td><% out.println(equipoAzul.superviviente_viper); %></td>
					</tr>
					<tr>
						<td>Escolta</td>
						<td><% out.println(equipoRojo.superviviente_escolta); %></td>
						<td><% out.println(equipoAzul.superviviente_escolta); %></td>
					</tr>
					<tr>
						<td>Linea</td>
						<td><% out.println(equipoRojo.superviviente_linea); %></td>
						<td><% out.println(equipoAzul.superviviente_linea); %></td>
					</tr>
					<tr>
						<th>Estadistica</th>
						<th></th>
						<th></th>
					</tr>
					<tr>
						<td>Daño emitido</td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoRojo.dano_emitido))); %></td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoAzul.dano_emitido))); %></td>
					</tr>
					<tr>
						<td>Daño recibido</td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoRojo.dano_recibido))); %></td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoAzul.dano_recibido))); %></td>
					</tr>
					<tr>
						<td>Daño mitigado</td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoRojo.dano_mitigado))); %></td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoAzul.dano_mitigado))); %></td>
					</tr>
					<tr>
						<td>Disparos acertados</td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoRojo.disparo_acertado))); %></td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoAzul.disparo_acertado))); %></td>
					</tr>
					<tr>
						<td>Disparos fallados</td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoRojo.disparo_fallido))); %></td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoAzul.disparo_fallido))); %></td>
					</tr>
					<tr>
						<td>Disparos evadidos</td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoRojo.disparo_evadido))); %></td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoAzul.disparo_evadido))); %></td>
					</tr>
					<tr>
						<td>Disparos totales</td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoRojo.disparo_total))); %></td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoAzul.disparo_total))); %></td>
					</tr>
					<tr>
						<td>Poder militar</td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoRojo.poder_militar))); %></td>
						<td><% out.println(tl.clearNumber(Long.toString(equipoAzul.poder_militar))); %></td>
					</tr>
				</tbody>
			</table>
        </section>
    </main>
    <%@ include file="includes/footer.jsp" %>
</body>
</html>