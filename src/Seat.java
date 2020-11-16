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

    public int returnSeatNumber(){
        return seatNumber;
    }

    public void addSnack(Snack snack){
        snackAmount.add(snack);
    }

    public void addDrink(Drink drink){
        amountOfDrinks.add(drink);
    }

    public ArrayList<Snack> returnSnackAmount(){
        return snackAmount;
    }

    public ArrayList<Drink> returnDrinkAmount(){

        return amountOfDrinks;
    }

}
