package com.fisheep.dao;

import com.fisheep.config.ChooseDataSource;
import com.fisheep.constant.DataSourceConstants;
import com.fisheep.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SignInDao {

//    @ChooseDataSource(DataSourceConstants.DEFAULT_DATA_SOURCE)
    void insertFaceImageToAllFaceImageFileTable(@Param("filePath") String filePath);

}
