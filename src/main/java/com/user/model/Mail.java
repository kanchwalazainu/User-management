package com.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PCCWMAILLIST")


public class Mail {
	
	
	
	private int userid;
    private String mailsubject;
    private String mailbody;
    private String emailId;

    
    public Mail() {
  
    }
 
    public Mail(int userid,String mailsubject, String mailbody, String emailId) {
    	 this.userid=userid;
         this.mailsubject = mailsubject;
         this.mailbody = mailbody;
         this.emailId = emailId;
       
    }
 
    @Id
    @Column(name = "user_id", nullable = false)
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
    
    
    @Column(name = "emailid", nullable = false)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    
    @Column(name = "MAILSUBJECT", nullable = false)
   	public String getMailsubject() {
   		return mailsubject;
   	}

   	public void setMailsubject(String mailsubject) {
   		this.mailsubject = mailsubject;
   	}
   	
   	
   	@Column(name = "MAILBODY", nullable = false)
   	public String getMailbody() {
   		return mailbody;
   	}

   	public void setMailbody(String mailbody) {
   		this.mailbody = mailbody;
   	} 

    @Override
    public String toString() {
        return "Mail [id=" + userid + ", subject=" + mailsubject + ",  emailId=" + emailId
       + "]";
    }

   
}
