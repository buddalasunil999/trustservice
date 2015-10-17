package nz.ac.aut.sa.services.domain.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import nz.ac.aut.sa.services.domain.Product;


@Entity
@Table(name="product")
public class ProductImpl implements Product{
	@Id @Column(name="product_id") @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="product_name")
	private String name;
	
	@Column(name="product_tran")
	private int numTransactions;
	
	@Column(name="product_rating")
	private double rating;
	
	public ProductImpl(){
		numTransactions = 0;
		rating = 0;
	}
	
	public void setNumTransactions(int numTransactions){
		this.numTransactions = numTransactions;
	}
	
	public int getNumTransactions(){
		return this.numTransactions;
	}
	
//	public void setRating(double rating){
//		this.rating = rating;
//	}
	
	public void addaRating(double rating){
		double currentTotal = this.rating * (double)numTransactions;
		numTransactions++;
		this.rating = BigDecimal.valueOf((currentTotal+rating)/numTransactions).setScale(3,RoundingMode.HALF_UP).doubleValue();
	}
	
	public double getRating(){
		return this.rating;
	}
	
//	public void increaseNumTransaction(){
//		this.numTransactions++;
//	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true;
		}
		ProductImpl p = (ProductImpl) obj;
		if(p.getName().equals(this.getName())){
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}

}
