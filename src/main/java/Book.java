
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Book available in the library
 */
public class Book {
    
    /**
     * Book ID
     */
    private int  ID;


    /**
     * Book title
     */
    private String title;


	/**
     * Authors
     */
    private ArrayList<String> authors = new ArrayList<String>();



    /**
     * Book status: true - Available; false - Not available
     */
    private boolean status = true;


    /**
     * Book demand: 0 - low demand; 1 - high demand
     */
    private int demand;

   /**
     * Return days of the book
     */
    private int days = 0;




    public Book(int ID, String title, int demand) {
        this.ID = ID;
        this.title = title;
	   this.demand = demand;
    }



    public int getDemand() {
        return this.demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
   

    public void setTitle(String title) {
        this.title = title;
    }


    public String getTitle() {
        return this.title;
    }


    public int days() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean getStatus() {
        return status;
    }

    public void setDemand(boolean status) {
        this.status = status;
    }




}
