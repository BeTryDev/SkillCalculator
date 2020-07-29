package ru.betry.skills.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.betry.skills.entity.SearchParametersVacancy;
import ru.betry.skills.service.VacanciesService;

@RestController
@RequestMapping("/vacancies")
public class VacanciesController {

    private final VacanciesService vacanciesService;

    @Autowired
    public VacanciesController(VacanciesService vacanciesService) {
        this.vacanciesService = vacanciesService;
    }

    @GetMapping
    public ResponseEntity getAllVacancies() {
        return ResponseEntity.ok(vacanciesService.getAllVacancies().getItems());
    }

    @PostMapping
    public ResponseEntity getAllVacancies(@RequestBody SearchParametersVacancy params) {
        return ResponseEntity.ok(vacanciesService.getAllVacancies(params).getItems());
    }

    @GetMapping("/{vacId}")
    public ResponseEntity getVacancyById(@PathVariable String vacId) {
        return ResponseEntity.ok(vacanciesService.getVacancyById(vacId));
    }

}
