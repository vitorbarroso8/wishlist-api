package br.com.wishlist.repositories;
import br.com.wishlist.documents.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WishlistRepository extends MongoRepository<Wishlist, String> {
}
