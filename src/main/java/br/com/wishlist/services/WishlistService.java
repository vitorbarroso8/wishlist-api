package br.com.wishlist.services;

import br.com.wishlist.documents.Product;
import br.com.wishlist.documents.Wishlist;

import java.util.List;
import java.util.Optional;

public interface WishlistService {

    Optional<Wishlist> getWishlistByUserId(String userId);

    Optional<Wishlist> listById(String id);

    Wishlist addWishlist(Wishlist wishlist);



}
