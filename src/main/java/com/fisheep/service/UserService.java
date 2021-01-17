package com.fisheep.service;

import com.fisheep.config.ChooseDataSource;
import com.fisheep.constant.DataSourceConstants;
import com.fisheep.dao.UserDao;
import com.fisheep.domain.User;
import com.fisheep.exception.NoUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @ChooseDataSource(DataSourceConstants.OPENLOOKEENG_DATA_SOURCE)
    public String getUserId(String faceImgBase64String){
        System.out.println("userService has finished convertion of face image of base64 format to user id");
        String userNo = "38509876";
        return userDao.getUserRealName(userNo);
    }

    @ChooseDataSource(DataSourceConstants.DEFAULT_DATA_SOURCE)
    public List<String> getAllUserNames() {
        List<String> allUserNames = userDao.getAllUserNames();
        System.out.println("service 查询到了getAllUserNames结果： "+allUserNames);
        return allUserNames;
    }

    @ChooseDataSource(DataSourceConstants.OPENLOOKEENG_DATA_SOURCE)
    public User getUser(String faceImgPath) {
        User user = userDao.getUser(faceImgPath);
        if(user == null){
            throw new NoUserException();
        }
        return user;
    }

    public String getUserId1(String faceImgBase64String){
        String openlookengConnectionUrl = "jdbc:lk://localhost:8090";

        System.out.println("userService has finished convertion of face image of base64 format to user id");
        String userId = "784487653";
//        int userId = 3;
        ResultSet resultSet = null;
        Connection connection = null;
        String user_real_name = "";
        try {
            Class.forName("io.hetu.core.jdbc.OpenLooKengDriver");
            connection = DriverManager.getConnection(openlookengConnectionUrl,"root", null);
            Statement statement = connection.createStatement();
            String query = String.format("select user_real_name from mysql.openlookeng.user_info where user_no='%s' limit 1", userId);
            System.out.println("执行的语句：\n" + query);
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                user_real_name = resultSet.getString("user_real_name");
                System.out.println("查询到的：" + user_real_name);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(resultSet != null){
                    resultSet.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return user_real_name;
    }


}
