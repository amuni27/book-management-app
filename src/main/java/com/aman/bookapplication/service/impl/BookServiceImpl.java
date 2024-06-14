package com.aman.bookapplication.service.impl;

import com.aman.bookapplication.dto.BookRequestDto;
import com.aman.bookapplication.dto.BookResponseDto;
import com.aman.bookapplication.model.Book;
import com.aman.bookapplication.repository.BookRepository;
import com.aman.bookapplication.service.BookService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository BookRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<List<BookResponseDto>> addAllBook(List<BookRequestDto> bookRequestDtoList) {
        List<Book> bookList = modelMapper.map(bookRequestDtoList, new TypeToken<List<Book>>() {
        }.getType());
        List<Book> savedBookList = BookRepository.saveAll(bookList);
        List<BookResponseDto> responsebookList = modelMapper.map(savedBookList, new TypeToken<List<BookResponseDto>>() {
        }.getType());
        return Optional.of(responsebookList);
    }

    @Override
    public Page<BookResponseDto> findAll(int pageNumber, int pageSize, String direction, String sortBy) {
        Pageable pageable = PageRequest.of(
                pageNumber,
                pageSize,
                Sort.Direction.fromString(direction),
                sortBy);
        //it return a page (mention in pagable book) of book
        Page<Book> bookPage = BookRepository.findAll(pageable);
        List<BookResponseDto> bookResponseDtoList =
                bookPage.stream().map(book -> modelMapper.map(book, BookResponseDto.class)).toList();
        System.out.println("Intermidiet Result" + bookResponseDtoList);
        return new PageImpl<>(bookResponseDtoList, pageable, bookPage.getTotalElements());

//        Page<BookResponseDto> responseDtoPage= modelMapper.map(bookPage,new TypeToken<Page<Book>>() {
//        }.getType());
//        return responseDtoPage;
    }
}
