package ru.betry.skills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.betry.skills.entity.Question;
import ru.betry.skills.repository.QuestionRepository;

import java.util.*;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
