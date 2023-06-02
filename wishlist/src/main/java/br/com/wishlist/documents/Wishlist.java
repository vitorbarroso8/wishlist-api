package br.com.wishlist.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document
public class Wishlist {
    @Id
    private String id;

    private String user_id;

    private String product_id;

    private String create_date;
}
