<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Профиль игрока</title>
    <link rel="stylesheet" href="/css/Profile.css">
</head>
<body>

<div class="profile-container">
    <header class="header">
        <div class="header-content">
            <h2>Профиль игрока</h2>
            <form action="${pageContext.request.contextPath}/logout" method="post">
                <button type="submit" class="logout-button">Выйти</button>
            </form>
        </div>
    </header>

    <div class="profile-card">
        <div class="user-info">
            <h3>${player.firstName} ${player.lastName}</h3>
            <p><strong>Email:</strong> ${player.email}</p>
        </div>

        <div class="form-section">
            <h3>Друзья</h3>
            <ul class="friend-list">
                <c:choose>
                    <c:when test="${not empty friend}">
                        <c:forEach var="friend" items="${friend}">
                            <li>${friend.firstName} ${friend.lastName} - ${friend.friendshipDate}</li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <li>Нет друзей</li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>

        <div class="form-section">
            <h3>Любимые площадки</h3>
            <ul class="court-list">
                <c:choose>
                    <c:when test="${not empty favorite}">
                        <c:forEach var="favorite" items="${favorite}">
                            <li>${favorite.courtType} - ${favorite.courtAddress}, ${favorite.cityName}</li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <li>Нет любимых площадок</li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>

        <div class="button-container">
            <a href="${pageContext.request.contextPath}/courts" class="back-to-courts">Назад к кортам</a>
        </div>
    </div>
</div>

</body>
</html>
