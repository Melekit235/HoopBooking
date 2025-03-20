package com.example.demo.service;

import com.example.demo.dto.FriendDto;
import com.example.demo.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    private final FriendRepository friendRepository;

    @Autowired
    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }


    public List<FriendDto> getFriendById(Integer playerId)
    {
        return friendRepository.findFriendsByPlayerId(playerId);
    }
}
