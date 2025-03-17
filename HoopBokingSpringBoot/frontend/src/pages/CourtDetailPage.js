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
    const [showForm, setShowForm] = useState(false);
    const [newCourt, setNewCourt] = useState({
        courtTypeId: "",
        cityName: "",
        courtAddress: "",
    });
    const [showDeleteConfirmation, setShowDeleteConfirmation] = useState(false);

    useEffect(() => {
        axios.get(`http://localhost:8080/court/${courtId}`)
            .then((courtResponse) => {
                setCourt(courtResponse.data);
                setNewCourt({
                    courtTypeId: courtResponse.data.courtTypeId,
                    cityName: courtResponse.data.cityName,
                    courtAddress: courtResponse.data.courtAddress,
                });

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

    const handleEditCourt = async () => {
        try {
            await axios.put(`http://localhost:8080/court/${courtId}`, newCourt);
            alert("Корт успешно отредактирован!");
            setShowForm(false);
            navigate(`/court/${courtId}`);
        } catch (err) {
            console.error("Ошибка при редактировании корта", err);
            alert("Произошла ошибка при редактировании корта.");
        }
    };

    const handleDeleteCourt = async () => {
        try {
            await axios.delete(`http://localhost:8080/court/${courtId}`);
            alert("Корт успешно удален!");
            navigate("/courts");
        } catch (err) {
            console.error("Ошибка при удалении корта", err);
            alert("Произошла ошибка при удалении корта.");
        }
    };

    // Handle arrival submission
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

    // Handle review submission
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

                <div className="court-actions">
                    <button onClick={() => setShowForm(true)}>Редактировать</button>
                    <button onClick={() => setShowDeleteConfirmation(true)}>Удалить</button>
                </div>

                {showForm && (
                    <div className="modal-overlay">
                        <div className="modal">
                            <h2>Редактировать корт</h2>
                            <select
                                value={newCourt.courtTypeId}
                                onChange={(e) => setNewCourt({ ...newCourt, courtTypeId: Number(e.target.value) })}
                            >
                                <option value="0"></option>
                                <option value="1">Indoor</option>
                                <option value="2">Outdoor</option>
                                <option value="3">Street</option>
                            </select>
                            <input
                                type="text"
                                placeholder="Город"
                                value={newCourt.cityName}
                                onChange={(e) => setNewCourt({ ...newCourt, cityName: e.target.value })}
                            />
                            <input
                                type="text"
                                placeholder="Адрес"
                                value={newCourt.courtAddress}
                                onChange={(e) => setNewCourt({ ...newCourt, courtAddress: e.target.value })}
                            />
                            <button onClick={handleEditCourt}>Сохранить</button>
                            <button onClick={() => setShowForm(false)}>Отмена</button>
                        </div>
                    </div>
                )}

                {showDeleteConfirmation && (
                    <div className="modal-overlay">
                        <div className="modal">
                            <h2>Вы уверены, что хотите удалить этот корт?</h2>
                            <button onClick={handleDeleteCourt}>Да, удалить</button>
                            <button onClick={() => setShowDeleteConfirmation(false)}>Отмена</button>
                        </div>
                    </div>
                )}

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

                <div className="section players-section">
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

                <div className="section comments-section">
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
