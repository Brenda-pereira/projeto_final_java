package com.panacademy.primavera.repositories;

import com.panacademy.primavera.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro,String> {
}
