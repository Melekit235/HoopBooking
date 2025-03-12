<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Вход и регистрация</title>
    <script>
        function toggleForm() {
            var loginForm = document.getElementById('loginForm');
            var registerForm = document.getElementById('registerForm');
            var toggleButton = document.getElementById('toggleButton');

            if (loginForm.style.display === 'none') {
                loginForm.style.display = 'block';
                registerForm.style.display = 'none';
                toggleButton.textContent = 'Перейти к регистрации';
            } else {
                loginForm.style.display = 'none';
                registerForm.style.display = 'block';
                toggleButton.textContent = 'Перейти к входу';
            }
        }
    </script>
</head>
<body>
    <h2>Вход</h2>
    <div id="loginForm">
        <form action="login" method="post">
            <label>Email:</label> <input type="email" name="email" required><br>
            <label>Пароль:</label> <input type="password" name="password" required><br>
            <button type="submit">Войти</button>
        </form>
    </div>

    <h2>Регистрация</h2>
    <div id="registerForm" style="display: none;">
        <form action="register" method="post">
            <label>Имя:</label> <input type="text" name="firstName" required><br>
            <label>Фамилия:</label> <input type="text" name="lastName" required><br>
            <label>Email:</label> <input type="email" name="email" required><br>
            <label>Пароль:</label> <input type="password" name="password" required><br>
            <button type="submit">Зарегистрироваться</button>
        </form>
    </div>

    <button id="toggleButton" onclick="toggleForm()">Перейти к регистрации</button>

    <c:if test="${not empty message}">
        <p style="color: red;">${message}</p>
    </c:if>
</body>
</html>
