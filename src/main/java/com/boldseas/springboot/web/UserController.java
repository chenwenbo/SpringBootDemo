package com.boldseas.springboot.web;

import com.boldseas.springboot.domain.User;
import com.boldseas.springboot.dto.UserDto;
import com.boldseas.springboot.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * description :
 * author : wenbo.chen@boldseas.com
 * Created time : 2017/07/06 14:36.
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/users")
    @ApiOperation(value = "查询所有用户")
    public UserDto[] findAll() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userRepository.findAll(), UserDto[].class);
    }

    @GetMapping(value = "/user/{userName}")
    @ApiOperation(value = "根据用户名查询所有用户")
    public UserDto[] findByUserName(@PathVariable("userName")String userName) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userRepository.findByUserNameLike("%" + userName + "%"), UserDto[].class);
    }

    @PutMapping(value = "/user")
    @ApiOperation(value = "更新用户信息")
    public void update(@RequestBody UserDto userDto) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
    }

    @DeleteMapping(value = "/user/{id}")
    @ApiOperation(value = "根据用户Id删除用户")
    public void deleteById(@PathVariable("id")Long id) {
        userRepository.delete(id);
    }

    @PostMapping(value = "/user")
    @ApiOperation(value = "新增用户")
    public void save(@RequestBody List<User> users) {
        userRepository.save(users);
    }
}
