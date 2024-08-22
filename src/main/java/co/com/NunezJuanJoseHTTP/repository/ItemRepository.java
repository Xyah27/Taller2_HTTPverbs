package co.com.NunezJuanJoseHTTP.repository;
import co.com.NunezJuanJoseHTTP.model.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface ItemRepository extends MongoRepository<GroceryItem, String>{
}
