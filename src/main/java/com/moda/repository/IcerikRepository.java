package com.moda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.moda.model.Icerik;

public interface IcerikRepository extends CrudRepository<Icerik, Long> {
	List<Icerik> findById(int icerikID);
}
