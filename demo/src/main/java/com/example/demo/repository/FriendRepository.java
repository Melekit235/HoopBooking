package com.example.demo.repository;

import com.example.demo.dto.FriendDto;
import com.example.demo.model.Friend;
import com.example.demo.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

    List<Friend> findByPlayer(Player player);

    @Query("""
            SELECT new com.example.demo.dto.FriendDto(p.id, p.firstName, p.lastName, pf.friendshipDate)
            FROM Player p
            JOIN Friend pf ON p.id = pf.friend.id
            WHERE pf.player.playerId = :playerId
            """
    )
    List<FriendDto> findFriendsByPlayerId(@Param("playerId") Integer playerId);


}
