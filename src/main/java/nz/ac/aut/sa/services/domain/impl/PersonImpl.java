package nz.ac.aut.sa.services.domain.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import nz.ac.aut.sa.services.domain.Person;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="person")
public abstract class PersonImpl implements Person{
	@Id @Column(name="person_id") @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="person_name")
	private String name;
	
	@Column(name="Person_password")
	private String password;
	
	public PersonImpl(){
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	@XmlTransient
	public String getPassword(){
		return this.password;
	}

	@Override
	public String toString() {
		return this .name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this){
			return true;
		}
		PersonImpl p = (PersonImpl) obj;
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
