<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.model.Court" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="userId" value="${sessionScope.userId}" />

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список баскетбольных кортов</title>
    <link rel="stylesheet" href="css/CourtListPage.css">
</head>
<body>
<div className="court-list-page">
    <header class="header">
        <div class="header-content">
            <h1 class="title">Баскетбольные корты</h1>
            <c:choose>
                <c:when test="${not empty userId}">
                    <a href="profile?id=${userId}" class="profile-link">Профиль</a>
                </c:when>
                <c:otherwise>
                    <a href="login" class="login-link">Войти</a>
                </c:otherwise>
            </c:choose>
        </div>
    </header>

    <main class="container">
        <h2 class="section-title">Список кортов</h2>

        <input type="text" id="searchInput" placeholder="Поиск по названию, городу или адресу..." class="search-input" onkeyup="filterCourts()">

        <button class="add-court-button" onclick="showForm()">Добавить корт</button>

        <div class="court-grid">
            <c:forEach var="court" items="${courts}">
                <a href="court?id=${court.courtId}" class="court-card">
                    <h3 class="court-name">${court.courtTypeName}</h3>
                    <p class="court-location">${court.cityName}, ${court.courtAddress}</p>
                </a>
            </c:forEach>
        </div>
    </main>

    <div id="courtModal" class="modal-overlay" style="display: none;">
        <div class="modal">
            <h2>Добавить корт</h2>
            <form action="/courts" method="post">
                <select name="courtTypeId" required>
                    <option value="">Выберите тип</option>
                    <option value="1">Indoor</option>
                    <option value="2">Outdoor</option>
                    <option value="3">Street</option>
                </select>
                <input type="text" name="cityName" placeholder="Город" required>
                <input type="text" name="courtAddress" placeholder="Адрес" required>
                <button type="submit">Добавить</button>
                <button type="button" onclick="hideForm()">Отмена</button>
            </form>
        </div>
    </div>
</div>
    <script>
        function showForm() {
            document.getElementById("courtModal").style.display = "block";
        }

        function hideForm() {
            document.getElementById("courtModal").style.display = "none";
        }

        function filterCourts() {
            let input = document.getElementById("searchInput").value.toLowerCase();
            let courts = document.getElementsByClassName("court-card");

            for (let court of courts) {
                let text = court.textContent.toLowerCase();
                court.style.display = text.includes(input) ? "" : "none";
            }
        }
    </script>
</body>
</html>
