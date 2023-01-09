package main.kotlin.imedia_backend_assignment.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/products")
@RestController
class ProductController(private val service: ProductService) {

    //this is an endpoint to get all products in our db
    @GetMapping("/products")
    fun getAllProducts() = service.getAll()
    //this is an endpoint to get all products in our db relevant to some skus specified in the uri
    @GetMapping("/products/{skus}")
    fun getAllProductsbySkus() = service.getAllById()

    //this is an endpoint to get 1 product from our db with a specific sku id
    @GetMapping("products/{sku}")
    fun getProduct(@PathVariable sku: String) = service.getById(sku)

    //this is an endpoint to save 1 product into our db with a specific sku id
    @PostMapping("products/{sku}")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveProduct(@RequestBody product: Product): Product = service.create(product)

    //this is an endpoint to delete 1 product from our db with a specific sku id
    @DeleteMapping("products/{sku}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteProduct(@PathVariable sku: String) = service.remove(sku)

    //this is an endpoint to update 1 product in our db with a specific sku id
    @PutMapping("products/{sku}")
    fun updateProduct(
            @PathVariable sku: String, @RequestBody product: Product
    ) = service.update(sku, product)
}