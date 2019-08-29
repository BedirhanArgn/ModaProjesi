package com.moda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.moda.model.IcerikTuru;

public interface IcerikTuruRepository extends CrudRepository<IcerikTuru, Long> {
	List<IcerikTuru> findById(int turID);
}
