package kz.mve.movies.controller;

import kz.mve.movies.client.MovieClient;
import kz.mve.movieswebservice.wsdl.GetAllMoviesRequest;
import kz.mve.movieswebservice.wsdl.GetAllMoviesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieClient movieClient;

    @PostMapping("/movies")
    public GetAllMoviesResponse movies(@RequestBody GetAllMoviesRequest getAllMoviesRequest){
        return movieClient.getMoviesInfo(getAllMoviesRequest);
    }

}



