package br.com.desafio.api_cursos.courses.repositories;

import br.com.desafio.api_cursos.courses.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
}
