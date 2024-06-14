package com.aman.bookapplication.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDto {
    String title;
    @JsonProperty("ISBN")
    String ISBN;
    LocalDate publicationDate;
    BigDecimal price;

}