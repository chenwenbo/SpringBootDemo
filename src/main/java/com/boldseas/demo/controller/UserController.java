package com.boldseas.demo.controller;

import com.boldseas.demo.domain.User;
import com.boldseas.demo.dto.UserDto;
import com.boldseas.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description :
 * author : wenbo.chen@boldseas.com
 * Created time : 2017/07/06 14:36.
 */
@RestController
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/users")
    public UserDto[] findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userRepository.findAll(), UserDto[].class);
    }

    @GetMapping(value = "/user/{id}")
    public UserDto findById(@PathVariable("id")Long id) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userRepository.findOne(id), UserDto.class);
    }

    @PutMapping(value = "/user")
    public void update(@RequestBody UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteById(@PathVariable("id")Long id) {
        userRepository.delete(id);
    }

    @PostMapping(value = "/user")
    public void save(@RequestBody List<User> users) {
        userRepository.save(users);
    }
}
