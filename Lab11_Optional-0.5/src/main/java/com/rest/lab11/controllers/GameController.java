package com.rest.lab11.controllers;

import com.rest.lab11.model.Game;
import com.rest.lab11.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pa/games")
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping
    List<Game> getGames() {
        return this.gameService.getAllGames();
    }

    @PostMapping
    ResponseEntity<Game> insertGame(@RequestBody Game game) {
        game = this.gameService.insert(game);
        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }

    @PutMapping
    ResponseEntity<Game> updateGame(@RequestBody Game game) {
        game = this.gameService.update(game);
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    Game getGameById(@PathVariable("id") String id) {
        return this.gameService.findGameById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable("id") String id) {
        String response = this.gameService.delete(id);
        if (response.equals("Game deleted")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(
                response, HttpStatus.GONE);
    }
}
