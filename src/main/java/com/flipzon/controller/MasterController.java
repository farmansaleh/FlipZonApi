package com.flipzon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipzon.dto.ApiResponse;
import com.flipzon.entity.Role;
import com.flipzon.service.MasterService;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author Aswani Kadapana
 * @since 07/02/2024
 *
 */

@RestController
@RequestMapping("/master")
@PreAuthorize("hasRole('ADMIN') OR hasRole('RETAILER')")
public class MasterController {
	
	@Autowired MasterService masterService;
	
	//Start :: Aswani - 05-02-2024
	
	//Role Master
	
	@PostMapping("/createRole")
	public ApiResponse<Role> createRole(@RequestBody Role role,HttpServletRequest req) throws Exception {
		role.setCreatedBy(req.getAttribute("userId").toString());
		return masterService.createRole(role);
	}
	
	@GetMapping("/getAllRoles")
	public List<Role> getAllRoles() throws Exception {
		return masterService.getAllRoles();
	}
	
	@GetMapping("/getRoleById/{id}")
	public Role getRoleById(@PathVariable long id) throws Exception {
		return masterService.getRoleById(id);
	}
	
	@PutMapping("/updateRole/{id}")
	public ApiResponse<Role> updateRole(@PathVariable long id, @RequestBody Role role, HttpServletRequest req) throws Exception {
		role.setId(id);
		role.setCreatedBy(req.getAttribute("userId").toString());
		return masterService.updateRole(role);
	}
	
	@PostMapping("/deActiveRole/{id}")
	public ApiResponse<?> deActiveRole(@PathVariable long id, @RequestBody Role role, HttpServletRequest req) throws Exception {
		role.setId(id);
		role.setCreatedBy(req.getAttribute("userId").toString());
		return masterService.deActiveRole(role);
	}
	
	//Mapping User Role
//	@PostMapping("/assignUserRole")
//	public ApiResponse<MpgUserRole> assignUserRole(@RequestBody MpgUserRole mpgUserRole, HttpServletRequest req) throws Exception {
//		mpgUserRole.setCreatedBy(req.getAttribute("userId").toString());
//		return masterService.assignUserRole(mpgUserRole);
//	}
//	
//	@GetMapping("/getAssignedUserRoleById/{roleId}")
//	public List<MpgUserRole> getAssignedUserRoleById(@PathVariable String roleId) throws Exception {
//		return masterService.getAssignedUserRoleById(roleId);
//	}
	
	//End :: Aswani
	
}