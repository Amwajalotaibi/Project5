package com.example.movie.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "can not be null")
    @Column(columnDefinition = "varchar(10) not null")
    @Size(min = 3,max = 10,message = "name must be Length more than 2")
    private String name;

    @NotEmpty(message = "can not be null")
    @Column(columnDefinition = "varchar(10) not null check(genre='Drama' or genre= 'Action' or genre='Comedy')")
    private String genre;// نوع الفيلم

    @NotNull(message = "can not be null")
    @Column(columnDefinition = "int not null")
    @Size(min = 1,max = 5,message = "Rating must be between 1-5")
    private Integer rating;//  تقييم الفيلم

    @NotNull(message =" can not be null")
    @Column(columnDefinition = "int not null")
    @Size(min = 61,max = 120,message = "Duration it must be more than 60")
    private Integer duration;//مدة الفيلم

    @NotNull(message = "can not null")
    @Size(min = 4,max = 10,message = "directorId must be more  than 3")
    @Column(columnDefinition = "int")
    private Integer directorId;
}
