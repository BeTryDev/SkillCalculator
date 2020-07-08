package ru.betry.skills.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.betry.skills.entity.Programmer;

@Repository
public interface ProgrammerRepository extends CassandraRepository<Programmer, Long> {

}
