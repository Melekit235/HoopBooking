<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Регистрация</title>

        <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h2 {
            margin-top: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            align-items: flex-start;
            margin-top: 20px;
        }

        label {
            margin-top: 10px;
        }

        input {
            padding: 5px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 250px;
        }

        button {
            margin-top: 15px;
            padding: 8px 15px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        a {
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
        }

        a:hover {
            text-decoration: underline;
        }

        p {
            margin-top: 20px;
            color: red;
        }

        </style>

</head>
<body>
    <h2>Регистрация</h2>
    <form action="/register" method="post">
        <label>Имя:</label> <input type="text" name="firstName" required><br>
        <label>Фамилия:</label> <input type="text" name="lastName" required><br>
        <label>Email:</label> <input type="email" name="email" required><br>
        <label>Пароль:</label> <input type="password" name="password" required><br>
        <input type="submit" value="Зарегистрироваться">
    </form>
    <p><a href="@{/login}">Есть аккаунт? Войти</a></p> <!-- Ссылка на страницу входа -->

    <c:if test="${not empty message}">
        <p style="color: red;">${message}</p>
    </c:if>
</body>
</html>

