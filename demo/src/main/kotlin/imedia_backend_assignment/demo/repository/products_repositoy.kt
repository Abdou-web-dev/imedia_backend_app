//Let’s now create our JPA repository, first create an interface called ProductRepository,
//annotate with @Repository and extends JpaRepository by passing the Product model and the ID data type.
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
interface ProductRepository : JpaRepository<Product, String>


//Because of the inheritance mentioned above, JpaRepository will have all the functions of
// CrudRepository and PagingAndSortingRepository. So if you don't need the repository to have
// the functions provided by JpaRepository and PagingAndSortingRepository , use CrudRepository.

