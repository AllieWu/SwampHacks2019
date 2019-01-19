package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static void main(String [] args)
    {
        // REMEMBER TO ADD PERIODS
        Scanner myScannerObj = new Scanner(System.in);
        String charName;
        double currentBalance = 0.00;
        double dailyLivingExpense = 21.00;
        int numBurgers;
        int numClothes;
        int managerHours;
        String job = "burgerFlipper";

        System.out.println("Welcome to Money Matters! The game where you learn to manage your money. \n");
        System.out.print("Please enter a name for your character: ");
        charName = myScannerObj.next();
        System.out.println("\nHello " + charName + "! Welcome to Rob's Burgers. Here you will begin your first job as a \nburger flipper. For each" +
                " burger you flip you will earn $1.00, which is added \nto your balance. We'll start you off at $0.00. The daily living expense is $21.00.\n");

        for (int day = 1; day < 31; day++)
        {
            System.out.println("\nWelcome to day " + day + "! Your current balance is $" + currentBalance);

            if (job.equals("burgerFlipper"))
            {
                System.out.println("Welcome to day " + day + "! Your current balance is $" + currentBalance);
                System.out.print("How many burgers would you like to flip today? (Please choose a # between 0-50 inclusive.): ");
                numBurgers = myScannerObj.nextInt();
                boolean eventFinished = false;
                while (!eventFinished)
                {
                    try {
                        if ((numBurgers >= 0) && (numBurgers <= 50))
                        {
                            currentBalance += calcBurgerMoney(numBurgers);
                            System.out.println("You've made $" + System.out.printf("%.2f", calcBurgerMoney(numBurgers)));
                            System.out.println("Now your balance is $" + currentBalance);
                            System.out.println("Phew! That was a tiring day of flipping burgers.");
                            eventFinished = true;
                        }
                    }
                    catch (InputMismatchException e ) {// We are simply gonna ask again
                        System.out.println("Error: " + e.getMessage()); }
                }
                if (currentBalance > 250.00)
                {
                    job = "salesClerk";
                    System.out.println("Congratulations! You've been promoted from burger flipper to sales clerk.");
                }
            }
            else if (job.equals("salesClerk"))
            {
                System.out.println("Welcome to day " + day + "! Your current balance is $" + currentBalance);
                System.out.print("How many pieces of clothing would you like to flip today? (Please choose a # between 0-10 inclusive.): ");
                numClothes = myScannerObj.nextInt();
                boolean eventFinished = false;
                while (!eventFinished)
                {
                    try {
                        if ((numClothes >= 0) && (numClothes <= 10))
                        {
                            currentBalance += calcBurgerMoney(numClothes);
                            System.out.println("You've made $" + System.out.printf("%.2f", calcSalesClerkMoney(numClothes)));
                            System.out.println("Now your balance is $" + currentBalance);
                            System.out.println("Phew! You've finished for the day!");
                            eventFinished = true;
                        }
                    }
                    catch (InputMismatchException e ) {// We are simply gonna ask again
                        System.out.println("Error: " + e.getMessage()); }
                }
                if (currentBalance > 1450.00)
                {
                    job = "storeManager";
                    System.out.println("Congratulations! You've been promoted from sales clerk to store manager.");
                }
            }
            else if (job.equals("storeManager"))
            {
                System.out.println("Welcome to day " + day + "! Your current balance is $" + currentBalance);
                System.out.print("How many hours would you like to work today? (Please choose a # between 0-8 inclusive.): ");
                managerHours = myScannerObj.nextInt();
                boolean eventFinished = false;
                while (!eventFinished)
                {
                    try {
                        if ((managerHours >= 0) && (managerHours <= 8))
                        {
                            currentBalance += calcBurgerMoney(managerHours);
                            System.out.println("You've made $" + System.out.printf("%.2f", calcSalesClerkMoney(managerHours)));
                            System.out.println("Now your balance is $" + currentBalance);
                            System.out.println("Woo! Day done.");
                            eventFinished = true;
                        }
                    }
                    catch (InputMismatchException e ) {// We are simply gonna ask again
                        System.out.println("Error: " + e.getMessage()); }
                }
            }
        }

    }

    public static double calcBurgerMoney(int numBurgers)
    {
        double totalBurgerMoney = numBurgers * 1.00;
        return totalBurgerMoney;
    }

    public static double calcSalesClerkMoney(int numPiecesOfClothing)
    {
        double totalClothesMoney = numPiecesOfClothing * 10.00;
        return totalClothesMoney;
    }

    public static double calcManagerWage(double managerHoursWorked)
    {
        double totalManagerWage = managerHoursWorked * 30.00;
        return totalManagerWage;
    }





}
