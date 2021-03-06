package com.firstproject.filipe.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.firstproject.filipe.domain.Client;
import com.firstproject.filipe.services.validation.ClientUpdate;

@ClientUpdate
public class ClientDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message="Required")
	@Length(min=5, max=120, message="Size must be between 5 and 80 characters")
	private String name;
	@NotEmpty(message="Required")
	@Email(message="Invalid E-mail")
	private String email;
	
	public ClientDTO() {
		
	}
	
	public ClientDTO(Client client) {
		id = client.getId();
		name = client.getName();
		email = client.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
