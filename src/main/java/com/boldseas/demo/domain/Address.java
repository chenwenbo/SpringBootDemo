package com.boldseas.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * description :
 * author : wenbo.chen@boldseas.com
 * Created time : 2017/07/06 20:01.
 */
@Data
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String province;
    private String city;

    
}
