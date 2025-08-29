package com.devsuperiorestudo.dslist.service;

import com.devsuperiorestudo.dslist.dtos.GameDTO;
import com.devsuperiorestudo.dslist.dtos.GameMinDTO;
import com.devsuperiorestudo.dslist.entities.Game;
import com.devsuperiorestudo.dslist.projections.GameMinProjection;
import com.devsuperiorestudo.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameDTO findById(Long id){

        Game result =  gameRepository.findById(id).get(); //busco o game no banco de dados e retorno ele
        GameDTO dto = new GameDTO(result); //instancio o GameDTO, passando o Game no seu construtor

        return dto;

    }



    public List<GameMinDTO> findAll(){

       List<Game> result = gameRepository.findAll();
       List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();

       return dto;

    }

    public List<GameMinDTO> findByList(Long listId){

        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();



    }


}
