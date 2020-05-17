package com.rest.lab11.service;

import com.rest.lab11.exception.MyException;
import com.rest.lab11.model.Game;
import com.rest.lab11.model.Player;
import com.rest.lab11.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    public List<Game> getAllGames() {
        return this.gameRepository.findAll();
    }

    public Game insert(Game game) {
        this.gameRepository.insert(game);
        return game;
    }

    public Game update(Game game) {
        this.gameRepository.save(game);
        return game;
    }

    public Game findGameById(String id) {
        return gameRepository.findById(id).orElseThrow(() -> new MyException(id));
    }

    public String delete(String id) {
        Game game = this.gameRepository.findById(id).orElseThrow(() -> new MyException(id));
        this.gameRepository.deleteById(id);
        return "Game deleted";
    }
}
