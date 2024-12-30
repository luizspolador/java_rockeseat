package br.com.desafio.api_cursos.courses.usecase;

import br.com.desafio.api_cursos.courses.dtos.CourseDTO;
import br.com.desafio.api_cursos.courses.entities.CourseEntity;
import br.com.desafio.api_cursos.courses.repositories.CourseRepository;
import br.com.desafio.api_cursos.exceptions.DatabaseException;
import br.com.desafio.api_cursos.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    @Transactional(readOnly = true)
    public Page<CourseDTO> findAllCourses(String name, Pageable pageable){
        Page<CourseEntity> courses = courseRepository.searchByName(name, pageable);
        return courses.map(x -> new CourseDTO(x));
    }

    @Transactional(readOnly = true)
    public CourseDTO findCouseById(UUID id){
        CourseEntity courseEntity = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("recurso não encontrado")
        );
        return new CourseDTO(courseEntity);
    }

    @Transactional
    public CourseDTO insertCourse(CourseDTO dto){
        CourseEntity courseEntity = new CourseEntity();
        copyDtoToEntity(dto, courseEntity);
        courseEntity = courseRepository.save(courseEntity);
        return new CourseDTO(courseEntity);
    }

    @Transactional
    public CourseDTO updateCourse(UUID id, CourseDTO dto){
        try{
            CourseEntity courseEntity = courseRepository.getReferenceById(id);
            copyDtoToEntity(dto, courseEntity);
            courseEntity = courseRepository.save(courseEntity);
            return new CourseDTO(courseEntity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteCourse(UUID id){
        if(!courseRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try{
            courseRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
        }
    }


    private void copyDtoToEntity(CourseDTO dto, CourseEntity entity){
        entity.setName(dto.getName());
        entity.setCategory(dto.getCategory());
        entity.setActive(dto.isActive());
    }
}
