package com.codingdojo.ct.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.ct.models.Category;
import com.codingdojo.ct.repositories.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository){
		this.categoryRepository=categoryRepository;
	}
	
	//This method returns all the categories
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	//This method creates a new category
	
	public Category createCategory(Category c) {
		return categoryRepository.save(c);
	}
	
	//This method updates an existing category

	public Category updateCategory(Category u) {
		return categoryRepository.save(u);
	}
	
	//This method returns one record from category
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		else {
			return null;
		}
	}
	
	//This method deletes a record from category
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}
}
