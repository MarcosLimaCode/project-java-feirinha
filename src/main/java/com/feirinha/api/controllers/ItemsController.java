package com.feirinha.api.controllers;

import com.feirinha.api.dtos.ItemsDTO;
import com.feirinha.api.models.ItemModel;
import com.feirinha.api.services.ItemsService;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemsController {

  final ItemsService itemsService;

  ItemsController(ItemsService itemsService) {
    this.itemsService = itemsService;
  }

  @GetMapping()
  public ResponseEntity<Object> getItems() {
    return ResponseEntity.status(HttpStatus.OK).body(itemsService.getItems());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getItemsById(@PathVariable("id") Long id) {
    Optional<ItemModel> item = itemsService.getItemsById(id);

    return ResponseEntity.status(HttpStatus.OK).body(item);
  }

  @PostMapping()
  public ResponseEntity<Object> createItem(@RequestBody @Valid ItemsDTO body) {
    Optional<ItemModel> item = itemsService.createItem(body);

    if (!item.isPresent()) {
      return ResponseEntity.status(HttpStatus.CONFLICT).body("Item já cadastrado.");
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(item.get());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> putItem(@PathVariable Long id, @RequestBody @Valid ItemsDTO body) {

    Optional<ItemModel> item = itemsService.putItem(id, body);

    if (!item.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não encontrado.");
    }

    return ResponseEntity.status(HttpStatus.OK).body(item.get());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteItem(@PathVariable Long id) {
    itemsService.deleteItem(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
