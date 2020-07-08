package ru.betry.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.betry.skills.entity.Question;
import ru.betry.skills.entity.Skill;
import ru.betry.skills.service.QuestionService;
import ru.betry.skills.service.SkillService;

import java.util.*;

@RestController
@RequestMapping("/skills")
public class SkillController {

    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Skill skill) {
        return ResponseEntity.ok(skillService.save(skill));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        Optional<Skill> byId = skillService.findById(id);
        return Objects.isNull(byId)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(byId);

    }

    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(skillService.findAll());
    }

    @GetMapping("/by/{title}")
    public ResponseEntity findByTitle(@PathVariable String title) {
        Skill byTitle = skillService.findByTitle(title);
        return Objects.isNull(byTitle)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(byTitle);
    }
}
