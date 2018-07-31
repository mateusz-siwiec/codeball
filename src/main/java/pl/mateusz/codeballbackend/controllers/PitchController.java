package pl.mateusz.codeballbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.codeballbackend.model.Pitch;
import pl.mateusz.codeballbackend.repositories.PitchRepository;

@CrossOrigin(origins = "*", allowCredentials = "true", maxAge = 3600L)
@RestController
public class PitchController {

    @Autowired
    private PitchRepository pitchRepository;

    @GetMapping("/api/pitch")
    public Iterable<Pitch> listPitches() {
        return pitchRepository.findAll();
    }

    @PostMapping("/api/pitch")
    public ResponseEntity createPitch(@RequestBody Pitch pitch) {

        return new ResponseEntity(pitchRepository.save(pitch), HttpStatus.OK);
    }

    @DeleteMapping("/api/pitch/{pitchId}")
    public ResponseEntity deletePitch(@PathVariable int id) {
        pitchRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/pitch/{pitchId}")
    public Pitch getPitchById(@PathVariable int pitchId) {
        return pitchRepository.findById(pitchId).orElseThrow(() -> new RuntimeException("Pitch doesn't exist"));
    }

    @PutMapping("/api/pitch/{pitchId}")
    public ResponseEntity updatePitch(@RequestBody Pitch pitch, @PathVariable Integer pitchId) {
        pitch.setId(pitchId);
        return new ResponseEntity(pitchRepository.save(pitch), HttpStatus.OK);
    }
}
