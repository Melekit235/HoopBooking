import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import "./css/CourtListPage.css";

function CourtListPage() {
    const [courts, setCourts] = useState([]);
    const [searchQuery, setSearchQuery] = useState("");
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

    const filteredCourts = courts.filter(court =>
    court.courtTypeName.toLowerCase().includes(searchQuery.toLowerCase()) ||
    court.cityName.toLowerCase().includes(searchQuery.toLowerCase()) ||
    court.courtAddress.toLowerCase().includes(searchQuery.toLowerCase()));

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
    </div>
    );
}

export default CourtListPage;