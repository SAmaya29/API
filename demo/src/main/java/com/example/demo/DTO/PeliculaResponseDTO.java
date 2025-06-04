package com.example.demo.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PeliculaResponseDTO {

    private int page;
    private List<PeliculaDTO> results;
    private int total_pages;
    private int total_results;
}
