package org.generation.cyberpunk.repositories;

import org.generation.cyberpunk.models.Empleo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleoRepository extends JpaRepository<Empleo, Long> {




}
