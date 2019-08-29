package com.moda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.moda.model.Yorum;

public interface YorumRepository extends CrudRepository<Yorum, Long> {
	List<Yorum> findById(int id);

	Iterable<Yorum> findAll();
}

