package com.feirinha.api.services;

import com.feirinha.api.dtos.ItemsDTO;
import com.feirinha.api.models.ItemModel;
import com.feirinha.api.repositories.ItemsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {
  final ItemsRepository itemsRepository;

  ItemsService(ItemsRepository itemsRepository) {
    this.itemsRepository = itemsRepository;
  }

  public List<ItemModel> getItems() {
    return itemsRepository.findAll();
  }

  public Optional<ItemModel> getItemsById(Long id) {

    Optional<ItemModel> items = itemsRepository.findById(id);

    if (!items.isPresent()) {
      return Optional.empty();
    }

    return items;
  }

  public Optional<ItemModel> createItem(ItemsDTO body) {

    if (itemsRepository.existsByName(body.getName())) {
      return Optional.empty();
    }

    ItemModel item = new ItemModel(body);
    itemsRepository.save(item);

    return Optional.of(item);
  }

  public Optional<ItemModel> putItem(Long id, ItemsDTO body) {

    Optional<ItemModel> item = itemsRepository.findById(id);

    if (!item.isPresent()) {
      return Optional.of(null);
    }

    if (itemsRepository.existsByName(body.getName())) {
      return Optional.empty();
    }

    ItemModel newItem = new ItemModel(body);
    newItem.setId(id);
    itemsRepository.save(newItem);

    return Optional.of(newItem);
  }

  public Optional<ItemModel> deleteItem(Long id) {

    Optional<ItemModel> items = itemsRepository.findById(id);

    if (items.isPresent()) {
      itemsRepository.deleteById(id);
    }

    return Optional.empty();
  }
}
