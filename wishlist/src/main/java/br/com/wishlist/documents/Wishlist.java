package br.com.wishlist.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Document
public class Wishlist {
    @Id
    private String id;

    private String userId;

    private List<Product> products;

    private String createDate;
}
