
package gettersetter;


public class RegisterModelEncapsulation 
{
    //  --------------------------------these are the steps which we required to achiever encapsulation-----------------------
    private String name;
    private String email;
    private String password;
    private String gender;
    private String phone_no;
    private String module;
    
    public RegisterModelEncapsulation() {}      // constructor having no arguments
    
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
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
    
     public String getGender()
    {
        return gender;
    }
    public void setGender(String gender)
    {
        this.gender = gender;
    }
    
     public String getPhoneNo()
    {
        return phone_no;
    }
    public void setPhoneNo(String phone_no)
    {
        this.phone_no = phone_no;
    }
    
     public String getModule()
    {
        return module;
    }
    public void setModule(String module)
    {
        this.module = module;
    }
    
    // by using getter and setter and setter method we easily achieve encapsulatio and  getting security.
}
