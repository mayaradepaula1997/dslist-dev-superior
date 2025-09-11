package com.devsuperiorestudo.dslist.service;


import com.devsuperiorestudo.dslist.dtos.GameListDTO;
import com.devsuperiorestudo.dslist.entities.GameList;
import com.devsuperiorestudo.dslist.projections.GameMinProjection;
import com.devsuperiorestudo.dslist.repositories.GameListRepository;
import com.devsuperiorestudo.dslist.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

   private GameListRepository gameListRepository;

   private GameRepository gameRepository;

    public GameListService(GameListRepository gameListRepository, GameRepository gameRepository) {
        this.gameListRepository = gameListRepository;
        this.gameRepository = gameRepository;
    }


    @Transactional
    public List<GameListDTO> findAll(){

       List<GameList> result = gameListRepository.findAll();
        return result.stream()
                .map(x -> new GameListDTO(x)).toList();  //Para cada objeto da list, ele vai virar um GameListDTO

    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){

        List<GameMinProjection> list = gameRepository.searchByList(listId);


        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex,obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ?   destinationIndex : destinationIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }


    }


}
