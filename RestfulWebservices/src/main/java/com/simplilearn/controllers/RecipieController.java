package com.simplilearn.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
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


import com.simplilearn.entity.Recipie;


import com.simplilearn.service.RecipieService;


@RestController
@RequestMapping("/api/product")
public class RecipieController {

    @Autowired
    private RecipieService recipieservice;

    @PostMapping("/add")
    public List<Recipie> addProduct(@RequestBody Recipie recipe) {
        Recipie dbRecipe = recipieservice.addProduct(recipe);
        return recipieservice.getAllProducts();
    }

    @GetMapping("/list")
    public List<Recipie> getAll() {
        return recipieservice.getAllProducts();
    }

    @GetMapping("/name/{name}")
    public Recipie getProductByName(@PathVariable String name) {
        return recipieservice.Getproductbyname(name);
    }

    @GetMapping("/id/{id}")
    public Optional<Recipie> getProductById(@PathVariable int id) {
        return recipieservice.getProductById(id);
    }

    @GetMapping("/category/{category}")
    public List<Recipie> getProductByCategory(@PathVariable String category) {
        return recipieservice.getRecipeByCategory(category);
    }

    @DeleteMapping("/productIdDelete/{productId}")
    public void deleteById(@PathVariable int productId) {
        recipieservice.deleteProductById(productId);
    }

    @PutMapping("/productIdUpdate/{productId}")
    public Recipie updateById(@PathVariable int productId, @RequestBody Recipie recipie) {
        return recipieservice.updateProduct(productId, recipie);
    }
}
