
package com.shobair.hospital.db.dao;

import static com.shobair.hospital.db.dao.Dao.getConnection;
import com.shobair.hospital.db.vo.UserDetailsVo;
import com.shobair.hospital.db.vo.UsersVo;
import com.shobair.hospital.view.UsersView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;

public class UserDetailsDao extends Dao implements DaoInterface<UserDetailsVo>
{
private static UserDetailsDao userDatailDao;

    private UserDetailsDao() 
    {
    }
   public static UserDetailsDao getInstance()
   {
       if(userDatailDao==null)
       {
           userDatailDao=new UserDetailsDao();
       }
      return userDatailDao;
       
   }
    @Override
    public List<UserDetailsVo> LoadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(UserDetailsVo udv) throws Exception 
    {
        Connection con = null;
        PreparedStatement ps = null;
    int count=0;
    try
    {
        con=getConnection();
        con.setAutoCommit(false);
        
        String userSql="INSERT INTO USERS(USERNAME,PASSWORD,USER_TYPE,ID) VALUES (?,?,?,?)";
        ps=con.prepareStatement(userSql);
        ps.setString(1, udv.getUserVo().getUserName());
        ps.setString(2, udv.getUserVo().getPassword());
        ps.setInt(3, udv.getUserVo().getUserType().getId());
        ps.setInt(4,  udv.getUserVo().getId());
        ps.executeUpdate();
        
        
        
        
        
        
        
        String UserDetailSql="INSERT INTO USERS_DETAILS(USER_ID,FIRST_NAME,FATHER_NAME,MOBILE,IMAGE) VALUES(?,?,?,?,?)";
        ps=con.prepareStatement(UserDetailSql);
        ps.setInt(1, udv.getUserVo().getId());
        ps.setString(2, udv.getFirstName());
        ps.setString(3, udv.getFatherName());
        ps.setString(4, udv.getMobile());
        ps.setBytes(5,UsersView.imageByte);
        count = ps.executeUpdate();
        con.commit();
        count = 1 ;
       
    }
    catch(Exception ex)
    {
        con.rollback();
    }
    finally
    {
         ps.close();
        closeConnection(con);
    }
    return count;
    }
   

    @Override
    public int update(UserDetailsVo udv) throws Exception
    {
              Connection con = null;
        PreparedStatement ps = null;
    int count=0;
    try
    {
        con=getConnection();
        con.setAutoCommit(false);
        
        String userSql="UPDATE USERS SET USERNAME=?,PASSWORD=?,USER_TYPE=? WHERE ID=?";
        ps=con.prepareStatement(userSql);
        ps.setString(1, udv.getUserVo().getUserName());
        ps.setString(2, udv.getUserVo().getPassword());
        ps.setInt(3, udv.getUserVo().getUserType().getId());
        ps.setInt(4,  udv.getUserVo().getId());
        ps.executeUpdate();
        
        
        
        
        
        
        
        String UserDetailSql="UPDATE USERS_DETAILS SET FIRST_NAME=?,FATHER_NAME=?,MOBILE=?,IMAGE=? WHERE USER_ID=?";
        ps=con.prepareStatement(UserDetailSql);
        ps.setString(1, udv.getFirstName());
        ps.setString(2, udv.getFatherName());
        ps.setString(3, udv.getMobile());
        ps.setBytes(4,UsersView.imageByte);
        ps.setInt(5,udv.getUserVo().getId());
      
        count = ps.executeUpdate();
        con.commit();
        count = 1 ;
       
    }
    catch(Exception ex)
    {
        con.rollback();
    }
    finally
    {
         ps.close();
        closeConnection(con);
    }
    return count;
    }

    @Override
    public int delete(UserDetailsVo udv) throws Exception 
    {
     Connection con = null;
     PreparedStatement ps = null;
     int count=0;
    try
    {
        con=getConnection();
        con.setAutoCommit(false);
        
        String userDetailSql="DELETE FROM USERS_DETAILS WHERE USER_ID=?";
        ps=con.prepareStatement(userDetailSql);
        ps.setInt(1, udv.getUserVo().getId());
        ps.executeUpdate();
        
                
        String userSql="DELETE FROM USERS WHERE ID=?";
        ps=con.prepareStatement(userSql);
        ps.setInt(1, udv.getUserVo().getId());
        ps.executeUpdate();
        
                
        con.commit();
        count = 1 ;
       
    }
    catch(Exception ex)
    {
        JOptionPane.showMessageDialog(null, ex.getMessage()+"");
        con.rollback();
    }
    finally
    {
         ps.close();
        closeConnection(con);
    }
    return count;
    }
      
    

    @Override
    public UserDetailsVo getData(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
