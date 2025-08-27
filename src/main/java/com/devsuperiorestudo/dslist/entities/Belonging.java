package com.devsuperiorestudo.dslist.entities;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

//Classe que vai fazer o relacionamento de Game e GameList

@Entity
@Table(name = "tb_belonging")
public class Belonging {


    @EmbeddedId
    private BelongingPK id = new BelongingPK() ;   //Esse campo, vai representar dois campo na tabela relacional

    private Integer position;


    public Belonging() {
    }

    //Quando eu criar um objeto do tipo Belonging, eu tenho que passar um Game e um GameList
    public Belonging(Game game, GameList list, Integer position) {
        id.setGame(game);    //esse referencia de "game" eu jogo no BelongingPK
        id.setList(list);
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
