package com.example.festora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.festora.model.Amizade;

import jakarta.transaction.Transactional;

@Repository
public interface AmizadeRepository extends JpaRepository<Amizade, String> {

	@Transactional
	@Modifying
	@Query("DELETE FROM Amizade a WHERE a.id = :amizadeId")
	void excluirAmizade(String amizadeId);
}
