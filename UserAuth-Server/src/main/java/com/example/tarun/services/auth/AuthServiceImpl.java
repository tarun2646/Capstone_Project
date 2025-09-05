package com.example.tarun.services.auth;

import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tarun.dto.SignupRequest;
import com.example.tarun.dto.UserDto;
import com.example.tarun.entities.User;
import com.example.tarun.enums.UserRole;
import com.example.tarun.repositories.UserRepository;

import jakarta.annotation.PostConstruct;
//import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@Service	
@AllArgsConstructor
//@Transactional   // applies to all public methods in this class
public class AuthServiceImpl implements AuthService 
{
	
	
	private final UserRepository userRepository;
	

	
	//@Transactional
	@PostConstruct
	public void createAdminAccount() {
	    Optional<User> optinalUser = userRepository.findByUserRole(UserRole.ADMIN);
	    if (optinalUser.isEmpty()) {
	        User user = new User();
	        user.setEmail("admin@test.com");
	        user.setName("admin");
	        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
	        user.setUserRole(UserRole.ADMIN);
	        userRepository.save(user);
	       // ? this save database

	        // Simulated failure------->is just an intentional exception we added to test rollback behavior
	       if (true) throw new RuntimeException("Oops! Something went wrong");

	        
	    }
	}


	@Override
	@Transactional(rollbackFor = Exception.class)
	//No matter what kind of exception happens — checked OR unchecked — roll back the transaction!
	public UserDto signupUser(SignupRequest signupRequest) {
	    if (userRepository.findFirstByEmail(signupRequest.getEmail()).isPresent()) {
	        throw new IllegalStateException("Email already exists");
	    }

	    User user = new User();
	    user.setEmail(signupRequest.getEmail());
	    user.setName(signupRequest.getName());
	    user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
	    user.setUserRole(UserRole.USER);

	    userRepository.save(user);
	
	    return user.getUserDto();
	}

	
	@Transactional(readOnly = true)//I will only fetch data, not modify it.
	@Override
	public boolean hasUserWithEmail(String email) {
		return userRepository.findFirstByEmail(email).isPresent();
	}
	
	




	

	    	
}
