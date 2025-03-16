import React, { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import './css/CourtDetailPage.css';

function CourtDetailPage() {
    const { courtId } = useParams();
    const navigate = useNavigate();

    const [court, setCourt] = useState(null);
    const [arrivals, setArrivals] = useState([]);
    const [reviews, setReviews] = useState([]);
    const [reviewText, setReviewText] = useState("");
    const [date, setDate] = useState("");
    const [startTime, setStartTime] = useState("");
    const [endTime, setEndTime] = useState("");

    useEffect(() => {
        axios.get(`http://localhost:8080/court/${courtId}`)
            .then((courtResponse) => {
                setCourt(courtResponse.data);

                return Promise.all([
                    axios.get(`http://localhost:8080/court/${courtId}/arrivals`),
                    axios.get(`http://localhost:8080/court/${courtId}/reviews`)
                    ]);
            })
            .then(([arrivalsResponse, reviewsResponse]) => {
                setArrivals(arrivalsResponse.data);
                setReviews(reviewsResponse.data);
            })
            .catch((err) => {
                console.error("Error fetching court data", err);
            });
    }, [courtId]);


    const handleArrivalSubmit = async (e) => {
        e.preventDefault();
        const userId = localStorage.getItem("userId");
        if (!userId) {
            alert("Ошибка: пользователь не найден.");
            return;
        }
        try {
            await axios.post(`http://localhost:8080/court/${courtId}/arrivals`, {
            userId,
            date,
            startTime,
            endTime,
        });
        alert("Вы успешно записались на игру!");
    } catch (err) {
            console.error("Ошибка при записи", err);
            alert("Произошла ошибка при записи.");
        }
    };

    const handleReviewSubmit = async (e) => {
        e.preventDefault();
        const userId = localStorage.getItem("userId");
        if (!userId) {
            alert("Ошибка: пользователь не найден.");
            return;
        }
        try {
            await axios.post(`http://localhost:8080/court/${courtId}/reviews`, {
            userId,
            text: reviewText
        });
        setReviewText("");
        alert("Комментарий добавлен!");
        } catch (err) {
            console.error("Ошибка при добавлении комментария", err);
            alert("Произошла ошибка при добавлении комментария.");
        }
    };

    if (!court) {
        return <div>Загрузка...</div>;
    }

    return (
        <div className="container">
            <button className="back-button" onClick={() => navigate("/courts")}>Вернуться к списку кортов</button>

            <div className="court-details">
                <h2>{court.name}</h2>

                <div className="court-info">
                    <p><strong>Город:</strong> {court.cityName}</p>
                    <p><strong>Адрес:</strong> {court.courtAddress}</p>
                    <p><strong>Тип корта:</strong> {court.courtTypeName}</p>
                </div>

                <div className="section">
                    <h3>Запись на игру</h3>
                    <form onSubmit={handleArrivalSubmit} className="arrival-form">

                        <label>Дата:</label>
                        <input
                            type="date"
                            value={date}
                            onChange={(e) => setDate(e.target.value)}
                            required
                        />

                        <label>Время с:</label>
                        <input
                            type="time"
                            value={startTime}
                            onChange={(e) => setStartTime(e.target.value)}
                            required
                        />

                        <label>Время до:</label>
                        <input
                            type="time"
                            value={endTime}
                            onChange={(e) => setEndTime(e.target.value)}
                            required
                        />

                        <button type="submit">Записаться</button>
                    </form>
                </div>

                <div className="section">
                    <h3>Записавшиеся игроки</h3>
                    <ul>
                        {arrivals.map((arrival) => (
                            <li key={arrival.id}>
                            {arrival.playerName} - {arrival.startTime} - {arrival.endTime}
                            </li>
                        ))}
                    </ul>
                </div>

                <div className="section">
                    <h3>Добавить комментарий</h3>
                    <form onSubmit={handleReviewSubmit} className="review-form">
                        <textarea
                            value={reviewText}
                            onChange={(e) => setReviewText(e.target.value)}
                            required
                        ></textarea>
                        <button type="submit">Отправить</button>
                    </form>
                </div>

                <div className="section">
                    <h3>Комментарии</h3>
                    <ul>
                        {reviews.map((review) => (
                        <li key={review.id}>
                            <strong>{review.firstName} {review.lastName}:</strong> {review.reviewText}
                        </li>
                        ))}
                    </ul>
                </div>
            </div>
        </div>
    );
}

export default CourtDetailPage;