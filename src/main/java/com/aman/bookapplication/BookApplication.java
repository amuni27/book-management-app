package com.aman.bookapplication;

import com.aman.bookapplication.dto.BookRequestDto;
import com.aman.bookapplication.dto.BookResponseDto;
import com.aman.bookapplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
@RequiredArgsConstructor
public class BookApplication implements CommandLineRunner {
    private final BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BookRequestDto dto = new BookRequestDto("title1", "1234", LocalDate.of(2021, 1, 1), BigDecimal.valueOf(20.35));
        BookRequestDto dto1 = new BookRequestDto("title2", "12345", LocalDate.of(2021, 2, 1), BigDecimal.valueOf(20.35));
        BookRequestDto dto2 = new BookRequestDto("title3", "12346", LocalDate.of(2021, 3, 1), BigDecimal.valueOf(20.35));
        BookRequestDto dto3 = new BookRequestDto("title4", "12347", LocalDate.of(2021, 3, 1), BigDecimal.valueOf(20.35));
        BookRequestDto dto4 = new BookRequestDto("title5", "12348", LocalDate.of(2021, 4, 1), BigDecimal.valueOf(20.35));
        BookRequestDto dto5 = new BookRequestDto("title6", "12349", LocalDate.of(2021, 5, 1), BigDecimal.valueOf(20.35));
        BookRequestDto dto6 = new BookRequestDto("title7", "12344", LocalDate.of(2021, 5, 1), BigDecimal.valueOf(20.35));
        System.out.println(
                bookService.addAllBook(
                        List.of(dto, dto1, dto2, dto3, dto4, dto5, dto6)
                )
        );

       bookService.findAll(0,4,"ASC","title").forEach(System.out::println);

    }
}
