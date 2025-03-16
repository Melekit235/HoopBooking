import React, { useState } from 'react';
import axios from 'axios';
import './css/RegisterPage.css';

function RegisterPage() {
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [email, setEmail] = useState('');
    const [passwordHash, setPassword] = useState('');
    const [message, setMessage] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();

        const payload = {
            firstName,
            lastName,
            email,
            passwordHash,
        };

        try {
            const response = await axios.post(
                'http://localhost:8080/register',
                payload,
                {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                }
            );
            console.log('Регистрация прошла успешно:', response.data);
            setMessage('Регистрация успешна!');
        } catch (error) {
            console.error('Ошибка регистрации:', error);
            setMessage('Ошибка регистрации. Попробуйте снова.');
        }
    };

    return (
        <div className="register-container">
            <h2>Регистрация</h2>
            <form onSubmit={handleSubmit}>
                <label>Имя:</label>
                <input
                    type="text"
                    name="firstName"
                    value={firstName}
                    onChange={(e) => setFirstName(e.target.value)}
                    required
                />

                <label>Фамилия:</label>
                <input
                    type="text"
                    name="lastName"
                    value={lastName}
                    onChange={(e) => setLastName(e.target.value)}
                    required
                />

                <label>Email:</label>
                <input
                    type="email"
                    name="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                />

                <label>Пароль:</label>
                <input
                    type="password"
                    name="password"
                    value={passwordHash}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                />

                <button type="submit">Зарегистрироваться</button>
            </form>

            <p>Есть аккаунт? <a href="/login">Войти</a></p> {/* Ссылка на страницу входа */}

            {message && <p className="error-message">{message}</p>}
        </div>
    );
}

export default RegisterPage;