package com.example.springboot.dto;

import java.time.LocalDate;

public class FriendDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private LocalDate friendshipDate;

    public FriendDto(Integer id, String firstName, String lastName, LocalDate friendshipDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.friendshipDate = friendshipDate;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getFriendshipDate() {
        return friendshipDate;
    }
}
