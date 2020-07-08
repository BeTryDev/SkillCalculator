package ru.betry.skills.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.betry.skills.entity.Skill;

import java.util.*;

@Repository
public interface SkillRepository extends CassandraRepository<Skill, Long> {

    Optional<Skill> findByTitle(String title);
}
