package com.company.warehouse.controller;

import com.company.warehouse.entity.Currency;
import com.company.warehouse.entity.Measurement;
import com.company.warehouse.payload.Result;
import com.company.warehouse.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;
    @PostMapping
    public Result addCurrency(@RequestBody Currency currency){
        Result result = currencyService.addCurrency(currency);
        return result;
    }

    @GetMapping
    public List<Currency> getListCurrency(){
        List<Currency> currencyList = currencyService.getCurrencyList();
        return currencyList;
    }

    @GetMapping("/{id}")
    public Currency getCurrencyId(@PathVariable Integer id){
        Currency currencyId = currencyService.getCurrencyId(id);
        return currencyId;
    }
    @DeleteMapping("/{id}")
    public Result deleteMeasurement(@PathVariable Integer id){
        Result result = currencyService.deleteCurrency(id);
        return result;
    }
    @PutMapping("/{id}")
    public Result editMeasurement(@PathVariable Integer id, @RequestBody Currency currency){
        Result result = currencyService.editCurrency(id,currency);
        return result;
    }
}
