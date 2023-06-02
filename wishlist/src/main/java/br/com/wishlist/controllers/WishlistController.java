package br.com.wishlist.controllers;

import br.com.wishlist.documents.Wishlist;
import br.com.wishlist.responses.Response;
import br.com.wishlist.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/wishlist")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;

    @GetMapping
    public ResponseEntity<List<Wishlist>> listAll(){
        return ResponseEntity.ok(this.wishlistService.listAll());

    }

    @GetMapping(path = "/{id}")
    public Object listById(@Validated @PathVariable(name = "id") String id, BindingResult result){
        if(result.hasErrors()){
            List<String> errors = new ArrayList<String>();
            result.getAllErrors().forEach(error->errors.add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.ok();
    }
    @PostMapping
    public ResponseEntity<Response<Wishlist>> addWishlist(@Validated @RequestBody Wishlist wishlist, BindingResult result){
        if(result.hasErrors()){
            List<String> errors = new ArrayList<String>();
            result.getAllErrors().forEach(error->errors.add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(new Response<Wishlist>(errors));
        }
        return ResponseEntity.ok(new Response<Wishlist>(this.wishlistService.addWishlist(wishlist)));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Integer> remove(@PathVariable(name = "id") String id){
        this.wishlistService.remove(id);
        return ResponseEntity.ok(1);
    }
}
