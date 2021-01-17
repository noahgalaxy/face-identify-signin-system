package com.fisheep.dao;

import com.fisheep.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    String getUserRealName(@Param("userNo") String userNo);

    List<String> getAllUserNames();

    User getUser(@Param("faceImgPath") String faceImgPath);
}
