package com.simplilearn.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.simplilearn.entity.Recipie;
import com.simplilearn.repo.RecipieRepository;


@Service
public class RecipieService {

    @Autowired
    private RecipieRepository recipieRepository;

    public List<Recipie> getAllProducts() {
        return recipieRepository.findAll();
    }

    public Optional<Recipie> getProductById(int id) {
        return recipieRepository.findById(id);
    }

    public List<Recipie> getRecipeByCategory(String category) {
        return recipieRepository.findByCategory(category);
    }

    public Recipie addProduct(Recipie product) {
        return recipieRepository.save(product);
    }

    public void deleteProductById(int id) {
        recipieRepository.deleteById(id);
    }

    public Recipie updateProduct(int id, Recipie newProduct) {
        Recipie oldProduct = recipieRepository.findById(id).get();

        if (recipieRepository.findById(id).isPresent()) {
            oldProduct.setName(newProduct.getName());
            oldProduct.setIngrediants(newProduct.getIngrediants());
            oldProduct.setCategory(newProduct.getCategory());
            oldProduct.setImgurl(newProduct.getImgurl());
            oldProduct.setCookingSteps(newProduct.getCookingSteps());
            recipieRepository.save(oldProduct);
        }

        return oldProduct;
    }
//	public Recipie Getproductbycategory(String category){
//		
//		return recipieRepository.findByCategory(category);
//		
//	}

    public Recipie Getproductbyname(String name) {
        Recipie recipie = recipieRepository.Findbyname(name);
        return recipie;

    }


}
