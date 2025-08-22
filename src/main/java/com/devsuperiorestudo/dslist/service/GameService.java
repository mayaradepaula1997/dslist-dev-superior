package com.devsuperiorestudo.dslist.service;

import com.devsuperiorestudo.dslist.dtos.GameMinDTO;
import com.devsuperiorestudo.dslist.entities.Game;
import com.devsuperiorestudo.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll(){

       List<Game> result = gameRepository.findAll();
       List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();

       return dto;

    }
}
