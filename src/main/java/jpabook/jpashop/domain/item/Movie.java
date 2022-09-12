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
@DiscriminatorValue("M")
@Getter
@NoArgsConstructor
public class Movie extends Item{

    @Builder
    public Movie(Long id, int price, String name, int stockQuantity, List<Category> items, String director, String actor) {
        super(id, price, name, stockQuantity, items);
        this.director = director;
        this.actor = actor;
    }

    private String director;
    private String actor;
}
