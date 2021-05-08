package uts.isd.model;
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @Author Jeongseongwoo
 */

public class UserAccount implements Serializable 
{
    private int userAccountID;
    private String email;
    private String password;
    private String dob;
    private boolean newsletter;

    public UserAccount(int userAccountID, String email, String password, String dob, boolean newsletter) 
    {
        this.userAccountID = userAccountID;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.newsletter = newsletter;
    }

    public int getUserAccountID() 
    {
        return userAccountID;
    }

    public void setUserAccountID(int userAccountID)
    {
        this.userAccountID = userAccountID;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getDob() 
    {
        return dob;
    }

    public void setDob(String dob) 
    {
        this.dob = dob;
    }

    public boolean isNewsletter() 
    {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) 
    {
        this.newsletter = newsletter;
    }
        

}
