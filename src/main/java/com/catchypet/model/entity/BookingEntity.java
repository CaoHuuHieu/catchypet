package com.catchypet.model.entity;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
@Entity
@Table(name="booking")
@Data
public class BookingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String name;
	@Column
	private String phone;
	@Column
	private String email;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String subject;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String content;
	@Column(name = "create_date")
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date createDate;
	@Column
	private Integer status;
}
