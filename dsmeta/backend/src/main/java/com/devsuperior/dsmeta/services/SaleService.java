package com.devsuperior.dsmeta.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;


import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;


@Service
public class SaleService {
   @Autowired
   private SaleRepository repository;

   public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){

       LocalDate toDay = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
       LocalDate min = maxDate.equals("") ? toDay.minusDays(365) : LocalDate.parse(minDate);
       LocalDate max = maxDate.equals("") ? toDay : LocalDate.parse(maxDate);

     return repository.findSales(min, max, pageable);
   }
}
