package com.catchypet.model.entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "full_name", columnDefinition = "NVARCHAR(255)")
	private String fullName;
	@Column()
	private String phone;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String address;
	@Column(name = "province_id")
	private String provinceId;
	@Column(name = "district_id")
	private String districtId;
	@Column(name = "ward_id")
	private String wardId;
	@Column(name = "full_address",columnDefinition = "NVARCHAR(255)")
	private String fullAddress;
	@Column(name = "create_date")
	@CreationTimestamp
	private Date createDate;
	@ManyToOne
    @JoinColumn(name = "user_id")
	private UserEntity user;
}