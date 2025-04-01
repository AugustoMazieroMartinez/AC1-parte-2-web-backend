package com.example.ac1_2.repositories;

import com.example.ac1_2.models.Autor;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a LEFT JOIN FETCH a.livros WHERE a.id = :id")
    Autor findByIdWithLivros(@Param("id") Long id);
    List<Autor> findByNomeStartingWith(String nome);
}
