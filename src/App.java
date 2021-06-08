/*
Main program
*/
class App {
  public static void main(String[] args){
    
    //For the GUI group to get user input (slave or master) the following scanner is temporary
	  Scanner device = new Scanner(System.in);
	  System.out.println(“IS THIS DEVICE A MASTER OR SLAVE”);
	  String deviceResponse = device.nextLine();
    
    //check if device is a slave then create and setup the slave
    if(deviceResponse.equals(slave)){
  		Slave slaveDevice = new Slave(/*whatever the slave IP adress is*/, /* whater the master IP adress is*/);
      slaveDevice.setupSlave(); 
    }
    
    while(true){
    
    //main loop, put code that is run continuously here
      
    }
    
    
  }
}
