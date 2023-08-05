package com.catchypet.model.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="orders")
@Data
public class OrderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
	@Column(name="full_name", columnDefinition = "NVARCHAR(255)")
	private String fullName;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String address;
	@Column
	private String phone;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String note;
	@Column
	private String payment;
	@Column(name="transport_fee")
	private Integer transportFee;
	@Column(name="create_date")
	private Date createDate;
	@Column(name="total_money")
	private Integer totalMoney;
	@Column
	private Integer status;
	@OneToMany(mappedBy="order")
	private List<OrderDetailEntity> orderDetails;
} 

