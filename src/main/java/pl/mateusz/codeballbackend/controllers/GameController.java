package pl.mateusz.codeballbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.codeballbackend.model.Enrollment;
import pl.mateusz.codeballbackend.model.EnrollmentStatus;
import pl.mateusz.codeballbackend.model.Game;
import pl.mateusz.codeballbackend.model.UserSession;
import pl.mateusz.codeballbackend.repositories.EnrollmentRepository;
import pl.mateusz.codeballbackend.repositories.GameRepository;
import pl.mateusz.codeballbackend.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.stream.Collector;
import java.util.stream.StreamSupport;

@CrossOrigin(origins = "*", allowCredentials = "true", maxAge = 3600L)
@RestController
public class GameController {

    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserSession userSession;
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @PostMapping("/api/game")
    public ResponseEntity createGame(@RequestBody Game game) {
        return new ResponseEntity(gameRepository.save(game), HttpStatus.OK);
    }

    @GetMapping("/api/game")
    public Iterable<Game> getGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/api/game/upcoming")
    public ResponseEntity getUpcomingGame() {
        return StreamSupport.stream(gameRepository.findAll().spliterator(), false)
                .filter(game -> !game.isGameOver() && game.getStartTime().isAfter(LocalDateTime.now()))
                .findFirst()
                .map(game -> new ResponseEntity(game, HttpStatus.OK))
                .orElse(new ResponseEntity("No upcoming games", HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/game/{gameId}")
    public Game getGameById(@PathVariable int gameId) {
        return gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game doesn't exist"));
    }

    @PutMapping("/api/game/{gameId}")
    public ResponseEntity updateGame(@RequestBody Game game, @PathVariable Integer gameId) {
        game.setId(gameId);
        return new ResponseEntity(gameRepository.save(game), HttpStatus.OK);
    }

    @DeleteMapping("/api/pitch/{gameId}")
    public ResponseEntity deleteGame(@PathVariable Integer id) {
        gameRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/game/last")
    public Game getLastGame() {
        LocalDateTime now = LocalDateTime.now();
        return StreamSupport.stream(gameRepository.findAllByOrderByStartTimeDesc().spliterator(), false)
                .filter(game -> game.getStartTime().isBefore(now) && game.isGameOver())
                .findFirst().get();
    }


    @PutMapping("/api/game/{gameId}/end")
    public ResponseEntity endGame(@PathVariable int gameId) {
        Game gameById = getGameById(gameId);
        gameById.setGameOver(true);
        return new ResponseEntity(gameRepository.save(gameById), HttpStatus.OK);
    }

    @PutMapping("/api/game/{gameId}/enrollment")
    public ResponseEntity setEnrollmentStatus(@PathVariable Integer gameId, @RequestBody EnrollmentStatus enrollmentStatus) {
        Game gameById = getGameById(gameId);
        Enrollment enrollment1 = gameById.getEnrollments().stream()
                .filter(enrollment -> enrollment.getEnrollerId().equals(userSession.getCurrentUserId()))
                .findAny().orElseThrow(() -> new RuntimeException("enrollment doesn't exist"));
        gameById.getEnrollments().add(enrollment1);
        enrollment1.setEnrollmentStatus(enrollmentStatus);
        enrollmentRepository.save(enrollment1);
        gameRepository.save(gameById);
       return new ResponseEntity(HttpStatus.OK);
    }
}
