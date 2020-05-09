package com.rest.lab11.controllers;

import com.rest.lab11.model.Player;
import com.rest.lab11.repository.PlayerRepository;
import com.rest.lab11.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pa/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping
    List<Player> getPlayers() {
        return this.playerService.getPlayers();
    }

    @PostMapping
    ResponseEntity<Player> insertPlayer(@RequestBody Player player) {
        player = this.playerService.insert(player);
        return new ResponseEntity<>(player, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Player> updatePlayerName(@PathVariable String id, @RequestParam String name) {
        Player player = this.playerService.updateName(id, name);
        return new ResponseEntity<>(
                player, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable("id") String id) {
        String response = this.playerService.delete(id);
        if (response.equals("Player not found")) {
            return new ResponseEntity<>(
                    response, HttpStatus.GONE);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
