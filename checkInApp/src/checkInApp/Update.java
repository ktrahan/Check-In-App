public class Update
{
  private String studentName;
  private boolean status;
  public Update(String studentName, boolean status)
  {
    this.studentName = studentName;
    this.status = status;
  }
  public String getStudentName()
  {
    return studentName;
  }
  public boolean getStatus()
  {
    return status;
  }
}
