
package DataBaseCon;

import gettersetter.RegisterModelEncapsulation;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author HP
 */
public class DataBaseOperations 
{
    
    static public ResultSet Login(String email1,String password1)
     {
         ResultSet rs = null;
           try
        {
                Connection con = DbConnection.getConnection();
                PreparedStatement ps = con.prepareStatement("select * from software where email=? and password=?");

                 ps.setString(1,email1);
                 ps.setString(2,password1);

                 rs = ps.executeQuery();
       }
     
      catch(Exception e)
       {
                   System.out.println(e);
        }
       return rs;
     }
      
    public static boolean software(RegisterModelEncapsulation reg)
      {
          boolean status = false;
           try
        {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into software values(?, ?, ?, ?, ?, ?)");
            
            //----------------get the values which we have got from the textfield  and insert into the billing_software database.
              ps.setString(1, reg.getName());
              ps.setString(2, reg.getEmail());
              ps.setString(3, reg.getPassword());
              ps.setString(4, reg.getGender());
              ps.setString(5, reg.getPhoneNo());
              ps.setString(6, reg.getModule()); 
              
              int i = ps.executeUpdate();
              
              if(i > 0)
              {
                  status = true;
                /*  JOptionPane.showMessageDialog(rootPane, "Employee Register Successfully...!!!");
                  EnterName.setText("");
                  EmailId.setText("");
                  Password.setText("");
                  buttonGroup3.clearSelection();
                  PhoneNo.setText("");  */
              }
              else
              {
                  status = false;
                  // JOptionPane.showMessageDialog(rootPane, "Invalid Credentials...!!!", "Please Enter Valid Information...!!1", JOptionPane.ERROR_MESSAGE);
              }
              ps.close();
              con.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return status;
          
      }
   
    // this database operation getting the employee name and email . and display on the jTable Frame.
     public static ResultSet showEmployeeDetails( )
     {
         ResultSet rs = null;
         try
         {
                     Connection con = DbConnection.getConnection();
                     PreparedStatement ps = con.prepareStatement("select * from software where module='Employee' ");
                     
                     
                     rs = ps.executeQuery();
   
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         return rs;
     }
     public static ResultSet getSelectedEmployee(String email)
     {
         ResultSet rs = null;
         try
         {
                    Connection con = DbConnection.getConnection();
                     PreparedStatement ps = con.prepareStatement("select * from software where email=? ");
                     ps.setString(1, email);
                     
                     rs =  ps.executeQuery();
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         return rs;
     }
     
     public static int UpdateEmpDetails(RegisterModelEncapsulation rme)
     {
         int i = 0;
          try
          {
              Connection con = DbConnection.getConnection();
              PreparedStatement ps = con.prepareStatement("update software set name=?, password=?, gender=?, phoneNo=? where email=? ");
              ps.setString(1, rme.getName());
              ps.setString(2,rme.getPassword());
              ps.setString(3,rme.getGender());
              ps.setString(4, rme.getPhoneNo());
              ps.setString(5, rme.getEmail());
              
              i =  ps.executeUpdate();
                      
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
          return i;
     }
     public static int deleteEmpDetails(String email)
     {
         int i=0;
         try
         {
                 Connection con = DbConnection.getConnection();
                 PreparedStatement ps =  con.prepareStatement("delete from software where email = ?");
                 ps.setString(1, email);
                 
                i =  ps.executeUpdate();
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         return i;
     }
     public static boolean insertImageDetails(FileInputStream fis,String... str)
     {
         
         boolean status = false;
         try
         {
             
           Connection con =DbConnection.getConnection();
           PreparedStatement ps = con.prepareStatement("insert into items values(?,?,?,?,?,?)");
           ps.setString(1,str[0]);
           ps.setString(2, str[1]);
           ps.setString(3,str[2]);
           ps.setString(4, str[3]);
           ps.setString(5,str[4]);
           ps.setBinaryStream(6, fis);
           
          int i =   ps.executeUpdate();
           
           if(i > 0)
           {
               status = true;
           }
           else
           {
               status =false;
           }
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         return status;
     }
     //----------------------------------View Edit Items---------------------------------------
     public static ResultSet getAllItem()
     {
         ResultSet rs = null;
         try
         {
             Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from items");
            rs = ps.executeQuery();
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         return rs;
     }           
                 //---------------Show items details on that perticular textfields----------
     public static ResultSet getItemsDetails(String item_id)
     {
         ResultSet rs = null;
         try
         {
             Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from items where item_id=?");
             ps.setString(1,item_id);
             
            rs = ps.executeQuery();
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         return rs;
     }
     public static boolean deleteItem(String item_id)
     {
         boolean status = false;
         try
         {
                  Connection con = DbConnection.getConnection();
                 PreparedStatement  ps = con.prepareStatement("delete from items where item_id=?");
                 ps.setString(1, item_id);
                 
                 int i = ps.executeUpdate();
                         
                 if(i > 0)
                 {
                     status = true;
                 }
                 else
                 {
                     status = false;
                 }
         }
         catch(Exception e )
         {
             System.out.println(e);
         }
         return status;
     }

   //--------------------item updation with image----------------------------------
    public static boolean updateItemWithImage(FileInputStream fis,String... str)  // varargs
     { 
         boolean status = false;
         try
         {
                  Connection con = DbConnection.getConnection();
                  PreparedStatement     ps = con.prepareStatement("update items set item_name=?, item_price=?, item_category=?, item_desc=?, item_image=? where item_id =?");
                  ps.setString(1, str[1]);
                  ps.setString(2, str[2]);
                  ps.setString(3, str[3]);
                  ps.setString(4, str[4]);  
                  ps.setBinaryStream(5, fis);
                  ps.setString(6, str[0]);
                  
                 int i =  ps.executeUpdate();
                      
                 if(i > 0)
                 {
                     status = true;
                 }
                 else
                 {
                     status = false;
                 }
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         return status;
     }
    //-------------------------updation of item without image---------------------
     public static boolean updateItemWithoutImage(String... str)
     {
         boolean status=false;
         try
         {
                  Connection con = DbConnection.getConnection();
                  PreparedStatement   ps = con.prepareStatement("update items set item_name=?, item_price=?, item_desc=?, item_category=?, item_image=? where item_id =?");
                  ps.setString(1, str[1]);
                  ps.setString(2, str[2]);
                  ps.setString(3, str[3]);
                  ps.setString(4, str[4]);  
                  ps.setString(5, str[0]);  
                 
                 int i = ps.executeUpdate();
                 
                 if(i>0)
                 {
                     status = true;
                 }
                 else
                 {
                     status = false;
                 }
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         return status;
     }
     //----------------------------Change Password-----------------------------------
     public static boolean checkOldPassword(String old_pass,String email)
     {
         boolean status = false;
         try
         {
                 Connection con = DbConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement("select * from software where email=? and password=?");
                 
                 ps.setString(1,email);
                 ps.setString(2, old_pass);
                 
                 ResultSet rs =  ps.executeQuery();
                 if(rs.next())
                 {
                     status = true;
                 }
                 else
                 {
                     status = false;
                 }
          
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
         return status;
     }
     public static boolean updatePassword(String newPass,String email)
     {
         boolean status = false;
         try
         {
             Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("update software set password = ? where email = ?");
             ps.setString(1,newPass);
             ps.setString(2, email);
             
             int i = ps.executeUpdate();
             if(i > 0)
             {
                 status = true;
             }
             else
             {
                 status = false;
             }
             
         }
         catch(Exception e)
         {
             System.out.println(e);         
         }
         return status;
     }
         
    //---------------------------------------------------------------------------------------------------------------------------------------
     //-----------------------------------UpdateMyProfile---------------------------------------------
   public static boolean updateMyProfile(String name, String phno, String gender, String email)
    {
        boolean status=false;
        try
        {
            Connection con=DbConnection.getConnection();
            
            PreparedStatement ps=con.prepareStatement("update register set name=?, gender=?, phone_no=? where email=?");
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, phno);
            ps.setString(4, email);
            int i=ps.executeUpdate();
            if(i>0)
            {
                status=true;
            }
            else
            {
                status=false;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return status;
    }
   public static boolean insertCustomerDetails(String... str)
   {
         String name = str[0];
         String email = str[1];
         String pass = str[2];
         String gender = str[3];
         String phone_no=str[4];
         String module = str[5];
         
         boolean status = false;
         try
         {
              Connection con = DbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("insert  into software values(?,?,?,?,?,?) ");      
             ps.setString(1, name);
             ps.setString(2,email);
             ps.setString(3, pass);
             ps.setString(4, gender);
             ps.setString(5,phone_no);
             ps.setString(6, module);
             
             int i = ps.executeUpdate();
             if(i>0)
             {
                 status = true;
             }
             else
             {
                 status = false;
             }
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
        return status;
   }
    public static ResultSet checkCustomerExit(String phone_no)
    {
        ResultSet rs = null;
        try
        {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps =con.prepareStatement("select * from software where phoneNo=?");
            ps.setString(1,phone_no);
            
            rs = ps.executeQuery();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return rs;
    }
    public static boolean customerBillingDetails(String phone_no,String items,String date1,String time1,String email)
    {
        boolean sts=false;
        try
        {
            Connection con = DbConnection.getConnection();
            PreparedStatement ps =  con.prepareStatement("insert into shopping values(?,?,?,?,?)");
            ps.setString(1,phone_no);
            ps.setString(2,items);
            ps.setString(3,date1);
            ps.setString(4,time1);
            ps.setString(5,email);
               
            int i = ps.executeUpdate();
            if(i > 0)
            {
                sts = true;
            }
            else
            {
                sts = false;
            }           
        }
        catch(Exception e)
                {
                    e.printStackTrace();
                }
        return sts;
    }
}


