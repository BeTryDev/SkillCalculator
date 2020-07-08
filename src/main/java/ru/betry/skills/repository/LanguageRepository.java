package ru.betry.skills.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;
import ru.betry.skills.entity.Language;

@Repository
public interface LanguageRepository extends CassandraRepository<Language, Long> {

}
