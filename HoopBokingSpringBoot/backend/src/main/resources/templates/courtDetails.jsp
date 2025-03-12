<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Корт: ${court.name}</title>
</head>
<body>
    <h2>${court.name}</h2>
    <p><strong>Город:</strong> ${court.city}</p>
    <p><strong>Адрес:</strong> ${court.address}</p>
    <p><strong>Тип корта:</strong> ${court.type}</p>

    <h3>Запись на игру</h3>
    <form method="post" action="bookCourt">
        <input type="hidden" name="courtId" value="${court.id}">
        <label>Дата:</label>
        <input type="date" name="date" required>
        <label>Время с:</label>
        <input type="time" name="startTime" required>
        <label>Время до:</label>
        <input type="time" name="endTime" required>
        <button type="submit">Записаться</button>
    </form>

    <h3>Записавшиеся игроки</h3>
    <ul>
        <c:forEach var="booking" items="${bookings}">
            <li>${booking.user.name} - ${booking.startTime} - ${booking.endTime}</li>
        </c:forEach>
    </ul>


    <h3>Добавить комментарий</h3>
    <form method="post" action="addComment">
        <input type="hidden" name="courtId" value="${court.id}">
        <textarea name="commentText" required></textarea>
        <button type="submit">Отправить</button>
    </form>

    <h3>Комментарии</h3>
    <ul>
        <c:forEach var="comment" items="${comments}">
            <li><strong>${comment.user.name}:</strong> ${comment.text}</li>
        </c:forEach>
    </ul>



    <a href="/courts">Вернуться к списку кортов</a>
</body>
</html>
