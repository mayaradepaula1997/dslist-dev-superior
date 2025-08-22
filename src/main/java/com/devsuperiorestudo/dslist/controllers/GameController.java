package com.devsuperiorestudo.dslist.controllers;

import com.devsuperiorestudo.dslist.dtos.GameMinDTO;
import com.devsuperiorestudo.dslist.entities.Game;
import com.devsuperiorestudo.dslist.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameMinDTO> findAll(){

        List<GameMinDTO> result = gameService.findAll();
        return result;

    }
}
