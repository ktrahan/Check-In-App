import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Slave {
  int slaveID; //this will be used to create a unique list of slaves on the master
	int masterIP; //this will be used to identify the master
  
  //Constructor given slave and master IPs
	public Slave(int IPAddress, int masterIP){
		slaveID = IPAdress;
		this.masterIP = masterIP;
  }
  
  //Getting the slave IDs (which are also the Slave IPs)
	public int getSlaveID(){
		return(this.slaveID);
  }
 
  public setupSlave(){
	  //setup client
	  Client cl = new Client(IPadress, port);

		//setup CSV file reader
    BufferedReader br = new BufferedReader(new FileReader("//csvfilename"));
    String line = null;
	
	  //hashmap
	  HashMap map = new HashMap();

  	//setup Student class variables
		int studentID = 0;
		String name = null;
		//we assume checkedIn is false to start
		
		//assuming CSV is in format (“studentname”, “studentID”)
		while ((line = br.readLine()) != null) {
			String[] str = line.split(“,”);
      if(str[0] != /*whatever the header of the csv is*/){
  			studentID = Integer.parseInt(str[1]);
	  		name = str[0];
		  	map.put(studentID, new Student(name, studentID, false));
	    }
    }
    
    //create an arraylist to store of all of the transactions
    ArrayList<int> studID = new ArrayList<int>();
   
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
			  map.get(Math.abs(stuID)).checkedIn = true; //index the hashmap using the studentID, update the checkedIn variable of that object to be checked in
		  }
		  else if (stuID < 0) {
			  map.get(Math.abs(stuID)).checkedIn = false; //index the hashmap using the studentID, update the checkedOut variable of that object to be checked out
      }
    }
  }
} 
