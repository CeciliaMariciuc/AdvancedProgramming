package com.rest.lab11.service;

import com.rest.lab11.model.Game;
import com.rest.lab11.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    public List<Game> getAllGames(){
        return this.gameRepository.findAll();
    }

    public Game insert(Game game){
        this.gameRepository.insert(game);
        return game;
    }
}
