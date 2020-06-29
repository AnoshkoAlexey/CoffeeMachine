package machine;

import java.util.Scanner;

public class CoffeeMachine {
    
    int totalWater;
    int totalMilk;
    int totalBeans;
    int totalCups;
    int totalMoney;
     
    public static void main(String[] args) {
        
        new CoffeeMachine().go();
       /* 
        final int waterPerCup = 200;
        final int milkPerCup = 50;
        final int beansPerCup = 15;
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int totalWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int totalMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int totalBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int wantedCups = scanner.nextInt();
        
        int maxWaterCup = totalWater / waterPerCup;
        int maxMilkCup = totalMilk / milkPerCup;
        int maxBeanCup = totalBeans / beansPerCup;
        
        int totalCups = min(maxBeanCup, min(maxWaterCup, maxMilkCup));
        
        if (totalCups == wantedCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (totalCups > wantedCups) {
            System.out.format("Yes, I can make that amount of coffee (and even %d more than that)\n", 
                              totalCups - wantedCups);
        } else {
            System.out.format("No, I can make only %d cup(s) of coffee\n", totalCups);
        }
        
        /*System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int numberCups = scanner.nextInt();
        System.out.format("For %d cups of coffee you will need:\n", numberCups);
        System.out.format("%d ml of water\n", numberCups * waterPerCup);
        System.out.format("%d ml of milk\n", numberCups * milkPerCup);
        System.out.format("%d g of coffee beans\n", numberCups * beansPerCup);*/   
        
    }
    
    static int min(int a, int b) {
        return a < b ? a : b;
    }
    
    
    public void go() {
        
        totalWater = 400;
        totalMilk = 540;
        totalBeans = 120;
        totalCups = 9;
        totalMoney = 550; 

        String choice;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");

            choice = scanner.nextLine();

            switch (choice) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    remaining();
                    break;
            }
        } while (!"exit".equals(choice));
    }
    
    void buy() {
        
        int water = 0;
        int milk = 0;
        int beans = 0;
        int price = 0;
        
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                water = 250;
                milk = 0;
                beans = 16;
                price = 4;
                break;
            case "2":
                water = 350;
                milk = 75;
                beans = 20;
                price = 7;
                break;
            case "3":
                water = 200;
                milk = 100;
                beans = 12;
                price = 6;
                break;
            case "back":
                return;
        }

        if (totalWater < water)
            System.out.println("Sorry, not enough water");
        else if (totalMilk < milk)
            System.out.println("Sorry, not enough milk");
        else if (totalBeans < beans)
            System.out.println("Sorry, not enough beans");
        else if (totalCups == 0)
            System.out.println("Sorry, not enough cups");
        else {
            totalWater -= water;
            totalMilk -= milk;
            totalBeans -= beans;
            totalMoney += price;
            totalCups--;
            System.out.println("I have enough resources, making you a coffee!");
        }
    
    }
    
    void fill() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int beans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = scanner.nextInt();
        
        totalWater += water;
        totalMilk += milk;
        totalBeans += beans;
        totalCups += cups;
        
    }
    
    void take() {
        
        System.out.format("I gave you $%d\n", totalMoney);
        totalMoney = 0;
    }
    
    void remaining() {
        System.out.println("\nThe coffee machine has:\n");
        System.out.format("%d of water\n", totalWater);
        System.out.format("%d of milk\n", totalMilk);
        System.out.format("%d of coffee beans\n", totalBeans);
        System.out.format("%d of disposable cups\n", totalCups);
        System.out.format("%d of money\n", totalMoney);
    }
}

enum machineState {
    CHOOSING_AN_ACTION,
    BUILD
}