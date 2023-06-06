package br.com.wishlist.services.impl;

import br.com.wishlist.documents.Product;
import br.com.wishlist.repositories.ProductRepository;
import br.com.wishlist.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
}
