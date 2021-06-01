public class Update {
    private int id;
    private boolean status;

    public Update(boolean status, int id) {
        this.id = id;
        this.status = status;
    }

    public int getID() {
        return id;
    }

    public boolean getStatus() {
        return status;
    }
}
