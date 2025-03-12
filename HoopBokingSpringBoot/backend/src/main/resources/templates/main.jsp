<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Поиск баскетбольных кортов</title>
</head>
<body>
    <h2>Поиск баскетбольных кортов</h2>

    <form method="get" action="courts">
        <input type="text" name="city" placeholder="Введите город" value="${param.city}">
        <input type="text" name="address" placeholder="Введите адрес" value="${param.address}">
        <select name="type">
            <option value="">Все типы</option>
            <option value="Открытый" ${param.type == 'Открытый' ? 'selected' : ''}>Открытый</option>
            <option value="Закрытый" ${param.type == 'Закрытый' ? 'selected' : ''}>Закрытый</option>
            <option value="С покрытием" ${param.type == 'С покрытием' ? 'selected' : ''}>С покрытием</option>
        </select>
        <button type="submit">Найти</button>
    </form>

    <h3>Результаты поиска</h3>
    <ul>
        <c:forEach var="court" items="${courts}">
            <li>
                <strong>${court.name}</strong> - ${court.city}, ${court.address}
                (${court.type})
            </li>
        </c:forEach>
    </ul>
</body>
</html>
