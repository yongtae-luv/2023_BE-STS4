package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.model.UserProfile;

@Mapper
public interface UserProfileMapper {
	
	@Select("select * from user_profile WHERE id = #{id}")
	UserProfile getUserProfile(@Param("id") String id);
	
	@Select("SELECT * FROM user_profile")
	List<UserProfile> getUserProfileList();
	
	@Insert("INSERT INTO user_profile VALUE(#{id},#{name},#{phone},#{address})")
	int InsertUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);
	
	@Update("UPDAE user_profile set name=#{name},phone=#{phone},address=#{address} WHERE id=#{id}")
	int UpdateUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);
	
	@Delete("DELETE user_profile WHERE id=#{id}")
	int deleteUserProflie(@Param("id") String id);
}
