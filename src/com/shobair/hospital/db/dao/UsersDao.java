
package com.shobair.hospital.db.dao;
import com.shobair.hospital.db.vo.UsersVo;
import com.shobair.hospital.db.type.UsersType;
import java.sql.*;
import java.util.List;
public class UsersDao extends Dao implements DaoInterface<UsersVo>
{
   private static UsersDao userDao;

    private UsersDao() 
    {
    }
   public static UsersDao getInstance()
   {
       if(userDao==null)
       {
           userDao=new UsersDao();
       }
      return userDao;
       
   }

    @Override
    public List<UsersVo> LoadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(UsersVo uv) throws Exception
    {
    Connection con = null;
    int count = 0;
    try
    {
        con=getConnection();
        String sql="INSERT INTO USERS(USERNAME,PASSWORD,USER_TYPE,ID) VALUES (?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, uv.getUserName());
        ps.setString(2, uv.getPassword());
        ps.setInt(3, uv.getUserType().getId());
        ps.setInt(4, uv.getId());
        count = ps.executeUpdate();
        ps.close();
    }
    catch(Exception ex)
    {
        
    }
    finally
    {
        closeConnection(con);
    }
    return count;
    }

    @Override
    public int update(UsersVo uv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(UsersVo uv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsersVo getData(UsersVo uv) throws Exception 
    {
     Connection con=null;
     UsersVo userVo=null;
     ResultSet rs=null;
     try
     {
      con=getConnection();
      String sql="select * from USERS where USERNAME='"+uv.getUserName()+"'and PASSWORD='"+uv.getPassword()+"'";
      PreparedStatement ps=con.prepareCall(sql);
      rs=ps.executeQuery();
         while (rs.next()) 
         {
         userVo=new UsersVo();
         userVo.setId(rs.getInt("ID"));
         userVo.setUserName(rs.getString("USERNAME"));
         userVo.setPassword(rs.getString("PASSWORD"));
         UsersType userType=UsersType.getUserTypeById(rs.getInt("USER_TYPE"));
         userVo.setUserType(userType);
         }
         rs.close();
         ps.close();
     }
     catch(Exception ex)
     {
      
     }
     finally
     {
         closeConnection(con);
     }
     return userVo;
    }
}
