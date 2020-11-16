/*
 * Assignment 12
 * Chapter 12
 *
 * @author Zhuo Guan
 * Implementing Row class
 */
import java.util.*;

public class Row{
    private ArrayList<Seat> row = new ArrayList<>();
    private int rowID;

    public Row(int rowID){
        this.rowID = rowID;
    }

    public int returnRowID(){
        return rowID;
    }

    public void addSeat(Seat aSeat){
        row.add(aSeat);
    }

    public ArrayList<Seat> returnRow(){
        return row;
    }

}
