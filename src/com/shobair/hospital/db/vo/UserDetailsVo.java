
package com.shobair.hospital.db.vo;


public class UserDetailsVo
{
private int id;
private UsersVo userVo;
private String firstName;
private String fatherName;
private String mobile;

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public UsersVo getUserVo() 
    {
        return userVo;
    }

    public void setUserVo(UsersVo userVo)
    {
        this.userVo = userVo;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName) 
    {
        this.firstName = firstName;
    }

    public String getFatherName() 
    {
        return fatherName;
    }

    public void setFatherName(String fatherName)
    {
        this.fatherName = fatherName;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }


}
