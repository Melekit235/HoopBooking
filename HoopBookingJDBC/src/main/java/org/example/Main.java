package org.example;

import org.example.model.dao.*;
import org.example.model.entity.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        try (DaoFactory daoFactory = new DaoFactory()) {

            PlayerDao playerDao = daoFactory.getPlayerDao();
            CourtDao courtDao = daoFactory.getCourtDao();
            CourtReviewDao courtReviewDao = daoFactory.getCourtReviewDao();
            FavoriteDao favoriteDao = daoFactory.getFavoriteDao();
            PlayerArrivalDao playerArrivalDao = daoFactory.getPlayerArrivalDao();
            PlayerFriendDao playerFriendDao = daoFactory.getPlayerFriendDao();
            CourtTypeDao courtTypeDao = daoFactory.getCourtTypeDao();
            CityDao cityDao = daoFactory.getCityDao();

            Player newPlayer = new Player(0, "Stephen", "Curry", "stephen.curry@example.com", "password123");
            playerDao.addPlayer(newPlayer);
            Player retrievedPlayer = playerDao.getPlayer(newPlayer.getPlayerId());
            System.out.println("Добавлен игрок: " + retrievedPlayer);

            Player newPlayer2 = new Player(1, "James", "Lebron", "Lebron@example.com", "password123");
            playerDao.addPlayer(newPlayer2);
            Player retrievedPlayer2 = playerDao.getPlayer(newPlayer2.getPlayerId());
            System.out.println("Добавлен игрок: " + retrievedPlayer2);

            City city = new City(0, "New York");
            cityDao.addCity(city);
            City retrievedCity = cityDao.getCity(city.getCityId());
            System.out.println("Добавлен город: " + retrievedCity);

            CourtType courtType = new CourtType(0, "Outdoor");
            courtTypeDao.addCourtType(courtType);
            CourtType retrievedCourtType = courtTypeDao.getCourtType(courtType.getTypeId());
            System.out.println("Добавлен тип корта: " + retrievedCourtType);

            Court court = new Court(0, retrievedCity.getCityId(), retrievedCourtType.getTypeId(), "123 Street");
            courtDao.addCourt(court);
            Court retrievedCourt = courtDao.getCourt(court.getCourtId());
            System.out.println("Добавлен корт: " + retrievedCourt);

            CourtReview review = new CourtReview(0, retrievedCourt.getCourtId(), retrievedPlayer.getPlayerId(), 5, "Отличный корт!", LocalDate.of(2025, 3, 10));
            courtReviewDao.addCourtReview(review);
            CourtReview retrievedReview = courtReviewDao.getCourtReview(review.getReviewId());
            System.out.println("Добавлен отзыв: " + retrievedReview);

            PlayerFriend friend = new PlayerFriend(0, 1, LocalDate.of(2025, 3, 10));
            playerFriendDao.addPlayerFriend(friend);
            System.out.println("Добавлен друг: " + friend);

            Favorite favorite = new Favorite(retrievedPlayer.getPlayerId(), retrievedCourt.getCourtId());
            favoriteDao.addFavorite(favorite);
            System.out.println("Добавлен в избранное: " + favorite);

            PlayerArrival arrival = new PlayerArrival(retrievedPlayer.getPlayerId(), retrievedCourt.getCourtId(), LocalDate.of(2025, 3, 10), LocalTime.of(14, 0), LocalTime.of(16, 0));
            playerArrivalDao.addPlayerArrival(arrival);
            PlayerArrival retrievedArrival = playerArrivalDao.getPlayerArrival(retrievedPlayer.getPlayerId(), retrievedCourt.getCourtId());
            System.out.println("Добавлен приход игрока: " + retrievedArrival);

            playerArrivalDao.deletePlayerArrival(retrievedPlayer.getPlayerId(), retrievedCourt.getCourtId());

            favoriteDao.deleteFavorite(retrievedPlayer.getPlayerId(), retrievedCourt.getCourtId());

            playerFriendDao.deletePlayerFriend(retrievedPlayer.getPlayerId(), retrievedPlayer2.getPlayerId());

            courtReviewDao.deleteCourtReview(review.getReviewId());

            courtDao.deleteCourt(retrievedCourt.getCourtId());

            courtTypeDao.deleteCourtType(retrievedCourtType.getTypeId());

            cityDao.deleteCity(retrievedCity.getCityId());

            playerDao.deletePlayer(retrievedPlayer.getPlayerId());

            playerDao.deletePlayer(retrievedPlayer2.getPlayerId());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
