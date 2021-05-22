package springboot.northwind.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.northwind.business.abstracts.ProductService;
import springboot.northwind.core.utilities.results.DataResult;
import springboot.northwind.core.utilities.results.Result;
import springboot.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private ProductService productService;

	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {

		return this.productService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
}
