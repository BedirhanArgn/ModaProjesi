package com.moda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.moda.model.Tarz;

public interface TarzRepository extends CrudRepository<Tarz, Long> {
	List<Tarz> findById(int id);

	Tarz save(Tarz tarz);
}
