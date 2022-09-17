package com.ossama.gestioncinema;

import com.ossama.gestioncinema.services.IInitService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication @AllArgsConstructor
public class GestionCinemaApplication implements CommandLineRunner {
    private IInitService initService;
    public static void main(String[] args) {
        SpringApplication.run(GestionCinemaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initService.initCities();
        initService.initCinemas();
        initService.initTheaters();
        initService.initSeats();
        initService.initCategories();
        initService.initMovies();
        initService.initSessions();
        initService.initMoviesProjection();
        initService.initTickets();

    }
}
