package com.moda.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.moda.model.SilinenSohbet;

public interface SilinenSohbetRepository extends CrudRepository<SilinenSohbet, Long> {
	List<SilinenSohbet> findById(int silinenSohbetID);
}

