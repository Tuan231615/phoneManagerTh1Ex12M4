package com.repository;

import com.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISmartRepository extends CrudRepository<Smartphone, Long> {
}
