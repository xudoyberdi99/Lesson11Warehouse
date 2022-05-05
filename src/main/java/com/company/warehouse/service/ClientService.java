package com.company.warehouse.service;

import com.company.warehouse.entity.Client;
import com.company.warehouse.entity.Supplier;
import com.company.warehouse.payload.Result;
import com.company.warehouse.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Result addClient(Client client){
        boolean existsByPhoneNumber = clientRepository.existsByPhoneNumber(client.getPhoneNumber());
        if (existsByPhoneNumber){
            return new Result("Bunaqa client bazada bor", false);
        }
        clientRepository.save(client);
        return new Result("client bazaga qushildi", true);
    }
    public List<Client> getClients(){
        List<Client> all = clientRepository.findAll();
        return all;
    }
    public Client getClient(Integer id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.orElseGet(Client::new);
    }
    public Result deleteClient(Integer id){
        clientRepository.deleteById(id);
        return new Result("client uchirildi",true);
    }

    public Result editClient(Integer id, Client client){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()){
            return new Result("bunday client mavjud emas",false);
        }
       Client client1=new Client();
        client1.setName(client.getName());
        client1.setPhoneNumber(client.getPhoneNumber());
        client1.setActive(true);
        clientRepository.save(client1);
        return new Result("edit client date",true);
    }

}
