package com.example.bolg.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
@Getter
@Setter
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "The title must not be empty")
    @Column(columnDefinition = "varchar(255) not null")
    private String title;

    @NotEmpty(message = "The body must not be empty")
    @Column(columnDefinition = "varchar(255) not null")
    private String body;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="user_id",referencedColumnName = "id" )
    private MyUser user;
}
