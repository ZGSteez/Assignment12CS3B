package Drink;

public class Drink{
    protected int amount;
    protected double cost;

    public Drink(int amount){
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
