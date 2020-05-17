
package com.shobair.hospital.db.type;

public enum UsersType 
{
    ADMIN(1,"admin"),DOCTOR(2,"doctor"),NURSE(3,"nurse");
    private int id;
    private String type;

    private UsersType(int id, String type) 
    {
        this.id = id;
        this.type = type;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getType() 
    {
        return type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }
    public static UsersType getUserTypeById(int id)
    {
        for(UsersType usersType:UsersType.values())
        {
            if(usersType.getId()==id)
            {
                return usersType;
            }
           
        }
         return null;
    }
    
     public static UsersType getUserTypeByType(String Type)
    {
        for(UsersType usersType:UsersType.values())
        {
            if(usersType.getType()==Type)
            {
                return usersType;
            }
           
        }
         return null;
    }
}
