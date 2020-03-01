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

<title>Database</title>
</head>
<body>
	<%@ include file="includes/header.jsp" %>
	
	<main class="main">
		<section class="container">
			<% 
				String mensaje = (String) request.getAttribute("error");
				if(mensaje != null){
					out.println("<span class=\"error\">" + mensaje + "</span>");
				}
			%>
			<div class="database-form">
                <form action="database" method="POST">
                    <label>Usuario<br>
                        <input type="text" name="nombre" required>
                    </label>
                    <label>Contraseña<br>
                        <input type="password" name="password" required>
                    </label>
                    <input type="submit" value="Reconstruir base de datos">
                </form>
            </div>
		</section>
	</main>
	<%@ include file="includes/footer.jsp" %>
</body>
</html>