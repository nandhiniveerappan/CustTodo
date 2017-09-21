package com.example.Todolist;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class CustJDO {
	 @PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private Key key;

	    @Persistent
	    private String fName;
	    
	    @Persistent
	    private String lName;

	    @Persistent
	    private String email;
	    
	    @Persistent
	    private String pwd;
	   
	    public Key getKey() {
	        return key;
	    }
	    public void setKey(Key key) {
	        this.key = key;
	    }
	    
	    public String getFname() {
	        return fName;
	    }
	    public void setFname(String fName) {
	        this.fName = fName;
	    }
	    public String getLname() {
	        return lName;
	    }
	    public void setLname(String lName) {
	        this.lName = lName;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public String getPwd() {
	        return pwd;
	    }
	    public void setPwd(String pwd) {
	        this.pwd = pwd;
	    }
}
