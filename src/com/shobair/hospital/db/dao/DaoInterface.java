
package com.shobair.hospital.db.dao;

import java.util.List;

public interface DaoInterface <T> 
{
   public List<T>LoadAll() throws  Exception;
   public int insert(T t)  throws  Exception;
   public int update(T t)  throws  Exception;
   public int delete(T t)  throws  Exception;
   public T getData(T t)   throws  Exception;
}
