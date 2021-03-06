package com.passwordManager.workshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Entity
@Table(name="passwords")
@Data
public class Credentials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_pass")
	private int idPass;
	@Column(name = "id_user")
	private int idUser;
	private String user;
	private String domain;
	private String password;


}
