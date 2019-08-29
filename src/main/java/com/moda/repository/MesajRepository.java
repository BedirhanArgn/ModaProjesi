package com.moda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.moda.model.Mesaj;

public interface MesajRepository extends CrudRepository<Mesaj, Long> {
	List<Mesaj> findById(int mesajId);
}