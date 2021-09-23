package com.passwordManager.workshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="passwords")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
