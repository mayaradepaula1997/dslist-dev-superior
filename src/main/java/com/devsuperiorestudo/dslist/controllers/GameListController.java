package com.devsuperiorestudo.dslist.controllers;


import com.devsuperiorestudo.dslist.dtos.GameListDTO;
import com.devsuperiorestudo.dslist.dtos.GameMinDTO;
import com.devsuperiorestudo.dslist.service.GameListService;
import com.devsuperiorestudo.dslist.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

   private GameListService gameListService;

   private GameService gameService;

    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping
    public List<GameListDTO> findAll(){

        List<GameListDTO> result = gameListService.findAll();
        return result;

    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){

        List<GameMinDTO> result = gameService.findByList(listId);
        return result;

    }
}
