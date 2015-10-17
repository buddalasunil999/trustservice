package nz.ac.aut.sa.services.domain.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "buyer")
@XmlRootElement
public class Buyer extends PersonImpl {
	@ElementCollection(targetClass = Integer.class,fetch=FetchType.EAGER)
	@CollectionTable(name = "friends_inf", joinColumns = @JoinColumn(name = "person_id", nullable = false) )
	@MapKeyClass(Integer.class)
	@MapKeyColumn(name = "friend_id")
	@Column(name = "trust")
	private Map<Integer, Integer> friends = new HashMap<Integer, Integer>();//key is user id, value is trust

	@ElementCollection(targetClass = Double.class,fetch=FetchType.EAGER)
	@CollectionTable(name = "ratings_inf", joinColumns = @JoinColumn(name = "person_id", nullable = false,referencedColumnName="person_id") )
	@MapKeyClass(Integer.class)
	@MapKeyColumn(name = "product_id")
	@Column(name = "rating")
	private Map<Integer, Double> ratings = new HashMap<Integer, Double>();//key is product id, value is rating

	public Buyer() {
	}
	public Map<Integer, Integer> getFriends(){
		return this.friends;
	}
	
	public Collection<Integer> getFriendsId(){
		return this.friends.keySet();
	}
	
	public void setFriends(Map<Integer, Integer> friends){
		this.friends = friends;
	}
	public Map<Integer, Double> getRatings(){
		return this.ratings;
	}
	
	public void setRatings(Map<Integer, Double> ratings){
		this.ratings = ratings;
	}
	
	public void addFriendTrust(int friendId,int trust){
		friends.put(friendId, trust);
	}
	
	public int getFriendTrust(int friendId){
		return this.friends.get(friendId);
	}
	
	public void addProductRating(int productId,double rating){
		ratings.put(productId, rating);
	}
	
	public double getProductRating(int productId){
		return this.ratings.get(productId);
	}

}
