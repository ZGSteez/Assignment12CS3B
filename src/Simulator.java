/*
 * Assignment 12
 * Chapter 12
 *
 * @author Zhuo Guan
 * Implementing Simulator
 */

import Drink.*;
import Snack.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Simulator {

    private BackRow backRow = new BackRow();
    private FrontRow frontRow = new FrontRow();
    private String firstReport = "";
    private String secondReport = "";
    private FileWriter firstWriter = new FileWriter("firstReport.txt", false);
    private FileWriter secondWriter = new FileWriter("secondReport.txt", false);
    private PrintWriter firstPrinter = new PrintWriter(firstWriter);
    private PrintWriter secondPrinter = new PrintWriter(secondWriter);
    private boolean firstStatus = false;
    private boolean secondStatus = false;

    /**
     * Changes first fileWriter, so that it will append to file
     * @throws IOException
     */
    public void modifyFirst() throws IOException {
        firstWriter = new FileWriter("firstReport.txt", true);
    }

    /**
     * Changes second fileWriter, so that it will append to file
     * @throws IOException
     */
    public void modifySecond() throws IOException {
        secondWriter = new FileWriter("secondReport.txt", true);
    }

    /**
     * Closes first printerWriter
     */
    public void closeFirst() {
        firstPrinter.close();
    }

    /**
     * Closes second printerWriter
     */
    public void closeSecond() {
        secondPrinter.close();
    }

    public Simulator() throws IOException {
        mainMenu();
    }

    /**
     * Generates the report for Simulator class
     * @throws IOException
     */
    public void mainMenu() throws IOException {
        firstPrinter.println("BackRow :");
        generateCostReport(backRow.returnBackRow());

        firstPrinter.println();
        firstPrinter.println();


        firstPrinter.println("FrontRow :");
        generateCostReport(frontRow.returnFrontRow());

        closeFirst();

        secondPrinter.println("BackRow :");
        generateReportOfQuantityOfAmenitiesOrdered(backRow.returnBackRow());

        secondPrinter.println();
        secondPrinter.println();


        secondPrinter.println("FrontRow :");
        generateReportOfQuantityOfAmenitiesOrdered(frontRow.returnFrontRow());

        closeSecond();

        System.out.print("Reports generated successfully.");

    }

    /**
     * Generates first report
     * @param rows - row (BackRow/FrontRow)
     * @throws IOException
     */
    // Report 2
    public void generateReportOfQuantityOfAmenitiesOrdered(ArrayList<Row> rows) throws IOException {

        if (secondStatus) {
            modifySecond();
        }

        int counter = 0;
        int totalDrinksForRow = 0;
        int totalSnacksForRow = 0;
        int totalBeerAmountForRow = 0;
        int totalChampagneAmountForRow = 0;
        int totalDairyAmountForRow = 0;
        int totalSodaAmountForRow = 0;
        int totalWaterAmountForRow = 0;
        int totalBakedGoodsAmountForRow = 0;
        int totalCandyAmountForRow = 0;
        int totalCaviarAmountForRow = 0;
        int totalFruitAmountForRow = 0;
        int totalDrinksForSection = 0;
        int totalSnacksForSection = 0;
        int totalBeerAmountForSection = 0;
        int totalChampagneAmountForSection = 0;
        int totalDairyAmountForSection = 0;
        int totalSodaAmountForSection = 0;
        int totalWaterAmountForSection = 0;
        int totalBakedGoodsAmountForSection = 0;
        int totalCandyAmountForSection = 0;
        int totalCaviarAmountForSection = 0;
        int totalFruitAmountForSection = 0;

        for (Row aRow : rows) {
            secondPrinter.print("Row " + aRow.returnRowID());
            secondPrinter.println("   ");

            int seatCounter = 0;
            for (Seat aSeat : aRow.returnRow()) {
                String drinkDescription = "";
                String snackDescription = "";
                int beerAmount = 0;
                int champagneAmount = 0;
                int dairyAmount = 0;
                int drinkAmount = 0;
                int sodaAmount = 0;
                int waterAmount = 0;
                int sumOfDrinks = 0;
                int sumOfSnacks = 0;
                int bakedGoodsAmount = 0;
                int candyAmount = 0;
                int caviarAmount = 0;
                int fruitAmount = 0;

                for (Drink aDrink : aSeat.returnDrinkAmount()) {
                    sumOfDrinks += aDrink.returnAmount();

                    if (aDrink instanceof Beer) {
                        Drink downcast = (Beer) aDrink;
                        beerAmount = aDrink.returnAmount();

                    } else if (aDrink instanceof Champagne) {
                        Drink downcast = (Champagne) aDrink;
                        champagneAmount = aDrink.returnAmount();
                    } else if (aDrink instanceof Dairy) {
                        Drink downcast = (Dairy) aDrink;
                        dairyAmount = aDrink.returnAmount();
                    } else if (aDrink instanceof Soda) {
                        Drink downcast = (Soda) aDrink;
                        sodaAmount = aDrink.returnAmount();
                    } else if (aDrink instanceof Water) {
                        Drink downcast = (Water) aDrink;
                        waterAmount = aDrink.returnAmount();
                    }

                }

                for (Snack aSnack : aSeat.returnSnackAmount()) {
                    sumOfSnacks += aSnack.returnAmount();
                    if (aSnack instanceof BakedGoods) {
                        Snack downcast = (BakedGoods) aSnack;
                        bakedGoodsAmount = aSnack.returnAmount();

                    } else if (aSnack instanceof Candy) {
                        Snack downcast = (Candy) aSnack;
                        candyAmount = aSnack.returnAmount();
                    } else if (aSnack instanceof Caviar) {
                        Snack downcast = (Caviar) aSnack;
                        caviarAmount = aSnack.returnAmount();
                    } else if (aSnack instanceof Fruit) {
                        Snack downcast = (Fruit) aSnack;
                        fruitAmount = aSnack.returnAmount();
                    }

                }

                secondPrinter.print("Seat #: " + aSeat.returnSeatNumber() + " {");
                secondPrinter.print("Total Drinks: " + sumOfDrinks +
                        " (Beer:" + beerAmount + ", Champagne: " + champagneAmount + ", Dairy: " + dairyAmount +
                        ", Soda: " + sodaAmount + ", Water: " + waterAmount);
                secondPrinter.print(" ; ");
                secondPrinter.println("Total Snacks: " + sumOfSnacks +
                        " (BakedGoods: " + bakedGoodsAmount + ", Candy: " + candyAmount + ", Caviar: " + caviarAmount +
                        ", Fruit: " + fruitAmount + ")" + " }");

                totalDrinksForRow += sumOfDrinks;
                totalSnacksForRow += sumOfSnacks;
                totalBeerAmountForRow += beerAmount;
                totalChampagneAmountForRow += champagneAmount;
                totalDairyAmountForRow += dairyAmount;
                totalSodaAmountForRow += sodaAmount;
                totalWaterAmountForRow += waterAmount;
                totalBakedGoodsAmountForRow += bakedGoodsAmount;
                totalCandyAmountForRow += candyAmount;
                totalCaviarAmountForRow += caviarAmount;
                totalFruitAmountForRow += fruitAmount;

            }
            secondPrinter.print("Row " + aRow.returnRowID() + ": {");
            secondPrinter.print("Total Drinks: " + totalDrinksForRow +
                    " (Beer:" + totalBeerAmountForRow + ", Champagne: " + totalChampagneAmountForRow + ", Dairy: " + totalDairyAmountForRow +
                    ", Soda: " + totalSodaAmountForRow + ", Water: " + totalWaterAmountForRow);


            secondPrinter.print(" ; ");

            secondPrinter.println("Total Snacks: " + totalSnacksForRow +
                    " (BakedGoods: " + totalBakedGoodsAmountForRow + ", Candy: " + totalCandyAmountForRow + ", Caviar: " + totalCaviarAmountForRow +
                    ", Fruit: " + totalFruitAmountForRow + ")" + " }");
            totalDrinksForSection += totalDrinksForRow;
            totalSnacksForSection += totalSnacksForRow;

            totalBeerAmountForSection += totalBeerAmountForRow;
            totalChampagneAmountForSection += totalChampagneAmountForRow;
            totalDairyAmountForSection += totalDairyAmountForRow;
            totalSodaAmountForSection += totalSodaAmountForRow;
            totalWaterAmountForSection += totalWaterAmountForRow;

            totalBakedGoodsAmountForSection += totalBakedGoodsAmountForRow;
            totalCandyAmountForSection += totalCandyAmountForRow;
            totalCaviarAmountForSection += totalCaviarAmountForRow;
            totalFruitAmountForSection += totalFruitAmountForRow;

            totalDrinksForRow = 0;
            totalSnacksForRow = 0;
            totalBeerAmountForRow = 0;
            totalChampagneAmountForRow = 0;
            totalDairyAmountForRow = 0;
            totalSodaAmountForRow = 0;
            totalWaterAmountForRow = 0;
            totalBakedGoodsAmountForRow = 0;
            totalCandyAmountForRow = 0;
            totalCaviarAmountForRow = 0;
            totalFruitAmountForRow = 0;

            secondPrinter.println();
        }
        secondPrinter.print("For Section: {");
        secondPrinter.print("Total Drinks: " + totalDrinksForSection +
                " (Beer:" + totalBeerAmountForSection + ", Champagne: " + totalChampagneAmountForSection + ", Dairy: " + totalDairyAmountForSection +
                ", Soda: " + totalSodaAmountForSection + ", Water: " + totalWaterAmountForSection);


        secondPrinter.print(" ; ");

        secondPrinter.println("Total Snacks: " + totalSnacksForSection +
                " (BakedGoods: " + totalBakedGoodsAmountForSection + ", Candy: " + totalCandyAmountForSection + ", Caviar: " + totalCaviarAmountForSection +
                ", Fruit: " + totalFruitAmountForSection + ")" + " }");

        secondStatus = true;
    }

    /**
     * Generates second report
     * @param rows - row (BackRow/FrontRow)
     * @throws IOException
     */
    // Report 1
    public void generateCostReport(ArrayList<Row> rows) throws IOException {


        if (firstStatus) {
            modifyFirst();
        }
        int counter = 0;
        double totalDrinksForRow = 0;
        double totalSnacksForRow = 0;
        double totalBeerAmountForRow = 0;
        double totalChampagneAmountForRow = 0;
        double totalDairyAmountForRow = 0;
        double totalSodaAmountForRow = 0;
        double totalWaterAmountForRow = 0;
        double totalBakedGoodsAmountForRow = 0;
        double totalCandyAmountForRow = 0;
        double totalCaviarAmountForRow = 0;
        double totalFruitAmountForRow = 0;
        double totalDrinksForSection = 0;
        double totalSnacksForSection = 0;
        double totalBeerAmountForSection = 0;
        double totalChampagneAmountForSection = 0;
        double totalDairyAmountForSection = 0;
        double totalSodaAmountForSection = 0;
        double totalWaterAmountForSection = 0;
        double totalBakedGoodsAmountForSection = 0;
        double totalCandyAmountForSection = 0;
        double totalCaviarAmountForSection = 0;
        double totalFruitAmountForSection = 0;

        for (Row aRow : rows) {
            firstPrinter.print("Row " + aRow.returnRowID());
            firstPrinter.println("   ");


            int seatCounter = 0;
            for (Seat aSeat : aRow.returnRow()) {
                String drinkDescription = "";
                String snackDescription = "";
                double beerAmount = 0;
                double champagneAmount = 0;
                double dairyAmount = 0;
                double drinkAmount = 0;
                double sodaAmount = 0;
                double waterAmount = 0;
                double sumOfDrinks = 0;
                double sumOfSnacks = 0;
                double bakedGoodsAmount = 0;
                double candyAmount = 0;
                double caviarAmount = 0;
                double fruitAmount = 0;

                for (Drink aDrink : aSeat.returnDrinkAmount()) {
                    // System.out.print(aDrink.returnAmount() + " ");
                    sumOfDrinks += aDrink.returnAmount() * aDrink.returnCost();

                    if (aDrink instanceof Beer) {
                        Drink downcast = (Beer) aDrink;
                        beerAmount = aDrink.returnAmount() * aDrink.returnCost();

                    } else if (aDrink instanceof Champagne) {
                        Drink downcast = (Champagne) aDrink;
                        champagneAmount = aDrink.returnAmount() * aDrink.returnCost();
                    } else if (aDrink instanceof Dairy) {
                        Drink downcast = (Dairy) aDrink;
                        dairyAmount = aDrink.returnAmount() * aDrink.returnCost();
                    } else if (aDrink instanceof Soda) {
                        Drink downcast = (Soda) aDrink;
                        sodaAmount = aDrink.returnAmount() * aDrink.returnCost();
                    } else if (aDrink instanceof Water) {
                        Drink downcast = (Water) aDrink;
                        waterAmount = aDrink.returnAmount() * aDrink.returnCost();
                    }

                }

                for (Snack aSnack : aSeat.returnSnackAmount()) {
                    sumOfSnacks += aSnack.returnAmount() * aSnack.returnCost();
                    if (aSnack instanceof BakedGoods) {
                        Snack downcast = (BakedGoods) aSnack;
                        bakedGoodsAmount = aSnack.returnAmount() * aSnack.returnCost();

                    } else if (aSnack instanceof Candy) {
                        Snack downcast = (Candy) aSnack;
                        candyAmount = aSnack.returnAmount() * aSnack.returnCost();
                    } else if (aSnack instanceof Caviar) {
                        Snack downcast = (Caviar) aSnack;
                        caviarAmount = aSnack.returnAmount() * aSnack.returnCost();
                    } else if (aSnack instanceof Fruit) {
                        Snack downcast = (Fruit) aSnack;
                        fruitAmount = aSnack.returnAmount() * aSnack.returnCost();
                    }

                }
                firstPrinter.print("Seat #: " + aSeat.returnSeatNumber() + " {");
                firstPrinter.print("Total Drinks Cost: " + "$" + String.format("%,.2f", sumOfDrinks) +
                        " (Beer:" + "$" + String.format("%,.2f", beerAmount) + ", " +
                        "Champagne: " + "$" + String.format("%,.2f", champagneAmount) + ", " +
                        "Dairy: " + "$" + String.format("%,.2f", dairyAmount) + ", " +
                        "Soda: " + "$" + String.format("%,.2f", sodaAmount) + ", " +
                        "Water: " + "$" + String.format("%,.2f", waterAmount));

                firstPrinter.printf(" ; ");
                firstPrinter.println("Total Snacks Cost: " + "$" + String.format("%,.2f", sumOfSnacks) +
                        " (BakedGoods: " + "$" + String.format("%,.2f", bakedGoodsAmount) + ", " +
                        "Candy: " + "$" + String.format("%,.2f", candyAmount) + ", " +
                        "Caviar: " + "$" + String.format("%,.2f", caviarAmount) +
                        ", Fruit: " + "$" + String.format("%,.2f", fruitAmount) +
                        ")" + " }");
                totalDrinksForRow += sumOfDrinks;
                totalSnacksForRow += sumOfSnacks;
                totalBeerAmountForRow += beerAmount;
                totalChampagneAmountForRow += champagneAmount;
                totalDairyAmountForRow += dairyAmount;
                totalSodaAmountForRow += sodaAmount;
                totalWaterAmountForRow += waterAmount;
                totalBakedGoodsAmountForRow += bakedGoodsAmount;
                totalCandyAmountForRow += candyAmount;
                totalCaviarAmountForRow += caviarAmount;
                totalFruitAmountForRow += fruitAmount;
            }

            firstPrinter.print("Row " + aRow.returnRowID() + ": {");
            firstPrinter.print("Total Drinks Cost: " + "$" + String.format("%,.2f", totalDrinksForRow) +
                    " (Beer:" + "$" + String.format("%,.2f", totalBeerAmountForRow) + "," +
                    " Champagne: " + "$" + String.format("%,.2f", totalChampagneAmountForRow) + "," +
                    " Dairy: " + "$" + String.format("%,.2f", totalDairyAmountForRow) + "," +
                    " Soda: " + "$" + String.format("%,.2f", totalSodaAmountForRow) + "," +
                    " Water: " + "$" + String.format("%,.2f", totalWaterAmountForRow));
            firstPrinter.print(" ; ");

            firstPrinter.println("Total Snacks Cost: " + "$" + String.format("%,.2f", totalSnacksForRow) +
                    " (BakedGoods: " + "$" + String.format("%,.2f", totalBakedGoodsAmountForRow) + "," +
                    " Candy: " + "$" + String.format("%,.2f", totalCandyAmountForRow) + "," +
                    " Caviar: " + "$" + String.format("%,.2f", totalCaviarAmountForRow) + "," +
                    " Fruit: " + "$" + String.format("%,.2f", totalFruitAmountForRow) + ")" + " }");
            totalDrinksForSection += totalDrinksForRow;
            totalSnacksForSection += totalSnacksForRow;

            totalBeerAmountForSection += totalBeerAmountForRow;
            totalChampagneAmountForSection += totalChampagneAmountForRow;
            totalDairyAmountForSection += totalDairyAmountForRow;
            totalSodaAmountForSection += totalSodaAmountForRow;
            totalWaterAmountForSection += totalWaterAmountForRow;

            totalBakedGoodsAmountForSection += totalBakedGoodsAmountForRow;
            totalCandyAmountForSection += totalCandyAmountForRow;
            totalCaviarAmountForSection += totalCaviarAmountForRow;
            totalFruitAmountForSection += totalFruitAmountForRow;

            totalDrinksForRow = 0;
            totalSnacksForRow = 0;
            totalBeerAmountForRow = 0;
            totalChampagneAmountForRow = 0;
            totalDairyAmountForRow = 0;
            totalSodaAmountForRow = 0;
            totalWaterAmountForRow = 0;
            totalBakedGoodsAmountForRow = 0;
            totalCandyAmountForRow = 0;
            totalCaviarAmountForRow = 0;
            totalFruitAmountForRow = 0;
            firstPrinter.println();
        }

        firstPrinter.print("For Section: {");
        firstPrinter.print("Total Drink Cost: " + "$" + String.format("%,.2f", totalDrinksForSection) +
                " (Beer:" + "$" + String.format("%,.2f", totalBeerAmountForSection) + "," +
                " Champagne: " + "$" + String.format("%,.2f", totalChampagneAmountForSection) + ", " +
                "Dairy: " + "$" + String.format("%,.2f", totalDairyAmountForSection) + "," +
                " Soda: " + "$" + String.format("%,.2f", totalSodaAmountForSection) + "," +
                " Water: " + "$" + String.format("%,.2f", totalWaterAmountForSection));
        firstPrinter.print(" ; ");
        firstPrinter.println("Total Snacks: " + "$" + String.format("%,.2f", totalSnacksForSection) +
                " (BakedGoods: " + "$" + String.format("%,.2f", totalBakedGoodsAmountForSection) + ", " +
                "Candy: " + "$" + String.format("%,.2f", totalCandyAmountForSection) + ", " +
                "Caviar: " + "$" + String.format("%,.2f", totalCaviarAmountForSection) + ", " +
                "Fruit: " + "$" + String.format("%,.2f", totalFruitAmountForSection) + ")" + " }");
        firstStatus = true;
    }


    public static void main(String[] args) throws IOException {
        new Simulator();
    }
}
//    In an airplane, each passenger has a touch screen for ordering a drink and a snack.
//        Some items are free and some are not. The system prepares two reports for speeding
//        up service:
//        1. A list of all seats, ordered by row, showing the charges that must be collected.
//        2. A list of how many drinks and snacks of each type must be prepared for the
//        front and the rear of the plane.
//        Follow the design process that was described in this chapter to identify classes, and
//        implement a program that simulates the system.