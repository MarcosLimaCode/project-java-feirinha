package com.feirinha.api.services;

import com.feirinha.api.repositories.ItemsRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
  final ItemsRepository itemsRepository;

  ItemsService(ItemsRepository itemsRepository) {
    this.itemsRepository = itemsRepository;
  }
}
