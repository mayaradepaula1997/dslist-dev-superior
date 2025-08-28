package com.devsuperiorestudo.dslist.repositories;

import com.devsuperiorestudo.dslist.entities.Game;
import com.devsuperiorestudo.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
