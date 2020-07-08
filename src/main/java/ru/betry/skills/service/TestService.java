package ru.betry.skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.betry.skills.entity.Test;
import ru.betry.skills.repository.TestRepository;

import java.util.*;

@Service
public class TestService{

    private TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Test save(Test test) {
        return testRepository.save(test);
    }

    public Optional<Test> findById(Long id) {
        return testRepository.findById(id);
    }

    public List<Test> findAll() {
        return testRepository.findAll();
    }

}
