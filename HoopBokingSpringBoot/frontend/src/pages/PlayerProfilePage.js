import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import './css/PlayerProfilePage.css';

function PlayerProfilePage() {
    const [user, setUser] = useState(null);
    const [friends, setFriends] = useState([]);
    const [favoriteCourts, setFavoriteCourts] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        const userId = localStorage.getItem("userId");

        if (!userId) {
            console.error("User ID is not found in localStorage");
            navigate("/login");
            return;
        }

        const fetchUserData = async () => {
            try {
                const userResponse = await axios.get(`http://localhost:8080/profile/${userId}`);
                const friendsResponse = await axios.get(`http://localhost:8080/profile/friends/${userId}`);
                const courtsResponse = await axios.get(`http://localhost:8080/profile/favorites/${userId}`);

                setUser(userResponse.data);
                setFriends(friendsResponse.data);
                setFavoriteCourts(courtsResponse.data);
            } catch (err) {
                console.error("Error fetching user data", err);
            }
        };

        fetchUserData();
    }, [navigate]);

    const handleLogout = () => {
        localStorage.removeItem("userId");
        navigate("/login");
    };

    const handleBackToCourts = () => {
        navigate("/courts");
    };

    if (!user) {
        return <div>Загрузка...</div>;
    }

    return (
    <div className="profile-container">
        <header className="header">
            <div className="header-content">
                <h2>Профиль игрока</h2>
                <button className="logout-button" onClick={handleLogout}>Выйти</button>
            </div>
        </header>

        <div className="profile-card">
            <div className="user-info">
                <h3>{user.firstName} {user.lastName}</h3>
                <p><strong>Email:</strong> {user.email}</p>
            </div>

            <div className="form-section">
                <h3>Друзья</h3>
                <ul className="friend-list">
                    {friends.length > 0 ? friends.map((friend) => (
                        <li key={friend.id}>{friend.firstName} {friend.lastName} - {friend.friendshipDate}</li>
                    )) : <li>Нет друзей</li>}
                </ul>
            </div>

            <div className="form-section">
                <h3>Любимые площадки</h3>
                <ul className="court-list">
                    {favoriteCourts.length > 0 ? favoriteCourts.map((court) => (
                        <li key={court.id}>{court.courtType} - {court.courtAddress} - {court.cityName}</li>
                    )) : <li>Нет любимых площадок</li>}
                </ul>
            </div>

            <div className="button-container">
                <button className="back-to-courts" onClick={handleBackToCourts}>Назад к кортам</button>
            </div>
        </div>
    </div>
    );
}

export default PlayerProfilePage;