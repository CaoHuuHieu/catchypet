package com.catchypet.model.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "contact")
@Data
public class ContactEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String name;
	@Column
	private String phone;
	@Column
	private String email;
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String content;
	@Column(name = "create_date")
	private Date createDate;
	@Column
	private Integer status;

}
