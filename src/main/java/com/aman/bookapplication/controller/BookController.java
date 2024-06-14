package com.aman.bookapplication.controller;

import com.aman.bookapplication.dto.BookRequestDto;
import com.aman.bookapplication.dto.BookResponseDto;
import com.aman.bookapplication.repository.BookRepository;
import com.aman.bookapplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{pageNo}/{pageSize}/{direction}/{sortBy}")
    public ResponseEntity<List<BookResponseDto>> getAllBook(
            @PathVariable Integer pageNo,
            @PathVariable Integer pageSize,
            @PathVariable String direction,
            @PathVariable String sortBy
    ) {
        Page<BookResponseDto> bookResponseDtos = bookService.findAll(pageNo, pageSize, direction, sortBy);
        if (bookResponseDtos.getTotalElements() > 0) {
            return ResponseEntity.ok(bookResponseDtos.getContent());
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Optional<List<BookResponseDto>>> createBook(
            @RequestBody List<BookRequestDto> bookRequestDto
    ) throws URISyntaxException {
        Optional<List<BookResponseDto>> bookResponseDtos = bookService.addAllBook(bookRequestDto);
        if (bookResponseDtos.isPresent()) {
            return ResponseEntity.created(new URI("/book")).body(bookResponseDtos);
        }
        return ResponseEntity.noContent().build();
    }
}
