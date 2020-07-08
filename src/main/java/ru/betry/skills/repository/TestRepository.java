package ru.betry.skills.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.betry.skills.entity.Test;

@Repository
public interface TestRepository extends CassandraRepository<Test, Long> {

}
