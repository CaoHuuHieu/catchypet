package com.catchypet.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="category")
@Data
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name ="name", columnDefinition = "NVARCHAR(255)")
	private String name;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String description;
	@Column
	private Integer type;
	@Column
	private String fileName;
	@Column
	private Integer status;
	@OneToMany(mappedBy="category")
	private List<ProductEntity> products;
}
