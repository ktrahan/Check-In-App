import javax.swing.ImageIcon;
import java.util.ArrayList;

class Student
{
  //These variables store all the individual data for each student that has to be set during an instances creation
  private String fname;
  private String lname;
  private String idNum;
  private ImageIcon picture;
  
//This is used by other groups to check if the student has been checked in yet
  private boolean checkedIn;
  
  //Zero argument constructor just in case
  public Student()
  {
    fname = "NO FIRST NAME";
    lname = "NO LAST NAME";
    idNum = "000000";
    picture = new ImageIcon("ZeroArgumentPhoto.jpg");

    checkedIn = false;
  }

//Three argument constructor because sometimes people don't have a school photo
  public Student(String firstName, String lastName, String idNumber)
  {
    fname = firstName;
    lname = lastName;
    idNum = idNumber;
    picture = new ImageIcon("MysteryPerson.png");

    checkedIn = false;
  }

//Four argument constructor for students with all their information
  public Student(String firstName, String lastName, String idNumber, ImageIcon studentPicture)
  {
    fname = firstName;
    lname = lastName;
    idNum = idNumber;
    picture = studentPicture;

    checkedIn = false;
  }

//These get methods are for other groups to access information about a gicen student
  public String getfname()
  {
    return fname;
  }

  public String getlname()
  {
    return lname;
  }

  public String getIDNum()
  {
    return idNum;
  }

  public ImageIcon getPicture()
  {
    return picture;
  }

//The checkedin getters and setters are for groups to be able to check if students are checked in and actually set whether or not they are checked in
  public boolean getCheckedIn()
  {
    return checkedIn;
  }

  public void setCheckedIn(boolean check)
  {
    checkedIn = check;
  }
  
  //This was put in so you can check if all the information about the student is correct easily, used mostly for tesing if the code worked fine
  public String toString()
  {
    return ("First Name: " + fname + "\nLast Name: " + lname + "\nID Number: " + idNum);
  }
}
