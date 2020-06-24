package com.cabservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "booking")
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(name = "username")
	private String user;
	
	@NotBlank
	@Column(name = "name")
	private String name;
	
	@NotBlank
	@Column(name = "pickup_location")
	private String pickUpLocation;
	
	@NotBlank
	@Column(name = "pickup_address")
	private String pickUpAddress;

	@NotBlank
	@Column(name = "drop_address")
	private String dropAddress;
	
	@NotBlank
	@Column(name = "created")
	@CreationTimestamp
	private Date created;
	
	@OneToOne
	@JoinColumn(name = "cab_id", referencedColumnName = "id")
	private Cab cab;
}
