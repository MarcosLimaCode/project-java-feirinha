package com.feirinha.api.controllers;

import com.feirinha.api.services.ItemsService;
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
  public String getItems() {
    return "Frutas";
  }

  @GetMapping("/{id}")
  public String getItemsById(@PathVariable("id") Long id) {
    return "Fruta no id" + id;
  }

  @PostMapping()
  public String postItems(@RequestBody String body) {
    return body;
  }

  @PutMapping("/{id}")
  public String putItems(@PathVariable("id") Long id, @RequestBody String body) {

    return body;
  }

  @DeleteMapping("/{id}")
  public String deleteItems(@PathVariable("id") Long id) {

    return "Item deletado: " + id;
  }
}
