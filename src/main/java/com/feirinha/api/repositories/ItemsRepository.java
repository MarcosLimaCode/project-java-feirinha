package com.feirinha.api.repositories;

import com.feirinha.api.models.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<ItemModel, Long> {}
