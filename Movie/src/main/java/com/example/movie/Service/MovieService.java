package com.example.movie.Service;

import com.example.movie.Model.Movie;
import com.example.movie.Repository.DirectorRepository;
import com.example.movie.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }
    public void updateMovie(Integer id, Movie movie){
        Movie oldMovie=movieRepository.findMovieById(id);
        if (oldMovie==null){
            throw new ArithmeticException("Movie not Found");
        }
        oldMovie.setName(movie.getName());
        oldMovie.setDuration(movie.getDuration());
        oldMovie.setRating(movie.getRating());
        oldMovie.setGenre(movie.getGenre());
        oldMovie.setDirectorId(movie.getDirectorId());

        movieRepository.save(oldMovie);

    }

    public void deleteMovie(Integer id){
        Movie oldMovie=movieRepository.findMovieById(id);
        if (oldMovie==null){
            throw new ArithmeticException("Movie not Found");
        }
        movieRepository.delete(oldMovie);
    }
    //Search  by title
    public Movie findMovieByName(String name){
        Movie  movie=movieRepository.findMovieByName(name);
        if(movie==null){
            throw new ArithmeticException("name not found");
        }
        return movie;
    }

        public int findDuration(String name){
           Movie movie = movieRepository.findMovieByName(name);
            if (movie==null) {
                throw new ArithmeticException("Movie not found");
            }
            return movie.getDuration();

        }


//    Create endpoint that takes movie name and return the director name

    public Integer findMovieByDirectorId(String name){
       Movie movie=movieRepository.findMovieByName(name);
        if (movie==null) {
            throw new ArithmeticException("Director id not found");
        }
        return movie.getDirectorId();
        }


//Create endpoint that takes movie name and return the rate of the movie
      public Movie getMovieByRate(int Rating){
        Movie movie=movieRepository.findMovieByRating(Rating);
        if(movie==null){
            throw new ArithmeticException("Rating not found");
        }
        return movie;
      }


//    Create endpoint that returns all movies above that rate
      public int getMoviesByRateing(Integer rating){
        Movie movie = movieRepository.findDistinctByRatingGreaterThan(rating);
        if(movie==null){
            throw new ArithmeticException("movies above that rate not found");
        }
        return movie.getRating();
      }


   // Create endpoint that returns all movies by a specific genre
    public Movie getMovieByGenre(String genre){
        Movie movie=movieRepository.findMovieByGenre(genre);
        if(movie==null){
            throw new ArithmeticException("movies of this genre not found");
        }
        return movie;

    }






}
