package tn.com.sip.ams.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.com.sip.ams.entities.Provider;
import tn.com.sip.ams.entities.Role;
import tn.com.sip.ams.repositories.RoleRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/role")
public class RoleController {
	
	private final RoleRepository roleRepository;
	
	@Autowired
    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
	
	@GetMapping("/list")
	public List<Role> getAllRoles() {
		return (List<Role>) roleRepository.findAll();
	}
    
    @GetMapping("add")
    public String showAddRoleForm() {

         return "role/addRole";
    }
    
    
    @PostMapping("/add")
	public Role createRole(@Valid @RequestBody Role role) {
		return roleRepository.save(role);
	}
    
    

}
