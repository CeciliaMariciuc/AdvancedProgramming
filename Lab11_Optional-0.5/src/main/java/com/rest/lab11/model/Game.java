package com.rest.lab11.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "games")
public class Game {
    @Id
    String id;
    String boardContent;
    String idPlayer1;
    String idPlayer2;
    String turn;
    String finished;

    public Game(String id, String boardContent, String idPlayer1, String idPlayer2, String turn, String finished) {
        this.id = id;
        this.boardContent = boardContent;
        this.idPlayer1 = idPlayer1;
        this.idPlayer2 = idPlayer2;
        this.turn = turn;
        this.finished = finished;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public String getIdPlayer1() {
        return idPlayer1;
    }

    public void setIdPlayer1(String idPlayer1) {
        this.idPlayer1 = idPlayer1;
    }

    public String getIdPlayer2() {
        return idPlayer2;
    }

    public void setIdPlayer2(String idPlayer2) {
        this.idPlayer2 = idPlayer2;
    }
}
