package ru.betry.skills.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.betry.skills.entity.Skill;

import java.util.*;

@Repository
public interface SkillRepository extends CassandraRepository<Skill, Long> {

    @Query("select * from dimastestkeyspace.skills where title = ?0 ALLOW FILTERING")
    Optional<Skill> findByTitle(String title);
}
