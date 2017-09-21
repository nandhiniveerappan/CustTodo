package com.example.Todolist;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class DetailsJDO {
	 @PrimaryKey
	    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	    private Key key;
	 
	    @Persistent
		private String loggedEmail;

	    @Persistent
	    private String name;
	    
	    @Persistent
	    private String phone;

	    @Persistent
	    private String email;
	    
	    @Persistent
	    private String address;
	    
	    @Persistent
	    List<String> todoList= new ArrayList<String>();
	    
	   
	    public Key getKey() {
	        return key;
	    }	    
	    public void setKey(Key key) {
	        this.key = key;
	    }
	    public String getLoggedEmail(){
	    	return loggedEmail;
	    }
	    public void setLoggedEmail(String loggedEmail){
	    	this.loggedEmail=loggedEmail;	    	
	    }	   
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getPhone() {
	        return phone;
	    }
	    public void setPhone(String phone) {
	        this.phone = phone;
	    }
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    public String getAddress() {
	        return address;
	    }
	    public void setAddress(String address) {
	        this.address = address;
	    }
	    public List<String> getTodoList(){
	    	return todoList;	    	
	    }
	    public void setTodoList(List<String> todoList){
	    	this.todoList= todoList;
	    }

}


