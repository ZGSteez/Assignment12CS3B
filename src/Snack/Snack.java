/*
 * Assignment 12
 * Chapter 12
 *
 * @author Zhuo Guan
 * Implementing Snack Superclass
 */
package Snack;

public class Snack {
    protected int amount;
    protected double cost;

    public Snack(int amount){
        this.amount = amount;
    }

    /**
     * Return quantity of snack
     * @return - the quantity of snack
     */
    public int returnAmount(){
        return amount;
    }

    /**
     * Sets cost of snack
     * @param cost - the cost that the snack will be set to
     */
    public void setCost(double cost){
        this.cost = cost;
    }

    /**
     * Returns cost of snack
     * @return - the cost of the snack
     */
    public double returnCost(){
        return cost;
    }

}
