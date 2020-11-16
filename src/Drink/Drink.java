/*
 * Assignment 12
 * Chapter 12
 *
 * @author Zhuo Guan
 * Implementing Drink Superclass
 */
package Drink;

public class Drink{
    protected int amount;
    protected double cost;

    public Drink(int amount){
        this.amount = amount;
    }

    /**
     * Return quantity of drinks
     * @return - the quantity of drink
     */
    public int returnAmount(){
        return amount;
    }

    /**
     * Sets the cost of a drink
     * @param cost - the cost of the drink
     */
    public void setCost(double cost){
        this.cost = cost;
    }

    /**
     * Return cost of the drink
     * @return - the cost of the drink
     */
    public double returnCost(){
        return cost;
    }


}
