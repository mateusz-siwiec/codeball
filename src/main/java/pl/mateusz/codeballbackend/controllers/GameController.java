package pl.mateusz.codeballbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.mateusz.codeballbackend.model.Game;
import pl.mateusz.codeballbackend.repositories.EnrollmentRepository;
import pl.mateusz.codeballbackend.repositories.GameRepository;

@RestController
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @PostMapping("/api/game")
    public ResponseEntity createGame (@RequestBody Game game){
        gameRepository.save(game);
        return new ResponseEntity(HttpStatus.OK);
    }
}
