package com.company.warehouse.service;

import com.company.warehouse.entity.Currency;
import com.company.warehouse.entity.Measurement;
import com.company.warehouse.payload.Result;
import com.company.warehouse.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addCurrency(Currency  currency){
        boolean byName = currencyRepository.existsByName(currency.getName());
        if (byName){
            return new Result("bunday pul birligi mavjud",false);
        }
        currencyRepository.save(currency);
        return new Result("muvaffaqiyatli saqlandi",true);
    }

    public List<Currency> getCurrencyList(){
        List<Currency> all = currencyRepository.findAll();
        return all;
    }

    public Currency getCurrencyId(Integer id){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isPresent()){
            Currency currency = optionalCurrency.get();
            return currency;
        }
        return new Currency();
    }

    public Result deleteCurrency(Integer id) {
        currencyRepository.deleteById(id);
        return new Result("Pul birligi uchirildi", true);
    }

    public Result editCurrency(Integer id, Currency currency){
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent()){
            return new Result("bunday pul birligi  mavjud emas",false);
        }
        Currency currency1 = optionalCurrency.get();
        currency1.setName(currency.getName());
        currency1.setActive(currency.isActive());
        currencyRepository.save(currency1);
        return new Result("pul birligi uzgartirildi", true);
    }
}
