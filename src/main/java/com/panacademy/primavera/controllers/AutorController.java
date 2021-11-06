package com.panacademy.primavera.controllers;

import com.panacademy.primavera.models.Autor;
import com.panacademy.primavera.repositories.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/autores")

public class AutorController {
    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public ResponseEntity<List<Autor>> getAutores() {
        return ResponseEntity.ok(autorRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutor(@PathVariable Long id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if (autor.isPresent()) {
            return ResponseEntity.ok(autor.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping
    public ResponseEntity<Void> createAutor(@RequestBody Autor autor) {
        autorRepository.save(autor);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAutor(@PathVariable Long id, @RequestBody Autor autor) {
        Optional<Autor> a = autorRepository.findById(id);
        if (a.isPresent()) {
            autor.setId(a.get().getId());
            autorRepository.save(autor);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

}
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Long id) {
        Optional<Autor> delAutor = autorRepository.findById(id);
        if(delAutor.isPresent()){
            autorRepository.delete(delAutor.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}

