package com.hcl.taskmanager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Task {

	@Id
	@GeneratedValue
	long id;
	
	
	String taskName;
	String category;
	double price;
	
	
}
