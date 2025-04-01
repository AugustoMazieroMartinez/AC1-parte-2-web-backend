package com.example.ac1_2.repositories;

import com.example.ac1_2.models.Livro;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByPrecoGreaterThan(Double valor);
    List<Livro> findByPrecoLessThanEqual(Double valor);
    List<Livro> findByTituloStartingWith(String titulo);
}
