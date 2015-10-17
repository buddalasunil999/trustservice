package nz.ac.aut.sa.services.domain.impl;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "seller")
@NamedQueries({@NamedQuery(name="getAllSeller",query="from Seller"),
	@NamedQuery(name="getASeller",query="from Seller where id = ?0")})
public class Seller extends PersonImpl {
	@Column(name = "num_tran")
	private int numTransactions;
	@Column(name = "num_ano")
	private int numAnomalous;
	@ElementCollection(targetClass=Integer.class,fetch=FetchType.EAGER)
	@CollectionTable(name="seller_product_inf",joinColumns=@JoinColumn(name="person_id",nullable=false))
	@Column(name="product_id")
	private Set<Integer> products = new HashSet<Integer>();

	public Seller() {
		super();
		numTransactions = 0;
		numAnomalous = 0;
	}

	public void addProduct(Integer product) {
		this.products.add(product);
	}

	public void setProducts(Set<Integer> products) {
		this.products = products;
	}

	public Set<Integer> getProducts() {
		return this.products;
	}

	public void increaseNumTransaction() {
		this.numTransactions++;
	}

	public void increaseNumAnomalous() {
		this.numAnomalous++;
	}

	public int getNumTransactions() {
		return numTransactions;
	}

	public void setNumTransactions(int numTransactions) {
		this.numTransactions = numTransactions;
	}

	public int getNumAnomalousTransactions() {
		return numAnomalous;
	}

	public void setNumAnomalousTransactions(int numAnomalous) {
		this.numAnomalous = numAnomalous;
	}


	@Override
	public String toString() {
		return this.getName();
	}
}
