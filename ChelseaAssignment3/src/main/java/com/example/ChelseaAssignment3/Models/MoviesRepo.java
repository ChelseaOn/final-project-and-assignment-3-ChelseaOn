package com.example.ChelseaAssignment3.Models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface MoviesRepo extends CrudRepository<Movies, Integer>
{
}