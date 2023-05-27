package com.example.movie.Controller;

import com.example.movie.Model.Director;
import com.example.movie.Model.Movie;
import com.example.movie.Service.DirectorService;
import com.example.movie.Service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/director")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;
    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getAllDirector(){
        List<Director> directorList=directorService.getAllDirector();
        return ResponseEntity.status(200).body(directorList);
    }

    @PostMapping("/add")
    public ResponseEntity addDirector(@Valid @RequestBody Director director){
        directorService.addDirector(director);
        return ResponseEntity.status(200).body("Director Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDirector(@Valid@RequestBody Director director,@PathVariable Integer id){
        directorService.updateDirector(id,director);
        return ResponseEntity.status(200).body("Director Update");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDirector(@PathVariable Integer id){
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Director Delete");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getDirectorById(@PathVariable Integer id){
        Director director =directorService.findDirectorById(id);
        return ResponseEntity.status(200).body("get by id");
    }

    @GetMapping("/get-name/{name}")
    public ResponseEntity getDirectorByName(@PathVariable String name){
        List<Director> directors=directorService.findDirectorByName(name);
        return ResponseEntity.status(200).body("get by name");
    }

    @GetMapping("/get-movie/{director}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        List<Movie> movies=directorService.findMovieByName(name);
        return ResponseEntity.status(200).body("Get by name");
    }

}
