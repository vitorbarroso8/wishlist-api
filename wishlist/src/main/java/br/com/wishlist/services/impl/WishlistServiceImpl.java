package br.com.wishlist.services.impl;

import br.com.wishlist.documents.Wishlist;
import br.com.wishlist.repositories.WishlistRepository;
import br.com.wishlist.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;


    @Override
    public Optional<Wishlist> getWishlistByUserId(String userId) {
        return this.wishlistRepository.findById(userId);
    }

    @Override
    public Optional<Wishlist> listById(String id) {
        return this.wishlistRepository.findById(id);
    }

    @Override
    public Wishlist addWishlist(Wishlist wishlist) {
        return this.wishlistRepository.save(wishlist);
    }
}
