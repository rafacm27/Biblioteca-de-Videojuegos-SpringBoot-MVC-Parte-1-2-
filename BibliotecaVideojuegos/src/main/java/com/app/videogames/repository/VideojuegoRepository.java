package com.app.videogames.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.videogames.model.Videojuego;
import java.util.List;

@Repository
public interface VideojuegoRepository extends JpaRepository<Videojuego, Long> {
    List<Videojuego> findByPlataformaIgnoreCase(String plataforma);
}
