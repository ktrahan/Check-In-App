import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.util.Random;
import javax.swing.SpringLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Container;

//Spring layout: https://docs.oracle.com/javase/tutorial/uiswing/layout/spring.html
//Scroll bar if time: https://www.javatpoint.com/java-jscrollbar
/*
Coding Key 
/* Section */ 
// Code meaning 
//~Unfinished placeholder~ 
*/

/*setting up the basic framework. initalization code*/ 
   public UI {
    
    //Instance variables for the width, height, and testCheckIn to 0
    BufferedImage image;
    int width;
    int height;
    int testCheckIn = 0;

    //The original database that remains unchanged.
    ArrayList<Student> allStudents = new ArrayList<Student>();
    //The database that is changed/sorted and which appears in the GUI.
    ArrayList<Student> workingArray = new ArrayList<Student>();
    //Copies "allStudents" into "workingArray"
    for (int i = 0; i < allStudents.size(); i++) {
            workingArray.add(allStudents.get(i));
    }
    private int totalCount = 0; //keeps track of number of students checked in    
    //arraylist of object buttons 
      ArrayList<JButton> studentButtons = new ArrayList<JButton>();
      //use a for loop to make buttons (as many as there are students) and add to arraylist
      for (int i = 0; i < workingArray.size(); i++) {
          //ideally the buttons should be images
          studentButtons.add(new JButton(workingArray.get(i).getPicture())); //this needs to get the URL; use ImageIO.read?
          //add buttons to frame
          frame.getContentPane().add(studentButtons.get(i));
      }
    /*//Prepares GUI 
    public SwingSpringLayout(){
      prepareGUI();
   }*/
  
    public static void main(String args[]){
      //Prepares SwingSpringLayout by initiating as swingLayout  
      SwingSpringLayout swingLayout = new SwingSpringLayout();
      swingLayout.showSpringLayout();

        JFrame frame = new JFrame("SDA Check In");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
      
        Container contentPane = frame.getContentPane();  
        frame.pack();
        frame.setVisible(true); 
      }
      //Creates a copy of the original database and sorts it by numerical order with the quickSort algorithm
      ArrayList<Student> arrNum = new ArrayList<Student>();
      for (int i = 0; i < allStudents.size(); i++) {
        arrNum.add(allStudents.get(i));
      }
      //It is necessary to add a large number at the end of the database in order for the quicksort to work properly
      arrNum.add(new Student("zzz", "zzz", "9999999", null, false));
      //Creates a copy of the original database and sorts it in alphabetical order
      ArrayList<Student> arrName = new ArrayList<Student>();
      for (int i = 0; i < allStudents.size(); i++) {
        arrName.add(allStudents.get(i));
      }
      arrNum.add(new Student("zzz", "zzz", "9999999", null, false));
      quickSort(arrNum, 0, arrNum.size()-1, true);
      quickSort(arrName, 0, arrName.size()-1, false);
      
    public void showSpringLayout() {
    
    //Top half
    //Heading or title 
    JLabel headerLabel = new JLabel("SDA Check In");
    SpringLayout layout = new SpringLayout();
    
    //label that displays the totalCount (from greyPhoto)
    JLabel checkedIntext = new JLabel("Checked In: " + totalCount);
    
    // Searching for specific students - binarySearchName  
    JPanel panel = new JPanel();
    panel.setLayout(layout);
    JLabel searchLabel = new JLabel("Search by student name: ");
    JTextField searchtextField = new JTextField("",binarySearchName);
    panel.add(searchlabel);
    panel.add(searchtextField);
   
    //Layout putConstraint
    //Header label on the top 
    layout.putConstraint(SpringLayout.NORTH, headerLabel,5);
    //Check in label in the center 
    layout.putConstraint(SpringLayout.CENTER, checkedIntext, 10);
    //Search under the header 
    layout.putConstraint(SpringLayout.CENTER, searchLabel, 10);
    // View and remaining button on the right 
    layout.putConstraint(SpringLayout.EAST, ~what was in the button~, 30);
    layout.putConstraint(SpringLayout.EAST, ~what was in the button~, 30);

    } // ends showSpringLayout   
      
    /* View all method. When the button “All” is clicked, every student will show on screen, regardless of whether they’ve been checked in. This will be the default setting. */
    //Implement an action listener to define what should be done when an user performs certain operation. This displays the all button
    public void viewAll implements ActionListener() {
      //all button 
      JButton allbutton = new JButton("All");
      allbutton.setLayout(null);  
      allbutton.setVisible(true);
      frame.getContentPane().add(allbutton);

      //if the student is checked in is true then it returns everything on the screen 
       //public void actionPerformed(ActionEvent viewAll) {
      for(int i = 0; i < workingArray.size(); i++) {
        if (workingArray.get(i).getCheckedIn() == true) {
          workingArray(i).setVisible;
          return getImageList; 
          return getfname(); 
          return getlnname(); 
          return getIDNum(); 
          return getPicture(); 
          } //end if 
         } // ends for 
       } //ends allbutton methods 
      
      /*viewRemain method creates a remaining button in the UI named labeled "Remaining". When the button is pressed by user, the UI layout changes from the default to one where only the students who are not yet checked in are displayed.*/
      
      //utilizes an ActionListener to define the user action that triggers the method viewRemain.
      public void viewRemain implements ActionListener() 
      {
        //remaining button
        JButton remainingbutton = new JButton("Remaining");
        frame.getContentPane().add(remainingbutton);
        frame.setVisible(true);
      
      for(int i = 0; i < workingArray.size(); i++) {
        workingArray(i).setVisible(false); 
      }

        //finding the students that haven't been checked in
        for(int i = 0; i < workingArray.size(); i++) {
          if (workingArray.get(i).getCheckedIn() == false) {
            workingArray(i).setVisible(true); 
            //UI displays only the information of not-checked in students 
          } //end if
          i++
        } //end for
      } //end method viewRemain


    /** Method greyPhoto: When image is clicked, change photo to grayscale and back, change the checked-in count by +1/-1, and set the student to checked-in/unchecked-in.
    **/
    public void greyPhoto() { 
      //loop through entire arraylist of students
      //uses for-loop in order to specify which button is being clicked/being grayscaled
      for(int i = 0; i < workingArray.size(); i++) {
        //adds actionListener to each button in arraylist --> user click = action
        studentButtons.get(i).addActionListener(new ActionListener() {
          @Override
          //if clicked, do this:
          public void actionPerformed(ActionEvent a) {
            //set this student to checked in
            workingArray.get(i).setCheckedIn(true);
            //increment total number of students checked in
            totalCount++:
            try {
              //make a File copy of the original photo
              File input = new File(workingArray.get(i).getPicture()); //this needs to access the URL
              //read the image pixel data, width, height
              image = ImageIO.read(input);
              imageCopy = ImageIO.read(input); //to be used later to convert back to color
              width = image.getWidth();
              height = image.getHeight();
                    
              //double for-loops, goes thru each pixel
              for(int t = 0; t < height; t++) {
                for(int j = 0; j < width; j++) {
                  //get pixel value and make color 'grey'
                  Color c = new Color(image.getRGB(j, t));
                  int red = (int)(c.getRed() * 0.299);
                  int green = (int)(c.getGreen() * 0.587);
                  int blue = (int)(c.getBlue() *0.114);
                  Color newColor = new Color(red + green + blue, red + green + blue, red + green + blue);
                  //set pixel to greyscale
                  image.setRGB(j, t, newColor.getRGB());
                 } //end inner for
               } //end outer for

               //the outputed photo is now grayscaled and renamed
               File ouptut = new File("grayscale.jpg");
               ImageIO.write(image, "jpg", ouptut);
              } //end try

              //catch and print exception
              catch (Exception e) {
                  System.out.print("Exception: " + e.toString());
              } //end catch
            } //end actionPerformed() a

            //reverse greyscale: when clicked again, grey photo changes back to color
            public void actionPerformed(ActionEvent b) {
              //tests if student is checked in (meaning it's grayscale) when clicked              
              if(workingArray.get(i).getCheckedIn == true) {
                totalCount--; //decrement # of students checked in
                //set this student to not checked in
                workingArray.get(i).setCheckedIn(false);

                //make a copy of the untouched original (colored) photo
                File reOuptut = new File(workingArray.get(i).getPicture());
                //uses a copy of the read photo (from above in Try{}) and the new color photo copy to display colored photo
                ImageIO.write(imageCopy, "jpg", reOuptut);
              } //end if
            } //end actionPerformed() b
          } //end actionListener
        } //end for loop
      } //end greyPhoto()

    
    /**Part of the Quick Sort Algorithm. It compares numbers around a pivot point and swaps them so that all numbers smaller than the pivot number end up on below the pivot's index and all larger numbers end up above the pivot's index. It repeats this process through recursion until the entire ArrayList is sorted by increase number or alphabetical order. The boolean parameter "isNum" is true if sorting studentID and false if sorting student names.**/
    public static int partition(ArrayList<Student> arr, int low, int high, boolean isNum) {
        String pivot = "";
        if (isNum) {
            pivot = arr.get(low).getIDNum();
        }
        else {
            pivot = arr.get(low).getlname().concat(arr.get(low).getfname());
        }
        int i = low;
        int j = high;
        while (i < j) {
            if (isNum) {
                while (Integer.parseInt(arr.get(i).getIDNum()) <= Integer.parseInt(pivot)) {
                    i++;
                }
                while (Integer.parseInt(arr.get(j).getIDNum()) > Integer.parseInt(pivot)) {
                    j--;
                }
            }
            else {
               while ((arr.get(i).getlname().concat(arr.get(i).getfname())).compareTo(pivot) <= 0){
                i++;
            }
            while ((arr.get(j).getlname().concat(arr.get(j).getfname())).compareTo(pivot) > 0) {
                j--;
            } 
            }
            if (i < j) {
                Student temp1 = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp1);
            }
        }
        Student temp2 = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp2);
        return j;
    }
    //A sorting algorithm that uses recursion and heavily depends on the partition method.
    //It cannot process identical numbers or names(both first and last names cannot be identical) but this shouldn't be an issue.
    public static void quickSort(ArrayList<Student> arr, int low, int high, boolean isNum) {
        if (low < high) {
            int j = partition(arr, low, high, isNum);
            quickSort(arr, low, j, isNum);
            quickSort(arr, j+1, high, isNum);
        }
    }
    //A binary search method used for searching through a sorted list of integers. Specifically for studentIDs.
    static int binarySearchNum(ArrayList<Student> arr, int l, int r, int userInput){
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (Integer.parseInt(arr.get(mid).getIDNum()) == userInput) {
                return mid;
            }
            if (Integer.parseInt(arr.get(mid).getIDNum()) > userInput) {
                return binarySearchNum(arr, l, mid - 1, userInput);
            }
            return binarySearchNum(arr, mid + 1, r, userInput);
        }
        return -1;
    }
    //A binary search method used for searching through a sorted list of strings. Specifically for student names.
    static int binarySearchName(ArrayList<Student> arr, int l, int r, String userInput){
        if (r >= l) {
            int mid = l + (r - l) / 2;
            System.out.println((arr.get(mid).getlname().concat(arr.get(mid).getfname())));
            if ((arr.get(mid).getlname().concat(arr.get(mid).getfname())).compareTo(userInput) == 0) {
                return mid;
            }
            if ((arr.get(mid).getlname().concat(arr.get(mid).getfname())).compareTo(userInput) > 0) {
                return binarySearchName(arr, l, mid - 1, userInput);
            }
            return binarySearchName(arr, mid + 1, r, userInput);
        }
        return -1;
    }
  public void searchPerformed(ActionEvent q) {
    
  }
    
  } //ends public class main 
