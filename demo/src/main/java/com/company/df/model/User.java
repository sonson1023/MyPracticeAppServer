package com.company.df.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String name;
    private String email;
    private String pwd;
    

    public static final int PASSWD_LEN = 8;

    
    public User( String name, String email, String pwd)
    {
    	super();
    	this.name = name;
    	this.email = email;
    	this.pwd = pwd;
    	boolean isValidPwd = is_Valid_Password(pwd);
    	
    }
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
    public static boolean is_Valid_Password(String password) {

        if (password.length() < PASSWD_LEN) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < password.length(); i++) {

            char ch = password.charAt(i);

            if (checkNum(ch)) numCount++;
            else if (checkLetter(ch)) charCount++;
            else return false;
        }


        return (charCount >= 2 && numCount >= 2);
    }

    public static boolean checkLetter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }


    public static boolean checkNum(char ch) {

        return (ch >= '0' && ch <= '9');
    }

	
}
