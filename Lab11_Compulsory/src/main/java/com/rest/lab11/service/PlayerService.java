package com.rest.lab11.service;

import com.rest.lab11.model.Player;
import com.rest.lab11.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public List<Player> getPlayers() {
        return this.playerRepository.findAll();
    }

    public Player insert(Player player) {
        this.playerRepository.insert(player);
        return player;
    }

    public Player updateName(String id, String name) {
        Player player = this.playerRepository.findPlayerById(id);
        player.setName(name);
        this.playerRepository.save(player);
        return player;
    }

    public String delete(String id){
        Player player = this.playerRepository.findPlayerById(id);
        if(player == null){
            return "Player not found";
        }
        else {
            this.playerRepository.deleteById(id);
            return "Player deleted";
        }
    }
}
