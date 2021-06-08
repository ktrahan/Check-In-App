import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Slave {
  String slaveID; // this will be used to create a unique list of slaves on the master
  int masterIP; // this will be used to identify the master

  // Constructor given slave and master IPs
  public Slave(String IPAddress, int masterIP) {
    slaveID = IPAddress;
    this.masterIP = masterIP;
  }

  // Getting the slave IDs (which are also the Slave IPs)
  public String getSlaveID() {
    return (this.slaveID);
  }

  public void setupSlave(int port){
    //setup client
    Client cl = new Client(slaveID, port);

    //setup CSV file reader
    BufferedReader br = new BufferedReader(new FileReader("//csvfilename"));
    String line = null;
	  
    //hashmap
    HashMap<Integer, StudentShort> map = new HashMap<Integer, StudentShort>();

    //setup Student class variables
    int studentID = 0;
    String name = null;
    //we assume checkedIn is false to start
		
    //assuming CSV is in format (“studentname”, “studentID”)
    while ((line = br.readLine()) != null) {
      String[] str = line.split(",");
      if(str[0] != /*whatever the header of the csv is*/){
  	    studentID = Integer.parseInt(str[1]);
	      name = str[0];
	      map.put(studentID, new StudentShort(name, studentID, false));
      }
    }
    
    //create an arraylist to store of all of the transactions
    ArrayList<Integer> studID = new ArrayList<Integer>();
   
    //check prevent double reading by using the array to check to see if there are no more values
    int counter = 0;
    studID.add(cl.read());
    while(studID.get(counter) != 0){
      studID.add(cl.read());
      counter++;
    }
		
    //check the list of transactions
    for(int stuID : studID){
      if (stuID > 0) {
	map.get(Math.abs(stuID)).checkedIn(true); //index the hashmap using the studentID, update the checkedIn variable of that object to be checked in
      }
      else if (stuID < 0) {
	map.get(Math.abs(stuID)).setCheckedIn(false); //index the hashmap using the studentID, update the checkedOut variable of that object to be checked out
      }
    }
  }
}

class StudentShort {
  int studentID;
  String name;
  public Boolean checkedIn;

  public StudentShort(String studname, int studId, Boolean checkIn) {
    studentID = studId;
    name = studname;
    checkedIn = checkIn;
  }

  // getters and setters
  public int getStudentID() {
    return (studentID);
  }

  public String getName() {
    return (name);
  }

  public Boolean getCheckedIn() {
    return (checkedIn);
  }

  public void setStudentID(int sid) {
    studentID = sid;
  }

  public void setName(String n) {
    name = n;
  }

  public void setCheckedIn(Boolean t) {
    checkedIn = t;
  }

}
