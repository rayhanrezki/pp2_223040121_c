/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 *
 * @author ASUS
 */
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> getAllUsers();

    @Insert("INSERT INTO users (name, email, npm, alamat) VALUES (#{name}, #{email}, #{npm}, #{alamat})")
    void insertUser(User user);

    @Update("UPDATE users SET name=#{name}, email=#{email}, npm=#{npm}, alamat=#{alamat} WHERE id=#{id}")
    void updateUser(User user);

    @Delete("DELETE FROM users WHERE id = #{userId}")
    public void deleteUser(int userId);

    
}