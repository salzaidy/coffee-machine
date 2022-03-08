
import java.util.Scanner;

public class CoffeeMachine {

    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {

        customerChoices();


    }

    // still in progress
    private static void customerChoices(){


//        do {

//            options(choice);
//        }
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String choice = scanner.nextLine();

            if ("exit".equalsIgnoreCase(choice)) {
                break;
            } else {
                options(choice);
            }

//            System.out.println("Write action (buy, fill, take, remaining, exit):");
//            choice = scanner.nextLine();
        }


    }

    private static void options(String userOption){

        switch (userOption) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillUpCoffeeMachine();
                break;
            case "take":
                withdrawalMoney();
                break;
            case "remaining":
                coffeeMachineStatus();
                break;
        }
    }


    private static void buyCoffee(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeType = scanner.nextLine();
//        boolean status = isEnough();

        switch (coffeeType) {
            case "1":
                espresso();
                //water -= 250; beans-= 16; cups -= 1; money += 4;
                break;
            case "2":
                latte();
                //water -= 350; milk -= 75; beans -= 20; cups -= 1; money += 7;
                break;
            case "3":
                cappuccino();
                //water -= 200; milk -= 100; beans -= 12; cups -= 1; money += 6;
                break;
//            case "back":
            default:
                System.out.println(" ");
//                customerChoices();
                break;
        }

    }

    private static void espresso(){

        // 250 ml of water and 16 g of coffee beans
        int waterAmount = 250;
        int beanAmount = 16;

        int waterTotal = water - waterAmount;
        int beansTotal = beans - beanAmount;

        if ((waterTotal >= 0 ) && (beansTotal >= 0) && (cups >= 1)){
            System.out.println("I have enough resources, making you a coffee!\n");
            water -= waterAmount; beans-= beanAmount; cups -= 1; money += 4;
        } else if(waterTotal < 0) {
            System.out.println("Sorry, not enough water!\n");
        } else if(beansTotal < 0) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!\n");
        }
    }

    private static void latte(){

        // 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7
        int waterAmount = 350;
        int milkAmount = 75;
        int beanAmount = 20;

        int waterTotal = water - waterAmount;
        int milkTotal = milk - milkAmount;
        int beansTotal = beans - beanAmount;

        if ((waterTotal >= 0 ) && (milkTotal >= 0) && (beansTotal >= 0) && (cups >= 1)){
            System.out.println("I have enough resources, making you a coffee!\n");
            water -= waterAmount; milk-= milkAmount; beans-= beanAmount; cups -= 1; money += 7;
        } else if(waterTotal < 0) {
            System.out.println("Sorry, not enough water!\n");
        } else if(milkTotal < 0) {
            System.out.println("Sorry, not enough milk!\n");
        } else if(beansTotal < 0) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!\n");
        }
    }

    private static void cappuccino(){

        // 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.
        int waterAmount = 200;
        int milkAmount = 100;
        int beanAmount = 12;

        int waterTotal = water - waterAmount;
        int milkTotal = milk - milkAmount;
        int beansTotal = beans - beanAmount;

        if ((waterTotal >= 0 ) && (milkTotal >= 0) && (beansTotal >= 0) && (cups >= 1)){
            System.out.println("I have enough resources, making you a coffee!\n");
            water -= waterAmount; milk-= milkAmount; beans-= beanAmount; cups -= 1; money += 6;
        } else if(waterTotal < 0) {
            System.out.println("Sorry, not enough water!\n");
        } else if(milkTotal < 0) {
            System.out.println("Sorry, not enough milk!\n");
        } else if(beansTotal < 0) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!\n");
        }
    }


    private static void fillUpCoffeeMachine(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWrite how many ml of water you want to add:");
        int addedWater = scanner.nextInt();
        water += addedWater;

        System.out.println("Write how many ml of milk you want to add:");
        int addedMilk = scanner.nextInt();
        milk += addedMilk;

        System.out.println("Write how many grams of coffee beans you want to add: ");
        int extraBeans = scanner.nextInt();
        beans += extraBeans;

        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addedCups = scanner.nextInt();
        cups += addedCups;

        System.out.println(" ");
    }


    private static void withdrawalMoney() {
        System.out.printf("\nI gave you $%d\n", money);
        System.out.println(" ");
        money -= money;
    }


    private static void coffeeMachineStatus() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", beans);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n", money);
    }


}
