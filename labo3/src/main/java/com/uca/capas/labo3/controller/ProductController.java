package com.uca.capas.labo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.labo3.domain.Product;

@Controller
public class ProductController {
	
	private List<Product> productos = new ArrayList<Product>(); //Lista de productos 
	
	@GetMapping("/compraProducto") //inicio
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		//Agregando artículos de computo 
		productos.add(new Product(0, "Monitor FHD Samsung", 25 ));
		productos.add(new Product(1, "Mouse HP Spectre 500", 35 ));
		productos.add(new Product(2, "Teclado Logitech K780", 20 ));
		productos.add(new Product(3, "Disco externo Samsung 1TB", 15 ));
		productos.add(new Product(4, "Memoria USB Kingston DT 1TB", 50 ));
		productos.add(new Product(5, "Tarjeta gráfica GeForce RTX", 5 ));
		productos.add(new Product(6, "SSD Kingston 250GB", 10 ));
		
		mav.setViewName("productos"); //Llevamos todos los datos a la vista productos.html
		mav.addObject("product", new Product()); // Añadimos un producto vacío
		mav.addObject("producto", productos); // Enviamos la lista de productos
		return mav;
		
	}
	
	@PostMapping("/validar")
	@ResponseBody
	public String validar(Product product) { //Retorna producto seleccionado con su respectiva cantidad
		return productos.get(product.getId()).getNombre() + "\n" + productos.get(product.getId()).getCantidad(); 
	}
	

}