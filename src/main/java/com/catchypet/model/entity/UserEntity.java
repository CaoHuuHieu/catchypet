package com.catchypet.model.entity;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="full_name", columnDefinition = "NVARCHAR(255)" )
	private String fullName;
	@Column( unique = true)
	private String username;
	@Column
	private String password;
	@Column(name="create_date")
	private Date createDate;
	@Column
	private String role;
	@Column
	private Integer status;
	@OneToMany(mappedBy="user")
	private List<OrderEntity> orderList;
	@OneToMany(mappedBy="user")
	private List<AddressEntity> addressList;
}
