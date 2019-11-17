package com.wxs.mapper;

import com.wxs.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User findUserInfo(@Param("id") int id);
}
