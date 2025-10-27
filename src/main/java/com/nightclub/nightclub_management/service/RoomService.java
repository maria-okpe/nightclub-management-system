package com.nightclub.nightclub_management.service;

import org.springframework.stereotype.Service;

@Service
public class RoomService {
    public String enterCommonRoom() {
        return "Welcome to the Common Room!";
    }

    public String enterBusinessRoom() {
        return "Welcome to the Business Room!";
    }

    public String enterExclusiveRoom() {
        return "Welcome to the Exclusive Room!";
    }
}

