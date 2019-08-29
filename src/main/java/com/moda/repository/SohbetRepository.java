package com.moda.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.moda.model.Sohbet;
public interface SohbetRepository extends CrudRepository<Sohbet, Long> {
	List<Sohbet> findById(int sohbetID);
}
