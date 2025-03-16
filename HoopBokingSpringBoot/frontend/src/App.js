import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import LoginPage from "./pages/LoginPage";
import RegisterPage from "./pages/RegisterPage";
import PlayerProfilePage from "./pages/PlayerProfilePage";
import CourtListPage from "./pages/CourtListPage";
import CourtDetailPage from "./pages/CourtDetailPage";

function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<LoginPage />} /> {}
                <Route path="/login" element={<LoginPage />} /> {}
                <Route path="/register" element={<RegisterPage />} /> {}
                <Route path="/profile/:userId" element={<PlayerProfilePage />} /> {}
                <Route path="/courts" element={<CourtListPage />} /> {}
                <Route path="/court/:courtId" element={<CourtDetailPage />} /> {}
            </Routes>
        </Router>
    );
}

export default App;
