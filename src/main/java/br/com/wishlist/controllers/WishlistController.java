package br.com.wishlist.controllers;

import br.com.wishlist.documents.Product;
import br.com.wishlist.documents.Wishlist;
import br.com.wishlist.services.ProductService;
import br.com.wishlist.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/wishlist")
public class WishlistController {
    String userId = "1";
    int MAX_PRODUCT_IN_WISHLIST = 20;
    @Autowired
    private WishlistService wishlistService;
    @Autowired
    private ProductService productService;

    //Salva um produto
    @PostMapping(path ="/product/new")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.addProduct(product));
    }

    //Retorna a wishlist do cliente
    @GetMapping
    public ResponseEntity<Wishlist> getWishlist(){
        if(this.wishlistService.getWishlistByUserId(userId).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.wishlistService.getWishlistByUserId(userId).get());
    }

    //Adiciona o produto a wishlist do cliente, se não tiver 20 produtos
    @PostMapping(name = "/product")
    public ResponseEntity<Wishlist> addProduct(@RequestBody Product product){
        Optional<Wishlist> optional = wishlistService.getWishlistByUserId(userId);
        if(this.wishlistService.getWishlistByUserId(userId).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Wishlist wishlist = optional.get();
        if(wishlist.getProducts().size() == MAX_PRODUCT_IN_WISHLIST){
            return ResponseEntity.ok(wishlist);
        }
        wishlist.getProducts().add(product);
        wishlistService.addWishlist(wishlist);

        return ResponseEntity.ok(wishlist);
    }

    //Deleta o produto da lista pelo id do produto
    @DeleteMapping(path = "/product/{id}")
    public ResponseEntity<Wishlist> removeProduct(@PathVariable(name = "id") String id){
        Optional<Wishlist> optional = wishlistService.getWishlistByUserId(userId);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        //remover

        wishlistService.addWishlist(optional.get());
        return ResponseEntity.ok(optional.get());
    }

    //Lista o produto pelo id do produto
    @GetMapping(path = "/product/{id}")
    public ResponseEntity<Product> searchByProductId(@PathVariable(name = "id") String id){
        Optional<Wishlist> optional = wishlistService.getWishlistByUserId(userId);
        if(optional.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        /*if(optional.get().getProducts().contains()){
            return ResponseEntity.ok(optional.get().getProducts()
        }*/

        return ResponseEntity.noContent().build();
    }
}
