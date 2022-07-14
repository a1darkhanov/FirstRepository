package kz.mve.movies.entity;

import javax.persistence.*;

@Entity
@Table(name="t_movies")
public class MovieEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "movie_id")
    private long movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    public MovieEntity() {

    }

    public MovieEntity(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
