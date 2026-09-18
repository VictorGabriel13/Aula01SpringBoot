package com.example.aula001springboot.repositories;

import com.example.aula001springboot.models.Convidado;
import com.example.aula001springboot.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConvidadoRepositories extends JpaRepository<Convidado,Long> {
    List<Convidado> findByEvento(Events evento);
 }
