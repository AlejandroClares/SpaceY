<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

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

<%@ page import="Juego.Jugador" %>
<%@ page import="Modelo.Tools" %>

<%@ include file="includes/header.jsp" %>
	
	<main class="main">
		<section class="container">
	
			<span class="winner">Vencedor: <% out.println(request.getAttribute("ganador")); %></span>
		
			<% 
			Jugador rojo = (Jugador) request.getAttribute("rojo");
			Jugador azul = (Jugador) request.getAttribute("azul");
			Tools tl = new Tools();
			%>
		
			<table class="statistics" cellspacing="0">
				<thead>
					<tr>
						<th></th>
						<th><% out.println(azul.getNombre()); %></th>
						<th><% out.println(rojo.getNombre()); %></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>Unidades seleccionadas</th>
						<th></th>
						<th></th>
					</tr>
					<tr>
						<td>Viper</td>
						<td><% out.println( tl.clearNumber(Integer.toString(azul.getStats().getCantidadVipers()))); %></td>
						<td><% out.println( tl.clearNumber(Integer.toString(rojo.getStats().getCantidadVipers()))); %></td>
					</tr>
					<tr>
						<td>Escolta</td>
						<td><% out.println( tl.clearNumber(Integer.toString(azul.getStats().getCantidadEscoltas()))); %></td>
						<td><% out.println( tl.clearNumber(Integer.toString(rojo.getStats().getCantidadEscoltas()))); %></td>
					</tr>
					<tr>
						<td>Linea</td>
						<td><% out.println( tl.clearNumber(Integer.toString(azul.getStats().getCantidadLineas()))); %></td>
						<td><% out.println( tl.clearNumber(Integer.toString(rojo.getStats().getCantidadLineas()))); %></td>
					</tr>
					<tr>
						<th>Supervivientes</th>
						<th></th>
						<th></th>
					</tr>
					<tr>
						<td>Viper</td>
						<td><% out.println( tl.clearNumber(Integer.toString(azul.getCantidadViper()))); %></td>
						<td><% out.println( tl.clearNumber(Integer.toString(rojo.getCantidadViper()))); %></td>
					</tr>
					<tr>
						<td>Escolta</td>
						<td><% out.println( tl.clearNumber(Integer.toString(azul.getCantidadEscoltas()))); %></td>
						<td><% out.println( tl.clearNumber(Integer.toString(rojo.getCantidadEscoltas()))); %></td>
					</tr>
					<tr>
						<td>Linea</td>
						<td><% out.println( tl.clearNumber(Integer.toString(azul.getCantidadLineas()))); %></td>
						<td><% out.println( tl.clearNumber(Integer.toString(rojo.getCantidadLineas()))); %></td>
					</tr>
					<tr>
						<th>Estadistica</th>
						<th></th>
						<th></th>
					</tr>
					<tr>
						<td>Daño emitido</td>
						<td><% out.println( tl.clearNumber(Long.toString(azul.getStats().getDaño_emitido()))); %></td>
						<td><% out.println( tl.clearNumber(Long.toString(rojo.getStats().getDaño_emitido()))); %></td>
					</tr>
					<tr>
						<td>Daño recibido</td>
						<td><% out.println( tl.clearNumber(Long.toString(azul.getStats().getDaño_recibido()))); %></td>
						<td><% out.println( tl.clearNumber(Long.toString(rojo.getStats().getDaño_recibido()))); %></td>
					</tr>
					<tr>
						<td>Daño mitigado</td>
						<td><% out.println( tl.clearNumber(Long.toString(azul.getStats().getDaño_mitigado()))); %></td>
						<td><% out.println( tl.clearNumber(Long.toString(rojo.getStats().getDaño_mitigado()))); %></td>
					</tr>
					<tr>
						<td>Disparos acertados</td>
						<td><% out.println( tl.clearNumber(Long.toString(azul.getStats().getDisparos_acertados()))); %></td>
						<td><% out.println( tl.clearNumber(Long.toString(rojo.getStats().getDisparos_acertados()))); %></td>
					</tr>
					<tr>
						<td>Disparos fallados</td>
						<td><% out.println( tl.clearNumber(Long.toString(azul.getStats().getDisparos_fallidos()))); %></td>
						<td><% out.println( tl.clearNumber(Long.toString(rojo.getStats().getDisparos_fallidos()))); %></td>
					</tr>
					<tr>
						<td>Disparos evadidos</td>
						<td><% out.println( tl.clearNumber(Long.toString(azul.getStats().getDisparos_evadidos()))); %></td>
						<td><% out.println( tl.clearNumber(Long.toString(rojo.getStats().getDisparos_evadidos()))); %></td>
					</tr>
					<tr>
						<td>Disparos totales</td>
						<td><% out.println( tl.clearNumber(Long.toString(azul.getStats().getCantidad_disparos()))); %></td>
						<td><% out.println( tl.clearNumber(Long.toString(rojo.getStats().getCantidad_disparos()))); %></td>
					</tr>
					<tr>
						<td>Poder militar</td>
						<td><% out.println(request.getAttribute("poder_militar_azul")); %></td>
						<td><% out.println(request.getAttribute("poder_militar_rojo")); %></td>
					</tr>
				</tbody>
			</table>
		</section>
	</main>
	<%@ include file="includes/footer.jsp" %>

</body>
</html>