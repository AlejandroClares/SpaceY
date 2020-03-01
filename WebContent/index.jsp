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

	<%@ include file="includes/header.jsp" %>
	
	<main class="main">
		<section class="container">
			<form class="play" action="Jugar" method="POST">
			<% 
				String mensaje = (String) request.getAttribute("error");
				if(mensaje != null){
					out.println("<span class=\"error\">" + mensaje + "</span>");
				}
			%>
                    <div class="team-content">
                        <div class="team">
                            <h2>Equipo Azul</h3>
                            <label>Nombre<br>
                                <input type="text" name="nombreAzul" minlength="1" maxlength="20" required></label>
                            <br>
                            <label>Viper<br>
                                <input type="number" name="viperAzul" min="0" max="100" value="0" required></label>
                            <br>
                            <label>Escolta<br>
                                <input type="number" name="escoltaAzul" min="0" max="100" value="0" required></label>
                            <br>
                            <label>Linea<br>
                                <input type="number" name="lineaAzul" min="0" max="100" value="0" required></label>
                        </div>
                        <div class="team">
                            <h2>Equipo Rojo</h3>
                            <label>Nombre<br>
                                <input type="text" name="nombreRojo" required>
                            </label>
                            <br>
                            <label>Viper<br>
                                <input type="number" name="viperRojo" min="0" max="100" value="0" required></label>
                            <br>
                            <label>Escolta<br>
                                <input type="number" name="escoltaRojo" min="0" max="100" value="0" required></label>
                            <br>
                            <label>Linea<br>
                                <input type="number" name="lineaRojo" min="0" max="100" value="0" required></label>
                        </div>
                    </div>
                    <input type="submit" value="Comenzar">
                </form>
        </section>
    </main>
    <%@ include file="includes/footer.jsp" %>
</body>
</html>