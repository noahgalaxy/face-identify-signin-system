package com.fisheep.domain;

public class User {
    private int userId;
    private String userNo;
    private String userPhone;
    private String userRealName;
    private String userNickName;
    private String userEmail;
    private int userDepartId;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userNo='" + userNo + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userDepartId=" + userDepartId +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserDepartId() {
        return userDepartId;
    }

    public void setUserDepartId(int userDepartId) {
        this.userDepartId = userDepartId;
    }
}
