package com.devsuperiorestudo.dslist.repositories;

import com.devsuperiorestudo.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
