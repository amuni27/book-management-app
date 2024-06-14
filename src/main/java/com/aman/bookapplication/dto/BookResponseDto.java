package com.aman.bookapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    String title;
    String ISBN;
    LocalDate publicationDate;
    BigDecimal price;
}
