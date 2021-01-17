package com.fisheep.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SignInDao {
    void insertFaceImageToAllFaceImageFileTable(@Param("filePath") String filePath);
}
