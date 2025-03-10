package org.example.model.dao;

import org.example.model.dao.impl.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory implements AutoCloseable {
    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        try (InputStream input = DaoFactory.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new IllegalStateException("Configuration file not found.");
            }
            Properties properties = new Properties();
            properties.load(input);

            URL = properties.getProperty("db.url");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");

        } catch (Exception e) {
            throw new RuntimeException("Error loading database configuration", e);
        }
    }

    private Connection connection;

    public DaoFactory() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public PlayerDao getPlayerDao() {
        return new PlayerDaoImpl(connection);
    }

    public CourtDao getCourtDao() {
        return new CourtDaoImpl(connection);
    }

    public CourtReviewDao getCourtReviewDao() {
        return new CourtReviewDaoImpl(connection);
    }

    public FavoriteDao getFavoriteDao() {
        return new FavoriteDaoImpl(connection);
    }

    public PlayerArrivalDao getPlayerArrivalDao() {
        return new PlayerArrivalDaoImpl(connection);
    }

    public PlayerFriendDao getPlayerFriendDao() {
        return new PlayerFriendDaoImpl(connection);
    }

    public CourtTypeDao getCourtTypeDao() {
        return new CourtTypeDaoImpl(connection);
    }

    public CityDao getCityDao() {
        return new CityDaoImpl(connection);
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
