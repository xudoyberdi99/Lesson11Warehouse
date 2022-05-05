package com.company.warehouse.controller;

import com.company.warehouse.entity.Client;
import com.company.warehouse.entity.Supplier;
import com.company.warehouse.payload.Result;
import com.company.warehouse.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping
    public Result addClient(@RequestBody Client client){
        Result result = clientService.addClient(client);
        return result;
    }
    @GetMapping
    public List<Client> getClients(){
        List<Client>  clients= clientService.getClients();
        return clients;
    }
    @GetMapping("/{id}")
    public Client getClient(@PathVariable Integer id){
        Client client = clientService.getClient(id);
        return client;
    }
    @PutMapping("/{id}")
    public Result editClient(@PathVariable Integer id, @RequestBody Client client){
        Result result = clientService.editClient(id, client);
        return result;
    }
    @DeleteMapping("/{id}")
    public Result deleteSupplier(@PathVariable Integer id){
        Result result = clientService.deleteClient(id);
        return result;
    }
}
