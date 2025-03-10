package org.example.model.entity;

public class Player {

    private int playerId;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;

    public Player(int playerId, String firstName, String lastName, String email, String passwordHash) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Override
    public String toString() {
        return "Игрок{id=" + playerId + ", имя='" + firstName + "', фамилия='" + lastName +
                "', email='" + email + "', пароль (хеш)='" + passwordHash + "'}";
    }


}
