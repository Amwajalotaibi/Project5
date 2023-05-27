package com.example.movie.Repository;

import com.example.movie.Model.Director;
import com.example.movie.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {

    Director findDirectorById(Integer id);

    List<Director> findDirectorByName(String name);

    List<Movie> findDistinctByName(String name);


}
