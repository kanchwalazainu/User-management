package com.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "PCCWUSER")
@Where(clause="deleted_flag='false'")
//@SQLDelete(sql="Update users SET deletedFlag = 'true' where userid=?")
public class User {
	
	
	
	private int userid;
    private String firstName;
    private String lastName;
    private String emailId;
    private boolean	deleted_flag;
    
    public User() {
  
    }
 
    public User(String firstName, String lastName, String emailId) {
         this.firstName = firstName;
         this.lastName = lastName;
         this.emailId = emailId;
         this.deleted_flag=false;
    }
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
    
 
    @Column(name = "user_firstname", nullable = false)
    @NotNull(message = "First name must not be empty")
    @Size(min=2, message="First name should have atleast 2 characters")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    @Column(name = "user_lastname", nullable = false)
    @NotNull(message = "Last name must not be empty")
   
    @Size(min=2, message="Last name should have atleast 2 characters")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    @Column(name = "emailid", nullable = false)
    @NotNull(message = "Email must not be empty")
    @Email(message = "Email must be a valid email address")
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    @Column(name = "deleted_flag")
   	public boolean isDeletedFlag() {
   		return deleted_flag;
   	}
   	public void setDeletedFlag(boolean deletedFlag) {
   		this.deleted_flag = deletedFlag;
   	}

    @Override
    public String toString() {
        return "User [id=" + userid + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
       + "]";
    }
	
	
	
	
	
	
   
	
	
	
	

}
