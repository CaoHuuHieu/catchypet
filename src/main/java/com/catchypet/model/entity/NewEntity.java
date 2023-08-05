package com.catchypet.model.entity;

import java.sql.Date;

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
@Table(name="new")
@Data
public class NewEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column( columnDefinition = "NVARCHAR(MAX)")
	private String heading;
	@Column(name="short_description", columnDefinition = "NVARCHAR(MAX)")
	private String shortDescription;
	@Column
	private String image;
	@Column(name="create_date")
	private Date createDate;
	@Column
	private Integer status;
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String content;

}
