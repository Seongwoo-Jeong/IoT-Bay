package uts.isd.model;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @Author Jeongseongwoo
 */

public class User implements Serializable 
{
    private int id;
    private String name;
    private String mobileNumber;
    private String email;
    private String homeAddress;
    private boolean register;

    public User(int id, String name, String mobileNumber, String email, String homeAddress, boolean register) 
    {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.homeAddress = homeAddress;
        this.register = true;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getmobileNumber() 
    {
        return mobileNumber;
    }

    public void setmobileNumber(String mobileNumber) 
    {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getHomeAddress() 
    {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) 
    {
        this.homeAddress = homeAddress;
    }

    public boolean isRegister() 
    {
        return register;
    }

    public void setRegister(boolean register)
    {
        this.register = register;
    }

    
}