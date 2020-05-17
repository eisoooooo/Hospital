package com.shobair.hospital.db.vo;
 import com.shobair.hospital.db.type.UsersType;

public class UsersVo 
{
private int id;
private String  userName;
private String  password;
private UsersType userType;
    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public UsersType getUserType() 
    {
        return userType;
    }

    public void setUserType(UsersType userType) 
    {
        this.userType = userType;
    }

}
