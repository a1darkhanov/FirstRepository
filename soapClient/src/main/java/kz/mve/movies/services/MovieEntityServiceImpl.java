package kz.mve.movies.services;

import kz.mve.movies.repository.MovieEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MovieEntityServiceImpl {

    private MovieEntityRepository repository;

    public MovieEntityServiceImpl() {

    }

    @Autowired
    public MovieEntityServiceImpl(MovieEntityRepository repository) {
        this.repository = repository;
    }

}
