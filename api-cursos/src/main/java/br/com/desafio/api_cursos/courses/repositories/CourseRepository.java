package br.com.desafio.api_cursos.courses.repositories;

import br.com.desafio.api_cursos.courses.entities.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

    @Query("SELECT course FROM CourseEntity course " +
            "WHERE UPPER(course.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<CourseEntity> searchByName(String name, Pageable pageable);
}
