package br.com.desafio.api_cursos.courses.dtos;

import br.com.desafio.api_cursos.courses.entities.CourseEntity;
import br.com.desafio.api_cursos.courses.entities.enums.CourseCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CourseDTO {
    private UUID id;
    private String name;
    private CourseCategory category;
    private boolean active;

    public void CourseDTO(CourseEntity entity){
        this.id = entity.getCourse_id();
        this.name = entity.getName();
        this.category = entity.getCategory();
        this.active = entity.isActive();
    }
}
