package com.example.ac1_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.ac1_2.models.Livro;
import com.example.ac1_2.repositories.LivroRepository;
import com.example.ac1_2.repositories.AutorRepository;
import java.util.List;
import com.example.ac1_2.models.Autor;

@SpringBootApplication
public class Ac12Application {

    @Bean
    public CommandLineRunner init(
        @Autowired LivroRepository livroRepository,
        @Autowired AutorRepository autorRepository
    ) {
        return args -> {
            Autor autor1 = autorRepository.save(new Autor(null, "J.R.R. Tolkien"));
            Autor autor2 = autorRepository.save(new Autor(null, "Harlan Ellison"));

            Livro livro1 = livroRepository.save(new Livro(null, "O Senhor dos Anéis", 39.90));
            Livro livro2 = livroRepository.save(new Livro(null, "O Hobbit", 29.90));
            Livro livro3 = livroRepository.save(new Livro(null, "Eu não tenho boca e preciso gritar", 49.90));

			autor1.addLivro(livro1);
			autor1.addLivro(livro2);
			autor2.addLivro(livro3);
			autorRepository.save(autor1);
			autorRepository.save(autor2);

            List<Autor> autores = autorRepository.findByNomeStartingWith("J");
            System.out.println("Autores com nome começando com 'J':");
            for(Autor autor : autores) {
                System.out.println(autor.getNome());
            }

            System.out.println("Autor específico pelo ID: '1' ");
			Autor autor = autorRepository.findByIdWithLivros(1L);
            System.out.println("Autor: " + autor.getNome() + " e seus livros:");
            for (Livro livro : autor.getLivros()) {
                System.out.println(livro.getTitulo());
            }

            List<Livro> livros1 = livroRepository.findByPrecoLessThanEqual(30.00);
            System.out.println("Livros com preço menor ou igual a R$30,00:");
            for(Livro livrofor1 : livros1) {
                System.out.println(livrofor1.getTitulo());
            }

			List<Livro> livros2 = livroRepository.findByPrecoGreaterThan(30.00);
            livros2 = livroRepository.findByPrecoGreaterThan(30.00);
            System.out.println("Livros com preço maior que R$30,00:");
            for(Livro livrofor2 : livros2) {
                System.out.println(livrofor2.getTitulo());
            }

			List<Livro> livros3 = livroRepository.findByTituloStartingWith("O");
            livros3 = livroRepository.findByTituloStartingWith("O");
            System.out.println("Livros com título começando com 'O':");
            for(Livro livrofor3 : livros3) {
                System.out.println(livrofor3.getTitulo());
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Ac12Application.class, args);
    }
}