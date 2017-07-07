package com.boldseas.springboot.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * description :
 * author : wenbo.chen@boldseas.com
 * Created time : 2017/07/06 14:33.
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String password;



}
