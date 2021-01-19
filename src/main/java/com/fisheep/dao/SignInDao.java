package com.fisheep.dao;

import com.fisheep.config.ChooseDataSource;
import com.fisheep.constant.DataSourceConstants;
import com.fisheep.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Mapper
public interface SignInDao {

    void insertFaceImageToAllFaceImageFileTable(@Param("filePath") String filePath);

    User getUserFromOpenlookeng(@Param("basestring") String base64String);

    int saveUserSignRecord(@Param("filePath") String filePath, User user);
}
