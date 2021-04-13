<%--
  Created by IntelliJ IDEA.
  User: JAA
  Date: 10/04/2021
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bienvenue</title>
</head>
<body>
<form method="post" action="Controleur">
    <h1> Liste des employés </h1>


   <table>
        <tr>
            <th>ID Client</th>
            <th>NOM</th>
            <th>PRENOM</th>
            <th>TEL DOMICILE</th>
            <th>TEL PORTABLE</th>
            <th>TEL PRO</th>
            <th>ADRESSE</th>
            <th>CODE POSTAL</th>
            <th>VILLE</th>
            <th>EMAIL</th>
        </tr>

        <c:forEach items="${keyEmployes}" var="empl">
            <tr>
                <td><input type="radio" value="${empl.id}" name="idEmpl"/></td>
                <td><c:out value="${empl.nom}"/></td>
                <td><c:out value="${empl.prenom}"/></td>
                <td>${empl.teldom}</td>
                <td>${empl.telport}</td>
                <td><c:out value="${empl.telpro}"/></td>
                <td><c:out value="${empl.adresse}"/></td>
                <td><c:out value="${empl.codepostal}"/></td>
                <td>${empl.ville}</td>
                <td>${empl.email}</td>
            </tr>
        </c:forEach>

        <tr>
            <td><input type="submit" value="Details" name="action" /></td>
            <td><input type="submit" value="Supprimez" name="action" /> </td>
        </tr>

    </table>

</form>

</body>
</html>
