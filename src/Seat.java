/*
 * Assignment 12
 * Chapter 12
 *
 * @author Zhuo Guan
 * Implementing Seat class
 */
import Drink.Drink;
import Snack.Snack;

import java.util.*;

public class Seat {
    private ArrayList<Snack> snackAmount = new ArrayList<>();
    private ArrayList<Drink> amountOfDrinks = new ArrayList<>();

    private int seatNumber = 0;

    public Seat(int seatNumber){
        this.seatNumber = seatNumber;
    }

    /**
     * Returns the seat number
     * @return - the seat number
     */
    public int returnSeatNumber(){
        return seatNumber;
    }

    /**
     * Adds snack ordered to the receipt for the customer sitting at this seat
     * @param snack - the snack added to the receipt
     */
    public void addSnack(Snack snack){
        snackAmount.add(snack);
    }

    /**
     * Adds drink ordered to the receipt for the customer sitting at this seat
     * @param drink - the drink added to the receipt
     */
    public void addDrink(Drink drink){
        amountOfDrinks.add(drink);
    }

    /**
     * Returns all the snacks ordered by customer sitting at seat
     * @return - all the snacks
     */
    public ArrayList<Snack> returnSnackAmount(){
        return snackAmount;
    }

    /**
     * Returns all the drinks ordered by customer sitting at seat
     * @return - all the drinks
     */
    public ArrayList<Drink> returnDrinkAmount(){

        return amountOfDrinks;
    }

}
