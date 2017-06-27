package com.homework.controllers.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.homework.model.User;
import com.homework.services.UserSerivce;

@Controller
@RequestMapping("/admin")
public class UserRestController {
	private UserSerivce userService;
	@Autowired
	public UserRestController(UserSerivce userService) {
		this.userService=userService;
	}
	@RequestMapping({"/user","/user-list"})
	public String viewAll(ModelMap model){
		model.addAttribute("USERS",userService.viewAll());
		return "/admin/user-lists";
	}
	@RequestMapping({"/admin","","/home","/","/dashboard_user","/admin/dashboard_user"})
	public String homepage(ModelMap model){
		List<User> userlist = userService.viewAll();
		int totaluser= userlist.size();
		String male= userService.countGender("M");
		String female= userService.countGender("F");
		model.addAttribute("Male",male);
		model.addAttribute("Female",female);
		model.addAttribute("TOTAL",totaluser);
		model.addAttribute("Deactivate",userService.countDeactivate());
		return "/admin/dashboard_user";
	}
	@PostMapping({"/add","/user-add"})
	public String insert(@ModelAttribute("user") User user){
		System.out.println(user);
		String user_hash = UUID.randomUUID().toString();
		user.setUser_hash(user_hash);
		userService.insert(user);
		return "redirect:/admin/user-list";
	}
	@RequestMapping("/user/delete/{userhash}")
	public String delUser(@PathVariable("userhash") String userhash){
		userService.deleteByUserhash(userhash);
		return "redirect:/admin/user-list";
	}
	@RequestMapping("/user/update/{userhash}")
	public String updateUser(@PathVariable("userhash") String userhash,ModelMap model){
		model.addAttribute("USER",userService.findUserByhash(userhash));
		return "/admin/user-update";
	}
	//	update to db
	@PostMapping("/user/update/update-user")
	public String updateUserTodb(@ModelAttribute("user") User user){
		userService.updateByUserhash(user);
		return "redirect:/admin/user-list";
	}
	@RequestMapping("/user/detail/{userhash}")
	public String detailUser(@PathVariable("userhash") String userhash,ModelMap model){
		model.addAttribute("USER",userService.findUserByhash(userhash));
		return "/admin/user-detail";
	}
	@RequestMapping({"/user-list/gender/M","/user-list/gender/m"})
	public String filterGenderMale(ModelMap model){
		model.addAttribute("USERS",userService.viewAll());
		model.addAttribute("IDGEN", "M");
		return "/admin/user-lists_gender";
	}
	@RequestMapping({"/user-list/gender/F","/user-list/gender/f"})
	public String filterGenderFemale(ModelMap model){
		model.addAttribute("USERS",userService.viewAll());
		model.addAttribute("IDGEN", "F");
		return "/admin/user-lists_gender";
	}
	@RequestMapping({"/user-list/inactive","/user-list/not-active"})
	public String filterDeactivate(ModelMap model){
		model.addAttribute("USERS",userService.viewAll());
		return "/admin/user-lists_inactive";
	}
}
