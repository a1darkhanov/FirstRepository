package kz.mve.movies.controller.scheduled;

import kz.mve.movies.client.MovieClient;
import kz.mve.movies.entity.MovieEntity;
import kz.mve.movies.repository.MovieEntityRepository;
import kz.mve.movies.services.MovieEntityService;
import kz.mve.movieswebservice.wsdl.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
public class MovieScheduler {

    private MovieEntityService service;

    @Autowired
    private MovieClient movieClient;

    @Autowired
    private MovieEntityRepository movieEntityRepository;

    @Scheduled(fixedDelay = 600000)
    public void addMovie(){
        log.info("start");
        GetAllMoviesRequest getAllMoviesRequest = new GetAllMoviesRequest();
        GetAllMoviesResponse response = movieClient.getMoviesInfo(getAllMoviesRequest);

        for (MovieType movieType: response.getMovieType()) {
            MovieEntity entity = convertEntity(movieType);
            Optional<MovieEntity> movieOpt = movieEntityRepository.findById(movieType.getMovieId());
            if (!movieOpt.isPresent()) {
                movieEntityRepository.save(entity);
                log.info("Added new insert");
            }
        }
    }

    private MovieEntity convertEntity(MovieType movieType) {
        MovieEntity entity = new MovieEntity();
        entity.setMovieId(movieType.getMovieId());
        entity.setCategory(movieType.getCategory());
        entity.setTitle(movieType.getTitle());

        return entity;
    }

}
