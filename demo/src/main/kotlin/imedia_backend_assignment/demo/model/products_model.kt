@Entity
@Table(name = "prdocuts")
data class Product(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var sku: String,
        var name: String,
        var description: String,
        var price: Double,
        //extend the db shema
        var stock_info : String
)
//GenerationType.AUTO or GenerationType.IDENTITY ??

//A SKU is a unique code consisting of letters and numbers that identify characteristics
// about each product, such as manufacturer, brand, style, color, and size. Companies
// issue their own unique SKU codes specific to the goods and services it sells.
//the sku plays the role of the id
