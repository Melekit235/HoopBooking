import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import "./css/CourtListPage.css";

function CourtListPage() {
    const [courts, setCourts] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");
    const [showForm, setShowForm] = useState(false);
    const [newCourt, setNewCourt] = useState({ courtTypeName: "", cityName: "", courtAddress: "" });
    const userId = localStorage.getItem("userId");

    useEffect(() => {
        axios.get("http://localhost:8080/courts")
            .then((response) => {
                setCourts(response.data);
            })
            .catch((error) => {
                console.error("Ошибка загрузки кортов:", error);
            });
    }, []);

    const handleAddCourt = () => {
        axios.post("http://localhost:8080/courts", newCourt)
            .then((response) => {
                //setCourts([...courts, response.data]);
                setShowForm(false);
                setNewCourt({ courtTypeName: "", cityName: "", courtAddress: "" });

                axios.get("http://localhost:8080/courts")
                .then((response) => {
                    setCourts(response.data);
                })
                .catch((error) => {
                    console.error("Ошибка загрузки кортов:", error);
                });

            })
            .catch((error) => {
                console.error("Ошибка добавления корта:", error);
            });
    };

    const filteredCourts = courts.filter(court =>
        court.courtTypeName.toLowerCase().includes(searchQuery.toLowerCase()) ||
        court.cityName.toLowerCase().includes(searchQuery.toLowerCase()) ||
        court.courtAddress.toLowerCase().includes(searchQuery.toLowerCase())
    );

    return (
        <div className="court-list-page">
            <header className="header">
                <div className="header-content">
                    <h1 className="title">Баскетбольные корты</h1>
                    {userId ? (
                        <Link to={`/profile/${userId}`} className="profile-link">Профиль</Link>
                    ) : (
                        <Link to="/login" className="login-link">Войти</Link>
                    )}
                </div>
            </header>

            <main className="container">
                <h2 className="section-title">Список кортов</h2>
                <input
                    type="text"
                    placeholder="Поиск по названию, городу или адресу..."
                    className="search-input"
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                />
                <button className="add-court-button" onClick={() => setShowForm(true)}>Добавить корт</button>

                {filteredCourts.length > 0 ? (
                    <div className="court-grid">
                        {filteredCourts.map((court) => (
                            <Link to={`/court/${court.courtId}`} key={court.courtId} className="court-card">
                                <h3 className="court-name">{court.courtTypeName}</h3>
                                <p className="court-location">{court.cityName}, {court.courtAddress}</p>
                            </Link>
                        ))}
                    </div>
                ) : (
                    <p className="empty-message">Кортов не найдено.</p>
                )}
            </main>

            {showForm && (
                <div className="modal-overlay">
                    <div className="modal">
                        <h2>Добавить корт</h2>
                        <select
                            value={newCourt.courtTypeId}
                            onChange={(e) => setNewCourt({ ...newCourt, courtTypeId: Number(e.target.value) })}
                        >
                           <option value=""></option>
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
                        <button onClick={handleAddCourt}>Добавить</button>
                        <button onClick={() => setShowForm(false)}>Отмена</button>
                    </div>
                </div>
            )}
        </div>
    );
}

export default CourtListPage;
