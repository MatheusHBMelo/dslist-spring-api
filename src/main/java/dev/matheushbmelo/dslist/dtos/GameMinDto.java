package dev.matheushbmelo.dslist.dtos;

import dev.matheushbmelo.dslist.entities.Game;

public record GameMinDto(Long id, String title, Integer year, String imgUrl, String shortDescription) {
    public GameMinDto(Game entity) {
        this(entity.getId(), entity.getTitle(), entity.getYear(), entity.getImgUrl(), entity.getShortDescription());
    }
}
