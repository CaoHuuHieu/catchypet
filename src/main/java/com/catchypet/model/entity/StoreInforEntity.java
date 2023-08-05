package com.catchypet.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name="store_infor")
@Data
public class StoreInforEntity {
	@Id
	private Integer id;
	@Column
	private String phone;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String address;
	@Column
	private String email;
	@Column
	private String map;
}
