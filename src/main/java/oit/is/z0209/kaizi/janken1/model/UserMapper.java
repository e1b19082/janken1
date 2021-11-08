package oit.is.z0209.kaizi.janken1.model;

import java.util.ArrayList;

//import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT * FROM USERS")
  ArrayList<User> selectAllUsers();

  @Select("select * from users where name = #{name}")
  User selectByName(String name);
}
