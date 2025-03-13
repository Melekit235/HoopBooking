package com.example.springboot.repository;

import com.example.springboot.model.PlayerFriend;
import com.example.springboot.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerFriendRepository extends JpaRepository<PlayerFriend, Long> {

    List<PlayerFriend> findByPlayer(Player player);

}
