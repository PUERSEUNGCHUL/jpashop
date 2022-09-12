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
@DiscriminatorValue("A")
@Getter
@NoArgsConstructor
public class Album extends Item{

    @Builder
    public Album(Long id, int price, String name, int stockQuantity, List<Category> items, String artist, String etc) {
        super(id, price, name, stockQuantity, items);
        this.artist = artist;
        this.etc = etc;
    }

    private String artist;
    private String etc;
}
