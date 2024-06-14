package com.aman.bookapplication.repository;

import com.aman.bookapplication.dto.BookRequestDto;
import com.aman.bookapplication.dto.BookResponseDto;
import com.aman.bookapplication.model.Book;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {


}
