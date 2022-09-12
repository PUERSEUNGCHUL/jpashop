package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("B")
@NoArgsConstructor
@Getter
public class Book extends Item{

    @Builder
    public Book(Long id, int price, String name, int stockQuantity, List<Category> items, String author, String isbn) {
        super(id, price, name, stockQuantity, items);
        this.author = author;
        this.isbn = isbn;
    }

    private String author;
    private String isbn;
}
