package ru.betry.skills.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.*;

@AllArgsConstructor
@Table("programmers")
@ToString
public class Programmer {

    @Id
    @PrimaryKeyColumn(
            name = "id",
            ordinal = 2,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING
    )
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String name;

    @CassandraType(type = CassandraType.Name.LIST, typeArguments = {CassandraType.Name.UDT}, userTypeName = "languages")
    @Getter
    @Setter
    private List<Language> languageList;

    @CassandraType(type = CassandraType.Name.LIST, typeArguments = {CassandraType.Name.UDT}, userTypeName = "skills")
    @Getter
    @Setter
    private List<Skill> skillList;
}
