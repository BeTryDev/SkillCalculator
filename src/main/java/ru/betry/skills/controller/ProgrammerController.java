package ru.betry.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.betry.skills.entity.Programmer;
import ru.betry.skills.entity.Question;
import ru.betry.skills.service.ProgrammerService;

import java.util.*;

@RestController
@RequestMapping("/programmers")
public class ProgrammerController {

    private ProgrammerService programmerService;

    @Autowired
    public ProgrammerController(ProgrammerService programmerService) {
        this.programmerService = programmerService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Programmer programmer) {
        return ResponseEntity.ok(programmerService.save(programmer));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        Optional<Programmer> byId = programmerService.findById(id);
        return Objects.isNull(byId)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(byId);

    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(programmerService.findAll());
    }
}
