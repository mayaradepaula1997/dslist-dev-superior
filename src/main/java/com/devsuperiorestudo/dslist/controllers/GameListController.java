package com.devsuperiorestudo.dslist.controllers;


import com.devsuperiorestudo.dslist.dtos.GameListDTO;
import com.devsuperiorestudo.dslist.service.GameListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

   private GameListService gameListService;

    public GameListController(GameListService gameListService) {
        this.gameListService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAll(){

        List<GameListDTO> result = gameListService.findAll();
        return result;

    }
}
