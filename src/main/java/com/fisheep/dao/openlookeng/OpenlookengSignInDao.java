package com.fisheep.dao.openlookeng;

import com.fisheep.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OpenlookengSignInDao {

    User getUserFromOpenlookeng(@Param("basestring") String base64String);
}
