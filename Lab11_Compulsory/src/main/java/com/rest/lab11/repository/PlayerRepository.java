package com.rest.lab11.repository;

import com.rest.lab11.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {
    Player findPlayerById(String id);
}
