package br.com.teknet.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.annotation.Relation;
import io.micronaut.data.annotation.TypeDef;
import io.micronaut.data.model.DataType;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Serdeable
@MappedEntity("task")
@Getter
@Builder
@EqualsAndHashCode(of = { "id" })
@ToString
public class Task {
    
    @Id
    @GeneratedValue(GeneratedValue.Type.AUTO)
    private Long id;

    @NotBlank
    private String description;

    @NotNull
    @TypeDef(type = DataType.STRING)
    private TaskStatus status;

    @NotNull
    @MappedProperty("created_date")
    private LocalDateTime createdDate;

    @NotNull
    @MappedProperty("modified_date")
    private LocalDateTime modifiedDate;

    @NotNull
    @MappedProperty("created_by")
    @Relation(value = Relation.Kind.MANY_TO_ONE)
    private User createdBy;

    // tags
    @Relation(value = Relation.Kind.MANY_TO_MANY, mappedBy = "tasktag")
    private Set<Tag> tags;

}
