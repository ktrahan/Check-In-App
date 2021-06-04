import javax.swing.ImageIcon;
import java.util.ArrayList;

class StudentOrganizer
{
  private ArrayList<Student> allStudents;
  private ArrayList<Student> studentsNotAtDance;
  private ArrayList<Student> studentsAtDance;
  //Nathan Fadick

  //This method takes in arraylists from one of the other teams to create an arraylist of students
  public ArrayList<Student> takeInStudents(ArrayList<String> fnames, ArrayList<String> lnames, ArrayList<String> idNums, ArrayList<ImageIcon> pictures)
  {
    ArrayList<Student> takedInStudents = new ArrayList<Student>();
    for (int x = 0; x < fnames.size(); x++)
    {
      String fname = fnames.get(x);
      String lname = lnames.get(x);
      String idNum = idNums.get(x);
      ImageIcon picture = pictures.get(x);
      if (picture == null)
      {
        takedInStudents.add(new Student(fname, lname, idNum));
      }
      else
      {
        takedInStudents.add(new Student(fname, lname, idNum));
      }
    }
    return takedInStudents;
  }


  //Casey Work
  // This method returns if the selected student is at the dance
  public boolean isAtDance(Student student){
    return student.getCheckedIn();
  }
  // This method adds a student to the ArrayList
  public static void addStudent(Student student){
    allStudents.add(student);
  }

  public ArrayList<Student> atDance(){
    for(int i = 0; i < allStudents.size(); i++){
      if(allStudents.get(i).getCheckedIn() == true){
        studentsAtDance.add(allStudents.get(i));
      }
    }
    return studentsAtDance;
  }

  public ArrayList<Student> notAtDance(){
    for(int i = 0; i < allStudents.size(); i++){
      if(allStudents.get(i).getCheckedIn() == false){
        studentsNotAtDance.add(allStudents.get(i));
      }
    }
    return studentsNotAtDance;
  }

  public ArrayList<Student> getStudents(){
    return allStudents;
  }
  public static void main(String[] args){
    System.out.println("Test");
  }
}
