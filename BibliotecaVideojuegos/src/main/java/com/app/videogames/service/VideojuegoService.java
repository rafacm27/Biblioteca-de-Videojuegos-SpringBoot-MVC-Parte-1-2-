package com.app.videogames.service;
import org.springframework.stereotype.Service;
import com.app.videogames.model.Videojuego;
import com.app.videogames.repository.VideojuegoRepository;
import java.util.List;
import jakarta.annotation.PostConstruct;

@Service
public class VideojuegoService {
    private final VideojuegoRepository repository;

    public VideojuegoService(VideojuegoRepository repository) {
        this.repository = repository;
    }

    public List<Videojuego> findAll() { return repository.findAll(); }
    public List<Videojuego> findByPlataforma(String plataforma) { return repository.findByPlataformaIgnoreCase(plataforma); }
    public Videojuego findById(Long id) { return repository.findById(id).orElse(null); }
    public void save(Videojuego videojuego) { repository.save(videojuego); }
    public void delete(Long id) { repository.deleteById(id); }

    @PostConstruct
    public void initData() {
        if (repository.count() == 0) {
            repository.save(new Videojuego(null, "The Legend of Zelda: Breath of the Wild", "Switch", 2017, "Un juego de aventura en mundo abierto aclamado por la crítica que redefinió el género.", "https://assets.nintendo.com/image/upload/c_fill,w_1200/q_auto:best/f_auto/dpr_2.0/ncom/software/switch/70010000000025/7137262b5a64d6f56ceb64a6b240a5f929db7943f5bd1940989b5c5e8cbd74cb"));
            repository.save(new Videojuego(null, "Super Mario Odyssey", "Switch", 2017, "Juego de plataformas 3D revolucionario en el que Mario viaja por distintos reinos recolectando energilunas.", "https://assets.nintendo.com/image/upload/c_fill,w_1200/q_auto:best/f_auto/dpr_2.0/ncom/software/switch/70010000001130/c42553b4fd0312c31e70ec7468c6c9cb19a5f19227d8123c5dedc202aee08e16"));
            repository.save(new Videojuego(null, "God of War Ragnarok", "PlayStation 5", 2022, "Kratos y Atreus deben viajar a cada uno de los Nueve Reinos en busca de respuestas.", "https://image.api.playstation.com/vulcan/ap/rnd/202207/1210/4xJ8XB3bi888QTLZYcg7Oi0q.png"));
            repository.save(new Videojuego(null, "Cyberpunk 2077", "PC", 2020, "Un RPG de acción y aventuras en mundo abierto ambientado en la metrópolis de Night City.", "https://preview.redd.it/cyberpunk-2077-v0-q0g2l4x1c2n91.png?width=1080&crop=smart&auto=webp&s=6b8b0e8b2342df3b0b5e9ee23de8e7b9bf19d854"));
            repository.save(new Videojuego(null, "Elden Ring", "PC", 2022, "El épico juego de FromSoftware en mundo abierto con el Lore escrito por G.R.R. Martin.", "https://image.api.playstation.com/vulcan/ap/rnd/202110/2000/aGhopp3MHppi7kooGE2Dtt8C.png"));
        }
    }
}
