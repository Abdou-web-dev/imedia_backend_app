@Service
class ProductService(val repository: ProductRepository) {

    fun getAll(): List<Product> = repository.findAll()
//find a product by its sku unique identifier
    fun getById(sku: String): Product = repository.findByIdOrNull(sku) ?:
    throw ResponseStatusException(HttpStatus.NOT_FOUND)
//find some products by their inque sku  identifier
    fun getAllById((@Param("ids") skus: Array<String?>):List<Product> {
        repository.findAllBy(skus) ?:
        throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    //add a product
    fun create(Product: Product): Product = repository.save(Product)

    //remove a product
    fun remove(sku: String) {
        if (repository.existsById(sku)) repository.deleteById(sku)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    //update a product partially
    fun update(sku:String, newName: String,newDesc :String,newPrice:Int,Product: Product): Product {
        return if (repository.existsById(sku)) {
            Product.name = newName
            Product.description = newDesc
            Product.price = newPrice
            repository.save(Product)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}