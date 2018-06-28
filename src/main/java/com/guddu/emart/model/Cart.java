package com.guddu.emart.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="cart")
public class Cart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2715362029975099768L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private int items;
	
}