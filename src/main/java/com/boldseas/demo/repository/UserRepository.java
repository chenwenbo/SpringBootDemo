package com.boldseas.demo.repository;

import com.boldseas.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * description :
 * author : wenbo.chen@boldseas.com
 * Created time : 2017/07/06 14:41.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByUserNameLike(String userName);
}
