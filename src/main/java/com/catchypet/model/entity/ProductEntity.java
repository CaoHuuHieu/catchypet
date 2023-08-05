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
@Table(name="product")
@Data
public class ProductEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "NVARCHAR(500)")
	private String name;
	@Column
	private String image;
	@Column(columnDefinition = "NVARCHAR(MAX)")
	private String description;
	@Column(name="default_price")
	private Integer defaultPrice;
	@Column(name="sell_price")
	private Integer sellPrice;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String brand;
	@Column(name="create_date")
	private Date createDate;
	@Column(name="update_date")
	private Date updateDate;
	@Column
	private Integer status;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id", name="category_id")
	private CategoryEntity category;
	@Column
	private int quantity;
	@Column
	private int type;
}
