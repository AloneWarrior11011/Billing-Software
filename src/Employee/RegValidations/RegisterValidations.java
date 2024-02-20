
package RegValidations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterValidations
{
    // This is the Regex part which means regular expression.
    private Pattern name,email,password,phone_no;
    private Matcher matcher;
    
    String name_pattern = "^[a-zA-Z ]{3,30}$";
    String email_pattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    String password_pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
    String phone_no_pattern ="^[0-9]{10}";
    
   public RegisterValidations()
    {
        name = Pattern.compile(name_pattern);
        email = Pattern.compile(email_pattern);
        password  = Pattern.compile(password_pattern);
        phone_no = Pattern.compile(phone_no_pattern);
    }
    
    public boolean nameValidation(String user_name)      // we can pass any argument into this method related to specified.
    {
        matcher =  name.matcher(user_name);
        return matcher.matches();
    }
    
     public boolean emailValidation(String user_email)      // we can pass any argument into this method related to specified.
    {
        matcher =  email.matcher(user_email);
        return matcher.matches();
    }
     
      public boolean passwordValidation(String user_password)      // we can pass any argument into this method related to specified.
    {
        matcher =  password.matcher(user_password);
        return matcher.matches();
    }
      
       public boolean phone_noValidation(String user_phone_no)      // we can pass any argument into this method related to specified.
    {
        matcher =  phone_no.matcher(user_phone_no);
        return matcher.matches();
    }
      
}
