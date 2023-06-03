package br.com.wishlist.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String id;
    private String name;
    private String imageURL;
    private String price;
    private String description;


}
