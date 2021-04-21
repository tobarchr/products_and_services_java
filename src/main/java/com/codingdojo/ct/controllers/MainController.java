package com.codingdojo.ct.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ct.models.Category;
import com.codingdojo.ct.models.Product;
import com.codingdojo.ct.services.CategoryService;
import com.codingdojo.ct.services.ProductService;


@Controller
public class MainController {
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public MainController(ProductService productService, CategoryService categoryService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	//----------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------
	// Create routes for new Products and Categories
	//----------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------

	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}
	
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	
	//----------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------
	// Save routes for new Products and Categories
	//----------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------

	
    @RequestMapping(value="/products", method=RequestMethod.POST)
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "/products/new.jsp";
        } else {
        	productService.createProduct(product);
            return "redirect:/";
        }
    }
    
    @RequestMapping(value="/categories", method=RequestMethod.POST)
    public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/categories/new.jsp";
        } else {
        	categoryService.createCategory(category);
        	return "redirect:/";
        }
    }
    
	//----------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------
	// View routes for new Products and Categories
	//----------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------

    
    @RequestMapping("/products/{id}")
    public String viewProducts(@PathVariable("id") Long id, Model model) {
    	Product product = productService.findProduct(id);
    	model.addAttribute("product",product);
    	List<Category> categories = categoryService.allCategories();
    	model.addAttribute("categories",categories);
		return "products/view.jsp";
    	
    }
    
    @RequestMapping("/productAddCategory/{id}")
    public String addCategory(@PathVariable("id") Long id, @RequestParam("categories")Long cat_id) {
    	Product product = productService.findProduct(id);
    	Category cat = categoryService.findCategory(cat_id);
    	product.getCategories().add(cat);
    	productService.createProduct(product);
		return "redirect:/";
    }
    
    @RequestMapping("/categories/{id}")
    public String viewCategories(@PathVariable("id") Long id, Model model) {
    	Category category = categoryService.findCategory(id);
    	model.addAttribute("category",category);
    	List<Product> products = productService.findAllProducts();
    	model.addAttribute("products",products);
		return "categories/view.jsp";
    	
    }
    
    @RequestMapping("/categoryAddProduct/{id}")
    public String addProduct(@PathVariable("id") Long cat_id, @RequestParam("products")Long id) {
    	Product product = productService.findProduct(id);
    	Category cat = categoryService.findCategory(cat_id);
    	cat.getProducts().add(product);
    	categoryService.createCategory(cat);
		return "redirect:/";
    }
    
}
