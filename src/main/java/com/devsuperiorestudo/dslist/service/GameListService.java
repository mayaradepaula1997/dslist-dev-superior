package com.devsuperiorestudo.dslist.service;


import com.devsuperiorestudo.dslist.dtos.GameListDTO;
import com.devsuperiorestudo.dslist.entities.GameList;
import com.devsuperiorestudo.dslist.repositories.GameListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

   private GameListRepository gameListRepository;


    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    public List<GameListDTO> findAll(){

       List<GameList> result = gameListRepository.findAll();
        return result.stream()
                .map(x -> new GameListDTO(x)).toList();  //Para cada objeto da list, ele vai virar um GameListDTO

    }


}
