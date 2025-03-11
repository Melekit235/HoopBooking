package org.example.model.dao.impl;
import org.example.model.dao.CourtReviewDao;
import org.example.model.entity.CourtReview;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourtReviewDaoImpl implements CourtReviewDao {
    private final Connection connection;

    public CourtReviewDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addCourtReview(CourtReview courtReview) {
        String query = "INSERT INTO public.court_reviews (review_id, court_id, player_id, rating, review_text, review_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, courtReview.getReviewId());
            statement.setInt(2, courtReview.getCourtId());
            statement.setInt(3, courtReview.getPlayerId());
            statement.setInt(4, courtReview.getRating());
            statement.setString(5, courtReview.getReviewText());
            statement.setDate(6, java.sql.Date.valueOf(courtReview.getReviewDate()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public CourtReview getCourtReview(int reviewId) {
        String query = "SELECT * FROM public.court_reviews WHERE review_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reviewId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new CourtReview(
                        resultSet.getInt("review_id"),
                        resultSet.getInt("court_id"),
                        resultSet.getInt("player_id"),
                        resultSet.getInt("rating"),
                        resultSet.getString("review_text"),
                        resultSet.getDate("review_date").toLocalDate()
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no review is found
    }

    @Override
    public List<CourtReview> getAllReviewsByCourtId(int courtId) {
        List<CourtReview> reviews = new ArrayList<>();
        String query = "SELECT * FROM public.court_reviews WHERE court_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, courtId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reviews.add(new CourtReview(
                        resultSet.getInt("review_id"),
                        resultSet.getInt("court_id"),
                        resultSet.getInt("player_id"),
                        resultSet.getInt("rating"),
                        resultSet.getString("review_text"),
                        resultSet.getDate("review_date").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public List<CourtReview> getAllReviewsByPlayerId(int playerId) {
        List<CourtReview> reviews = new ArrayList<>();
        String query = "SELECT * FROM public.court_reviews WHERE player_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, playerId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                reviews.add(new CourtReview(
                        resultSet.getInt("review_id"),
                        resultSet.getInt("court_id"),
                        resultSet.getInt("player_id"),
                        resultSet.getInt("rating"),
                        resultSet.getString("review_text"),
                        resultSet.getDate("review_date").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public void updateCourtReview(CourtReview courtReview) {
        String query = "UPDATE public.court_reviews SET rating = ?, review_text = ?, review_date = ? WHERE review_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, courtReview.getRating());
            statement.setString(2, courtReview.getReviewText());
            statement.setDate(3, java.sql.Date.valueOf(courtReview.getReviewDate()));
            statement.setInt(4, courtReview.getReviewId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourtReview(int reviewId) {
        String query = "DELETE FROM public.court_reviews WHERE review_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reviewId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
