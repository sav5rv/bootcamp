package com.project.bootcamp.controller;

import com.project.bootcamp.model.dto.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(dto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto) {
        return ResponseEntity.ok(dto);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll()
    {
        List<StockDTO> list = new ArrayList<>();
        StockDTO dto = new StockDTO();
        dto.setId(1L);
        dto.setName("Magazine");
        dto.setPrice(1000D);
        dto.setVariation(10D);
        dto.setData(LocalDate.now());
        list.add(dto);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO>findById(@PathVariable Long id){
        List<StockDTO> listb = new ArrayList<>();
        StockDTO stock1 = new StockDTO();
        stock1.setId(1L);
        stock1.setName("Magazine");
        stock1.setPrice(1000D);
        stock1.setVariation(10D);
        stock1.setData(LocalDate.now());

        StockDTO stock2 = new StockDTO();
        stock2.setId(2L);
        stock2.setName("Luziaaaa");
        stock2.setPrice(1900D);
        stock2.setVariation(500D);
        stock2.setData(LocalDate.now());
        listb.add(stock1);
        listb.add(stock2);

        StockDTO dtoSelect = listb.stream().filter(x -> x.getId().compareTo(id) == 0).findFirst().get();
        return ResponseEntity.ok(dtoSelect);

    }
}