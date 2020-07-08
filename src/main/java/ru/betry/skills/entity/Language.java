package ru.betry.skills.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.*;

@UserDefinedType("language")
@Table("languages")
public class Language {

    @Id
    @PrimaryKeyColumn(
            name = "id",
            ordinal = 2,
            type = PrimaryKeyType.PARTITIONED,
            ordering = Ordering.DESCENDING
    )
    private Long id;

    @Column
    @Getter
    @Setter
    private String title;

    @Column
    @Getter
    @Setter
    private String language;

    @CassandraType(type = CassandraType.Name.LIST, typeArguments = {CassandraType.Name.UDT}, userTypeName = "skillEntity")
    @Getter
    @Setter
    private List<Skill> skillList;
}
