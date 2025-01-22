package dev.matheushbmelo.dslist.dtos;

import dev.matheushbmelo.dslist.entities.GameList;

public record GameListDto(Long id, String name) {
    public GameListDto(GameList entity) {
        this(entity.getId(), entity.getName());
    }
}
