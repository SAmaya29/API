package com.example.demo.service;
import com.example.demo.DTO.PeliculaDTO;
import com.example.demo.DTO.PeliculaResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.List;
@Service
public class PeliculaService {

    @Value("${tmdb.api.key}")
    private String API_KEY;
    private final WebClient webClient;
    public PeliculaService() {
        this.webClient = WebClient.builder()
                .baseUrl("https://api.themoviedb.org/3")
                .build();
    }


    public Mono<List<PeliculaDTO>> getPopularMoviesLimited(int pages) {
        List<Mono<PeliculaResponseDTO>> requests = new ArrayList<>();

        for (int i = 1; i <= pages; i++) {
            final int pageNumber = i;
            Mono<PeliculaResponseDTO> request = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/movie/popular")
                            .queryParam("api_key", API_KEY)
                            .queryParam("language", "en-US")
                            .queryParam("page", pageNumber)
                            .build())
                    .retrieve()
                    .bodyToMono(PeliculaResponseDTO.class);
            requests.add(request);
        }

        return Flux.merge(requests)
                .flatMap(response -> Flux.fromIterable(response.getResults()))
                .collectList();
    }

    public Mono<PeliculaResponseDTO> searchMovies(String query) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/movie")
                        .queryParam("api_key", API_KEY)
                        .queryParam("language", "en-US")
                        .queryParam("query", query)
                        .build())
                .retrieve()
                .bodyToMono(PeliculaResponseDTO.class);
    }

    public Mono<PeliculaDTO> getMovieById(int id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/movie/{id}")
                        .queryParam("api_key", API_KEY)
                        .queryParam("language", "en-US")
                        .build(id))
                .retrieve()
                .bodyToMono(PeliculaDTO.class);
    }
}
