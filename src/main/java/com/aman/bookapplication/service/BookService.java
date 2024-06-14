package com.aman.bookapplication.service;

import com.aman.bookapplication.dto.BookRequestDto;
import com.aman.bookapplication.dto.BookResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<List<BookResponseDto>> addAllBook(List<BookRequestDto> bookRequestDtoList);
    Page<BookResponseDto> findAll(int pageNumber, int pageSize, String direction, String sortBy);
}
