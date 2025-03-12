<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Профиль игрока</title>
</head>
<body>
    <h2>Профиль игрока</h2>

    <p><strong>Имя:</strong> ${user.firstName}</p>
    <p><strong>Фамилия:</strong> ${user.lastName}</p>
    <p><strong>Email:</strong> ${user.email}</p>

    <h3>Друзья</h3>
    <ul>
        <c:forEach var="friend" items="${user.friends}">
            <li>${friend.firstName} ${friend.lastName} - ${friend.email}</li>
        </c:forEach>
    </ul>

    <h3>Любимые площадки</h3>
    <ul>
        <c:forEach var="court" items="${user.favoriteCourts}">
            <li>${court.name} - ${court.location}</li>
        </c:forEach>
    </ul>

    <form action="logout" method="post">
        <button type="submit">Выйти</button>
    </form>
</body>
</html>
