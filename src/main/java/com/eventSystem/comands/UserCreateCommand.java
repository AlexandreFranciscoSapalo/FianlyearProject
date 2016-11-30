package com.eventSystem.comands;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.eventSystem.domain.Role;

public class UserCreateCommand {

	@NotEmpty
	@Size(min = 3, max = 30)
    private String username = "";
	
    @NotEmpty
    private String email = "";

    @NotEmpty
    @Size(min = 5, max = 50)
    private String password = "";

    @NotEmpty
    @Size(min = 5, max = 50)
    private String passwordRepeated = "";

    @NotNull
    private Role role;
    
    @NotNull
    private String organization ="";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeated() {
		return passwordRepeated;
	}

	public void setPasswordRepeated(String passwordRepeated) {
		this.passwordRepeated = passwordRepeated;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}
    

}