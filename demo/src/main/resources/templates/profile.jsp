<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Профиль игрока</title>
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
    <div class="container">
        <!-- Header with player name and logout button -->
        <div class="header">
            <h2>Профиль игрока</h2>
            <form action="logout" method="post">
                <button class="logout-button" type="submit">Выйти</button>
            </form>
        </div>

        <!-- Player information section -->
        <div class="user-info">
            <p><strong>Имя:</strong> ${user.firstName}</p>
            <p><strong>Фамилия:</strong> ${user.lastName}</p>
            <p><strong>Email:</strong> ${user.email}</p>
        </div>

        <!-- Friends section -->
        <div class="form-section">
            <h3>Друзья</h3>
            <ul class="friend-list">
                <c:forEach var="friend" items="${user.friends}">
                    <li>${friend.firstName} ${friend.lastName} - ${friend.email}</li>
                </c:forEach>
            </ul>
        </div>

        <!-- Favorite Courts section -->
        <div class="form-section">
            <h3>Любимые площадки</h3>
            <ul class="court-list">
                <c:forEach var="court" items="${user.favoriteCourts}">
                    <li>${court.name} - ${court.location}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
</body>
</html>
