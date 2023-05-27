package com.example.movie.Controller;

import com.example.movie.Model.Movie;
import com.example.movie.Service.DirectorService;
import com.example.movie.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final DirectorService directorService;
    @GetMapping("/get")
    public ResponseEntity getAllMovie(){

        List<Movie> movieList=movieService.getAllMovie();
        return ResponseEntity.status(200).body(movieList);
    }
    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie){

        movieService.addMovie(movie);
        return ResponseEntity.status(200).body("Movie Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@Valid @RequestBody Movie movie,@PathVariable Integer id){
        movieService.updateMovie(id, movie);
        return ResponseEntity.status(200).body("Movie Update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie Delete");

    }

//Search  by title
    @GetMapping("/get-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Movie movie=movieService.findMovieByName(name);
        return ResponseEntity.status(200).body("get by name");
    }

    // search duration of the movie
    @GetMapping("/get-duration/{name}")
    public ResponseEntity findDuration(@PathVariable String name ){
      return ResponseEntity.status(200).body(findDuration(name));
    }

    @GetMapping("/get-director/{id}")
    public ResponseEntity findMovieByDirectorID(@PathVariable int id){
        return ResponseEntity.status(200).body(findMovieByDirectorID(id));
    }

    @GetMapping("/get-rate/{name}")
    public ResponseEntity findMovieByRating(@PathVariable int Rsting){
        return ResponseEntity.status(200).body(findMovieByRating(Rsting));
    }

    @GetMapping("/get-rate/{rating}")
    public ResponseEntity findMovieByRatingGreatthan(@PathVariable int rating){
        return ResponseEntity.status(200).body(findMovieByRatingGreatthan(rating));
    }


    @GetMapping("/get-gener/{gener}")
    public ResponseEntity findMovieByGenre(String name){
        return ResponseEntity.status(200).body(findMovieByGenre(name));
    }



}
