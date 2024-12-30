package br.com.desafio.api_cursos.courses.entities;

import br.com.desafio.api_cursos.courses.entities.enums.CourseCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID course_id;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "A categoria é obrigatória")
    private CourseCategory category;

    @NotNull(message = "O campo é obrigatório")
    private boolean active;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;
}
