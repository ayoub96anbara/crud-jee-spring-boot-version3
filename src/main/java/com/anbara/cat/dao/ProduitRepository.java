package com.anbara.cat.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.anbara.cat.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

	Page<Produit> findByDesignationContains(String keyword,Pageable pageable);
}
