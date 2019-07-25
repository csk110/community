package com.example.community.mapper;

import com.example.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author ChenSK
 * @date 2019-07-25 - 17:21
 */
@Mapper
@Component
public interface UserMapper {
    @Select("select * from user where account_id=#{account_id}")
    User getUserByAccountId(String account_id);

    @Insert("insert into user(account_id) values(#{accountId})")
    int addUser(String accountId);
}
