import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import "./css/LoginPage.css";

function LoginPage() {
    const [email, setEmail] = useState("");
    const [passwordHash, setPassword] = useState("");
    const [message, setMessage] = useState("");
    const navigate = useNavigate();

    const handleSubmit = async (e) => {
        e.preventDefault();

        const payload = {
            email,
            passwordHash,
        };

        try {
            const response = await axios.post(
                "http://localhost:8080/login",
                payload,
                {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                }
            );

            if (response.data != null) {
                console.log("Успешный вход:", response.data);
                setMessage("Успешный вход!");


                localStorage.setItem("userId", response.data);


                setTimeout(() => {
                    navigate("/courts");
                }, 1000);
            } else {
                setMessage("Ошибка входа: Неверный email или пароль.");
            }

        } catch (err) {
            setMessage("Ошибка входа: Неверный email или пароль.");
        }
    };

    return (
        <div className="login-container">
            <h2>Вход</h2>
            <form onSubmit={handleSubmit}>
                <label>Email:</label>
                <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} required />

                <label>Пароль:</label>
                <input type="password" value={passwordHash} onChange={(e) => setPassword(e.target.value)} required />

                <button type="submit">Войти</button>
            </form>
            <p>Нет аккаунта?<Link to="/register"> Зарегистрироваться</Link></p>
            {message && <p className="error-message">{message}</p>}
        </div>
    );
}

export default LoginPage;