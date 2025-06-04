package com.example.demo.controller;
import com.example.demo.DTO.PeliculaDTO;
import com.example.demo.DTO.PeliculaResponseDTO;
import com.example.demo.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import java.util.List;
@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/limited")
    public Mono<List<PeliculaDTO>> getPopularMoviesLimited(@RequestParam(defaultValue = "1") int pages) {
        return peliculaService.getPopularMoviesLimited(pages);
    }

    @GetMapping("/search")
    public Mono<PeliculaResponseDTO> searchMovies(@RequestParam String query) {
        return peliculaService.searchMovies(query);
    }

    @GetMapping("/{id}")
    public Mono<PeliculaDTO> getMovieById(@PathVariable int id) {
        return peliculaService.getMovieById(id);
    }

}
