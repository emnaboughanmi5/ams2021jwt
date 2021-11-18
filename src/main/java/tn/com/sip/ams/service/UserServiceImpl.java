package tn.com.sip.ams.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.com.sip.ams.entities.Role;
import tn.com.sip.ams.entities.User;
import tn.com.sip.ams.repositories.RoleRepository;
import tn.com.sip.ams.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User signUp(User user) {
		String password = user.getPassword();
    	user.setPassword(bCryptPasswordEncoder.encode(password));
    	user.setActive(1);
    	Role userRole = roleRepository.findByRole("user");
    	user.setRoles(new ArrayList<Role>(Arrays.asList(userRole)));
 	return userRepository.save(user);
	}

}
