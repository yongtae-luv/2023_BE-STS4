package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import java.util.HashMap;
import java.util.List;
//import java.util.ArrayList;

import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.model.UserProfile;

//import javax.annotation.PostConstruct;

@RestController
public class UserProfileController {
	
	private UserProfileMapper mapper;
	
	private Map<String, UserProfile> userMap;
	
	public UserProfileController(UserProfileMapper mapper) {
		this.mapper = mapper;
	}

	//@PostConstruct
	//public void init() {
		//userMap = new HashMap<String, UserProfile>();
		//userMap.put("1", new UserProfile("1", "홍길동1", "111-1111", "서울시 강동구 대치1동"));
		//userMap.put("2", new UserProfile("2", "홍길동2", "111-1112", "서울시 강동구 대치2동"));
		//userMap.put("3", new UserProfile("3", "홍길동3", "111-1113", "서울시 강동구 대치3동"));
	//}

	@GetMapping("/user/{id}")
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		//return userMap.get(id);
		return mapper.getUserProfile(id);		
	}
	
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList() {
		//return new ArrayList<UserProfile>(userMap.values());
		return mapper.getUserProfileList();
	}
	
	@PutMapping("/user/{id}")
	public void putUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		//UserProfile userProfile = new UserProfile(id, name, phone, address);
		//userMap.put(id, userProfile);
		mapper.InsertUserProfile(id, name, phone, address);
	}
	
	@PostMapping("/user/{id}")
	public void postUserProfile(@PathVariable("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address) {
		//UserProfile userProfile = userMap.get(id);
		//userProfile.setName(name);
		//userProfile.setPhone(phone);
		//userProfile.setAddress(address);
		mapper.UpdateUserProfile(id, name, phone, address);
	}

	@DeleteMapping("user/{id}")
	public void deleteUserProflie(@PathVariable("id") String id) {
		//userMap.remove(id);
		mapper.deleteUserProflie(id);
	}
}
