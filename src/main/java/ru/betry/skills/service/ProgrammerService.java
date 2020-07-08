package ru.betry.skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.betry.skills.entity.Programmer;
import ru.betry.skills.entity.Question;
import ru.betry.skills.repository.ProgrammerRepository;

import java.util.*;

@Service
public class ProgrammerService {

    private ProgrammerRepository programmerRepository;

    @Autowired
    public ProgrammerService(ProgrammerRepository programmerRepository) {
        this.programmerRepository = programmerRepository;
    }

    public Programmer save(Programmer programmer) {
        return programmerRepository.save(programmer);
    }

    public Optional<Programmer> findById(Long id) {
        return programmerRepository.findById(id);
    }

    public List<Programmer> findAll() {
        return programmerRepository.findAll();
    }
}
