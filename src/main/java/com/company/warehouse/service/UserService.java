package com.company.warehouse.service;

import com.company.warehouse.entity.User;
import com.company.warehouse.entity.Warehouse;
import com.company.warehouse.payload.Result;
import com.company.warehouse.payload.UserDto;
import com.company.warehouse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Result addUser(User user){
        boolean phoneNumber = userRepository.existsByPhoneNumber(user.getPhoneNumber());
        if (phoneNumber){
            return new Result("bunday user bazada mavjud",false);
        }
        userRepository.save(user);
        return new Result("user qushildi",true);
    }
    public List<User> getUserAll(){
        List<User> all = userRepository.findAll();
        return all;
    }
    public User getUser(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(User::new);
    }

    public Result deleteUser(Integer id){
        userRepository.deleteById(id);
        return new Result("user uchirildi",true);
    }

    public Result editUser(Integer id, UserDto userDto){
        boolean phoneNumber = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());
        if (!phoneNumber){
            return new Result("bunday user mavjud emas",false);
        }
        Set<Warehouse> byWarehouses = userRepository.findAllByWarehousesId(userDto.getWarehouseId());
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
        User user = optionalUser.get();
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setActive(true);
        user.setCode("1");
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setPassword(userDto.getPassword());
        user.setWarehouses(byWarehouses);
        userRepository.save(user);
        return new Result("edit user",true);
        }

        return new Result("not found user", false);
    }

}
