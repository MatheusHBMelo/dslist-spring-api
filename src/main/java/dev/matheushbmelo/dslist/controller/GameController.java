package dev.matheushbmelo.dslist.controller;

import dev.matheushbmelo.dslist.dtos.GameDto;
import dev.matheushbmelo.dslist.dtos.GameMinDto;
import dev.matheushbmelo.dslist.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/games")
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameMinDto>> findAll() {
        return ResponseEntity.ok(gameService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GameDto> findById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(gameService.findById(id));
    }
}
