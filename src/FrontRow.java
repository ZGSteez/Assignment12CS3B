import Drink.*;
import Snack.BakedGoods;
import Snack.Candy;
import Snack.Caviar;
import Snack.Fruit;

import java.util.ArrayList;

public class FrontRow {
    private static final int AMOUNT_OF_ROWS_FRONT_ROW = 3;
    private final int SEATS_PER_ROW = 4;

    private ArrayList<Row> frontRow = new ArrayList<>();


    public FrontRow(){
        setFrontRow();
    }

    public ArrayList<Row> returnFrontRow(){
        return frontRow;
    }



    public void setFrontRow() {


        for (int i = 0; i < AMOUNT_OF_ROWS_FRONT_ROW; i++) {

            Row aRow = new Row(i);

            for (int j = 0; j < SEATS_PER_ROW; j++) {

                Seat aSeat = new Seat(j);


                int champagneQuantity = (int) (Math.random() * 4);
                int beerQuantity = (int) (Math.random() * 4);
                int dairyQuantity = (int) (Math.random() * 3);
                int sodaQuantity = (int) (Math.random() * 1);
                int waterQuantity = (int) (Math.random() * 2);

                int bakedGoodsQuantity = (int) (Math.random() * 4);
                int caviarQuantity = (int) (Math.random() * 4);
                int candyQuantity = (int) (Math.random() * 1);
                int fruitQuantity = (int) (Math.random() * 5);


                aSeat.addDrink(new Champagne(champagneQuantity));
                aSeat.addDrink(new Beer(beerQuantity));
                aSeat.addDrink(new Dairy(dairyQuantity));
                aSeat.addDrink(new Soda(sodaQuantity));
                aSeat.addDrink(new Water(waterQuantity));
                aSeat.addSnack(new BakedGoods(bakedGoodsQuantity));
                aSeat.addSnack(new Caviar(caviarQuantity));
                aSeat.addSnack(new Candy(candyQuantity));
                aSeat.addSnack(new Fruit(fruitQuantity));

                aRow.addSeat(aSeat);

            }

            frontRow.add(aRow);


        }
    }

    public int returnAmountOfRows(){
        return AMOUNT_OF_ROWS_FRONT_ROW;
    }



}
