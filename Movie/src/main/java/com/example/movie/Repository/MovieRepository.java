package com.example.movie.Repository;

import com.example.movie.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
     Movie findMovieByDirectorId(Integer directorId);
     Movie findMovieByName(String name);
     Movie findMovieById(Integer id);
     Movie findMovieByGenre(String genre);
     Movie findMovieByRating(Integer rating);
     Movie findDistinctByRatingGreaterThan(Integer rating);


}
