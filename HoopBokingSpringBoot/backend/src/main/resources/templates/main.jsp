<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Список баскетбольных кортов</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        header {
            width: 100%;
            padding: 10px;
            background-color: #f8f8f8;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .profile-link {
            text-decoration: none;
            color: #007bff;
        }
        .container {
            width: 80%;
            max-width: 1000px;
            margin-top: 20px;
            padding: 10px;
            background-color: #f9f9f9;
            border-radius: 10px;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            background-color: #fff;
            margin-bottom: 10px;
            padding: 10px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <header>
        <a href="profile" class="profile-link">Профиль</a>
    </header>

    <div class="container">
        <h3>Список кортов</h3>
        <ul>
            <c:forEach var="court" items="${courts}">
                <li>
                    <strong>${court.courtType.name}</strong> - ${court.city.name}, ${court.courtAddress}
                </li>
            </c:forEach>
        </ul>
    </div>
</body>
</html>
