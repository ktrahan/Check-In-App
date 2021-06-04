import javax.swing.ImageIcon;
import java.util.ArrayList;
class Student
{
  private String fname;
  private String lname;
  private String idNum;
  private ImageIcon picture;
  
  private boolean checkedIn;
  private ArrayList<Student> allStudents;
  private ArrayList<Student> studentsNotAtDance;
  private ArrayList<Student> studentsAtDance;
  
  public Student()
  {
    fname = "Nathan";
    lname = "Fadick";
    idNum = "000000";
    picture = new ImageIcon("ZeroArgumentPhoto.jpg");

    checkedIn = false;
  }

  public Student(String firstName, String lastName, String idNumber)
  {
    fname = firstName;
    lname = lastName;
    idNum = idNumber;
    picture = new ImageIcon("MysteryPerson.png");

    checkedIn = false;
  }

  public Student(String firstName, String lastName, String idNumber, ImageIcon studentPicture)
  {
    fname = firstName;
    lname = lastName;
    idNum = idNumber;
    picture = studentPicture;

    checkedIn = false;
  }

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

  public boolean getCheckedIn()
  {
    return checkedIn;
  }

  public void setCheckedIn(boolean check)
  {
    checkedIn = check;
  }
  
  public String toString()
  {
    return ("First Name: " + fname + "\nLast Name: " + lname + "\nID Number: " + idNum);
  }
}
