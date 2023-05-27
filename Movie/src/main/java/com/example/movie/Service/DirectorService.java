package com.example.movie.Service;

import com.example.movie.Model.Director;
import com.example.movie.Model.Movie;
import com.example.movie.Repository.DirectorRepository;
import com.example.movie.Repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {
    private final DirectorRepository directorRepository;
    private final MovieRepository movieRepository;

    public List<Director> getAllDirector(){

        return directorRepository.findAll();
    }

    public void addDirector(Director director){

        directorRepository.save(director);
    }

    public void updateDirector(Integer id, Director director){
        Director oldDirector=directorRepository.findDirectorById(id);
        if (oldDirector==null){
            throw new ArithmeticException("Director not Found");
        }
        oldDirector.setName(director.getName());

        directorRepository.save(oldDirector);
    }

    public void deleteDirector(Integer id){
        Director oldDirector=directorRepository.findDirectorById(id);
        if (oldDirector==null){
            throw new ArithmeticException("Director not Found");
        }
        directorRepository.delete(oldDirector);
    }

    public Director findDirectorById(Integer id){
        Director director=directorRepository.findDirectorById(id);
        if (director==null){
            throw new ArithmeticException("ID not Found");
        }
        return director;
    }

    public List<Director> findDirectorByName(String name){
        List<Director> directors=directorRepository.findDirectorByName(name);
        if (directors==null) {
            throw new ArithmeticException("Name not Found");
        }
        return directors;
    }

    //Create endpoint to list movies to a specific director
    public List<Movie> findMovieByName(String name){
        List<Movie> movies=directorRepository.findDistinctByName(name);
        if (movies==null){
            throw new ArithmeticException("list movies of this director not found");

        }
        return movies;
    }



}
