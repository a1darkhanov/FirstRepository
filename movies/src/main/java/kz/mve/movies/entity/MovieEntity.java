package kz.mve.movies.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="movies")
public class MovieEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "movies_seq", sequenceName = "movies_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movies_seq")
    private long movieId;
    private String title;
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
