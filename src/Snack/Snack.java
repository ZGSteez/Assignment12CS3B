package Snack;

public class Snack {
    protected int amount;
    protected double cost;

    public Snack(int amount){
        this.amount = amount;
    }

    public int returnAmount(){
        return amount;
    }

    public void setCost(double cost){
        this.cost = cost;
    }

    public double returnCost(){
        return cost;
    }

}
