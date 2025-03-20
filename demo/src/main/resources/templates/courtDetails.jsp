<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Корт: ${court.name}</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: flex-start;
            padding: 20px;
        }

        .container {
            width: 100%;
            max-width: 900px;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
        }

        h2 {
            text-align: center;
            color: #4CAF50;
            font-size: 28px;
            margin-bottom: 15px;
        }

        .court-info p {
            font-size: 16px;
            margin: 10px 0;
            color: #333;
        }

        .court-info strong {
            font-weight: bold;
        }

        h3 {
            color: #333;
            font-size: 22px;
            margin-top: 20px;
            margin-bottom: 10px;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        form {
            display: flex;
            flex-direction: column;
            margin-top: 20px;
        }

        label {
            font-size: 16px;
            margin-bottom: 5px;
        }

        input[type="date"], input[type="time"], textarea {
            padding: 12px;
            font-size: 16px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        button {
            padding: 12px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            font-size: 18px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            align-self: flex-start;
        }

        button:hover {
            background-color: #45a049;
        }

        ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
        }

        li {
            background-color: #f4f4f4;
            padding: 12px;
            margin-bottom: 10px;
            border-radius: 5px;
            font-size: 16px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .back-link {
            text-align: center;
            display: block;
            font-size: 16px;
            color: #4CAF50;
            margin-top: 20px;
            text-decoration: none;
        }

        .back-link:hover {
            text-decoration: underline;
        }

        .section {
            margin-top: 30px;
        }

        /* Responsive Design */
        @media (max-width: 768px) {
            .container {
                width: 95%;
            }

            h2 {
                font-size: 24px;
            }

            h3 {
                font-size: 20px;
            }

            .court-info p {
                font-size: 14px;
            }

            button {
                width: 100%;
                margin-top: 10px;
            }
        }
    </style>
</head>
<body>

    <div class="container">
        <h2>${court.name}</h2>

        <!-- Information about the court -->
        <div class="court-info">
            <p><strong>Город:</strong> ${court.city}</p>
            <p><strong>Адрес:</strong> ${court.address}</p>
            <p><strong>Тип корта:</strong> ${court.type}</p>
        </div>

        <!-- Booking form -->
        <div class="section">
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
        </div>

        <!-- Booked players -->
        <div class="section">
            <h3>Записавшиеся игроки</h3>
            <ul>
                <c:forEach var="booking" items="${bookings}">
                    <li>${booking.user.name} - ${booking.startTime} - ${booking.endTime}</li>
                </c:forEach>
            </ul>
        </div>

        <!-- Add a comment -->
        <div class="section">
            <h3>Добавить комментарий</h3>
            <form method="post" action="addComment">
                <input type="hidden" name="courtId" value="${court.id}">
                <textarea name="commentText" required></textarea>
                <button type="submit">Отправить</button>
            </form>
        </div>

        <!-- Comments -->
        <div class="section">
            <h3>Комментарии</h3>
            <ul>
                <c:forEach var="comment" items="${comments}">
                    <li><strong>${comment.user.name}:</strong> ${comment.text}</li>
                </c:forEach>
            </ul>
        </div>

        <!-- Link to return -->
        <a href="/main" class="back-link">Вернуться к списку кортов</a>
    </div>

</body>
</html>
