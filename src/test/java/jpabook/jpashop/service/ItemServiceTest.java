package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Album;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.domain.item.Movie;
import jpabook.jpashop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void save() {

        //given
        Book book = Book.builder()
            .name("Book1")
            .stockQuantity(0)
            .author("LEE")
            .isbn("978-89-408-0353-0")
            .build();

        Album album = Album.builder()
            .name("Album")
            .stockQuantity(0)
            .artist("IU")
            .etc("LILAC")
            .build();

        Movie movie = Movie.builder()
            .name("Album")
            .stockQuantity(0)
            .director("NA HONG SEOCK")
            .actor("KIM YOON SIK")
            .build();

        //when
        itemService.saveItem(book);
        itemService.saveItem(album);
        itemService.saveItem(movie);

        //then
        assertEquals(book, itemRepository.findOne(book.getId()));
        assertEquals(album, itemRepository.findOne(album.getId()));
        assertEquals(movie, itemRepository.findOne(movie.getId()));

    }
}