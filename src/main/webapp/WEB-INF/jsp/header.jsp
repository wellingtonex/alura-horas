<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Título</title>
    <link href="<c:url value='/css/bootstrap.css'/>" rel="stylesheet" />
    <link href="<c:url value='/css/site.css'/>" rel="stylesheet" />
</head>
<body>
    <header>

    </header>
    <nav>
        <ul class="nav nav-tabs">
            <li><a href="<c:url value='/' />">Home</a></li>
            <li><a href="<c:url value='/usuario/lista' />">Usuarios</a></li>
            <li><a href="<c:url value='/horaLancada/lista' />">Horas Cadastradas</a></li>
            <li><a href="<c:url value='/horaLancada/form' />">Cadastrar Horas</a></li>
            <c:if test="${usuarioLogado.logado}">
            	<li><a href="${linkTo[LoginController].logout()}">Logout</a></li>
            </c:if>
            <c:if test="${!usuarioLogado.logado}">
            	<li><a href="${linkTo[LoginController].form()}">Login</a></li>
            </c:if>
        </ul>
    </nav>
    <div class="container">
        <main class="col-sm-8">
