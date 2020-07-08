package ru.betry.skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.betry.skills.entity.Skill;
import ru.betry.skills.repository.SkillRepository;

import java.util.*;

@Service
public class SkillService {

    private SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Optional<Skill> findById(Long id) {
        return skillRepository.findById(id);
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public Skill findByTitle(String title) {
        return skillRepository.findByTitle(title).orElse(null);
    }
}
