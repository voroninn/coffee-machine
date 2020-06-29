package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final Scanner scanner = new Scanner(System.in);
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        selectAction();
    }

    public static void printMachineState() {
        System.out.println("");
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        selectAction();
    }

    public static void selectAction() {
        System.out.println("");
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        switch (scanner.next()) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeMoney();
                break;
            case "remaining":
                printMachineState();
                break;
            case "exit":
                break;
            default:
                System.out.println("Unknown action");
                selectAction();
        }
    }

    public static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (scanner.next()) {
            case "1":
                if (checkResources(250, 0, 16)) {
                    System.out.println("I have enough resources, making you a coffee!");
                    water -= 250;
                    beans -= 16;
                    cups--;
                    money += 4;
                }
                break;
            case "2":
                if (checkResources(350, 75, 20)) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups--;
                    money += 7;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "3":
                if (checkResources(200, 100, 12)) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups--;
                    money += 6;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "back":
                break;
            default:
                System.out.println("Unknown type of coffee");
                buyCoffee();
        }
        selectAction();
    }

    public static void fillMachine() {
        System.out.println("");
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
        selectAction();
    }

    public static void takeMoney() {
        System.out.println("");
        System.out.println("I gave you $" + money);
        money = 0;
        selectAction();
    }

    public static boolean checkResources(int waterNeeded, int milkNeeded, int beansNeeded) {
        if (water - waterNeeded < 0) {
            System.out.println("Sorry, not enough water!");
        }
        if (milk - milkNeeded < 0) {
            System.out.println("Sorry, not enough milk!");
        }
        if (beans - beansNeeded < 0) {
            System.out.println("Sorry, not enough coffee beans!");
        }
        if (cups - 1 < 0) {
            System.out.println("Sorry, not enough cups!");
        }
        return water - waterNeeded >= 0 && milk - milkNeeded >= 0 && beans - beansNeeded >= 0 && cups - 1 >= 0;
    }
}
