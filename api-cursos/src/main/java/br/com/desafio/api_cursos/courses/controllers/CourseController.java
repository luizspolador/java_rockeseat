package br.com.desafio.api_cursos.courses.controllers;

import br.com.desafio.api_cursos.courses.dtos.CourseDTO;
import br.com.desafio.api_cursos.courses.usecase.CourseUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseUseCase courseUseCase;

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable UUID id){
        CourseDTO courseDTO = courseUseCase.findCouseById(id);
        return ResponseEntity.ok(courseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<CourseDTO>> findAll(@RequestParam(name = "name", defaultValue = "")
                                                   String name, Pageable pageable){
        Page<CourseDTO> courseDTO = courseUseCase.findAllCourses(name, pageable);
        return ResponseEntity.ok(courseDTO);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> insert(@Valid @RequestBody CourseDTO courseDTO){
        courseDTO = courseUseCase.insertCourse(courseDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(courseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(courseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable UUID id, @Valid @RequestBody CourseDTO courseDTO){
        courseDTO = courseUseCase.updateCourse(id, courseDTO);
        return ResponseEntity.ok(courseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable UUID id){
        courseUseCase.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

}
