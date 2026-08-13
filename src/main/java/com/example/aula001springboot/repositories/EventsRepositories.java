package com.example.aula001springboot.repositories;

import com.example.aula001springboot.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepositories extends JpaRepository<Events,Long> {

}
