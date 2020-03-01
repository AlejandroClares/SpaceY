<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

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

<%@ page import="Modelo.PartidaData" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Modelo.Tools" %>

<%@ include file="includes/header.jsp" %>

	<main class="main">
		<section class="container">
			<table class="history" cellspacing="0">
                       <thead>
                           <tr>
                               <th>ID</th>
                               <th>Victoria</th>
                               <th>Derrota</th>
                               <th>Fecha</th>
                               <th></th>
                           </tr>
                       </thead>
                       <tbody>
                       	<%
						ArrayList<PartidaData> partidaData = new ArrayList<PartidaData>(); 
						partidaData = (ArrayList<PartidaData>) request.getAttribute("partidaData");
					
						for(PartidaData partida : partidaData){
							
							out.println("<tr>");
								out.println("<td>"+ partida.id +"</td>");
								out.println("<td>"+ partida.vencedor +"</td>");
								out.println("<td>"+ partida.derrotado +"</td>");
								out.println("<td>"+ partida.fecha +"</td>");
								out.println("<td>"
										+"<a href=\"HistorialPartida?id="+partida.id+"\">"
											+"<svg version='1.1' id='Capa_1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' x='0px' y='0px'"
		                                        +"width='91.488px' height='91.487px' viewBox='0 0 91.488 91.487' style='enable-background:new 0 0 91.488 91.487;'"
		                                        +"xml:space='preserve'>"
		                                        +"<polygon points='34.606,15.522 26.855,15.522 26.855,27.159 15.22,27.159 15.22,34.91 26.855,34.91 26.855,46.547 34.606,46.547 34.606,34.91 46.244,34.91 46.244,27.159 34.606,27.159'/>"
		                                        +"<path d='M89.427,79.458L57.425,47.453c7.617-12.207,5.889-28.083-4.392-38.366C47.175,3.228,39.373,0,31.062,0"
												+"C22.752,0,14.951,3.228,9.09,9.087c-5.86,5.858-9.088,13.662-9.088,21.973c0,8.308,3.228,16.111,9.088,21.97"
		                                        +"c5.847,5.849,13.636,9.069,21.931,9.069c5.867,0,11.514-1.613,16.437-4.681L79.46,89.424c1.332,1.332,3.102,2.063,4.982,2.063"
		                                        +"c1.88,0,3.648-0.731,4.982-2.063C92.173,86.672,92.171,82.203,89.427,79.458z M30.862,51.112"
		                                        +"c-11.186,0-20.286-9.102-20.286-20.283c0-11.186,9.101-20.287,20.286-20.287s20.284,9.102,20.284,20.287"
		                                        +"C51.146,42.011,42.047,51.112,30.862,51.112z'/>"
	                                    	+"</svg>"
										+"</a></td>");
							out.println("</tr>");
						
						}
						%>
			    </tbody>
			</table>
        </section>
    </main>
    <%@ include file="includes/footer.jsp" %>
</body>
</html>