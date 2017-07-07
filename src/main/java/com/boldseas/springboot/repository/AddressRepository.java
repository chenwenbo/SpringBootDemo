package com.boldseas.springboot.repository;

import com.boldseas.springboot.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * description :
 * author : wenbo.chen@boldseas.com
 * Created time : 2017/07/06 20:02.
 */
@RepositoryRestResource(path = "address")
public interface AddressRepository extends JpaRepository<Address, Long>{

    @RestResource(path = "findByCity")
    List<Address> findByCityStartingWith(@Param("city") String city);

}
