package br.com.wishlist.services;

import br.com.wishlist.documents.Wishlist;

import java.util.List;
import java.util.Optional;

public interface WishlistService {

    List<Wishlist> listAll();
    Optional<Wishlist> listById(String id);
    Wishlist addWishlist(Wishlist wishlist);
    void remove(String id);
}
