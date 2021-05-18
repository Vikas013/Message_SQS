package com.demo.aws.sqs;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Messages")

public class Msg {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="msg_id")
    private int id;
	@Column(name="msg")
	private String message; 
	
	
    public int getId() {
	return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
		  

}
