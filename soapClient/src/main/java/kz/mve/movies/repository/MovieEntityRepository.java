package kz.mve.movies.repository;

import kz.mve.movies.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieEntityRepository extends JpaRepository<MovieEntity, Long> {

}
