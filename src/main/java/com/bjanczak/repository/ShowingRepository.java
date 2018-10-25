package com.bjanczak.repository;

import com.bjanczak.model.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowingRepository extends JpaRepository<Showing, Integer> {
}
