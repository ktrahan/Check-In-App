
public class Update {
    private int id;
    private boolean status;

    /**
     * Constructor
     * 
     * @param status Whether or not the student is checked in.
     * @param id     The student ID # of the student.
     */
    public Update(boolean status, int id) {
        this.id = id;
        this.status = status;
    }

    /**
     * Getter for ID.
     * 
     * @return int The student's ID #.
     */
    public int getID() {
        return id;
    }

    /**
     * Getter for status.
     * 
     * @return int The student's checked in status.
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Setter for status.
     * 
     * @param status The new student status to be assigned to this student.
     */
    public void setStatus(boolean status) {
        this.status = status;
    }
}
