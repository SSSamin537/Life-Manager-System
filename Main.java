import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static LifeManagerSystem system = new LifeManagerSystem();

    private static void printMenu(){
        System.out.println("\n==== MAIN MENU ====");
        System.out.println("1. Add a Goal");
        System.out.println("2. Add a Utility Bill");
        System.out.println("3. Add an Activity (Habit/Event)");
        System.out.println("4. View My Life Dashboard");
        System.out.println("5. Get AI Smart Suggestions");
        System.out.println("0. Exit");
        System.out.print("Enter Choice: ");
    }

    private static int getIntInput() {
        int userInput = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline
        return userInput;
    }

    private static void handleAddGoal(){
        System.out.println("\n--- Add New Goal ---");
        System.out.print("Enter Goal Name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter Category (Financial/Health): ");
        String cat = sc.nextLine();
        
        // Defaulting to false (not achieved)
        Goal goal = new Goal(name, cat, false);
        system.addGoal(goal);
    }

    private static void handleAddBill(){
        try{
            System.out.println("\n--- Add Utility Bill ---");
            System.out.print("Enter Type (Electricity/Water): ");
            String utilityType = sc.nextLine();

            System.out.print("Enter Usage Amount: ");
            double usageAmount = sc.nextDouble();

            System.out.print("Enter Limit: ");
            double usageLimit = sc.nextDouble();
            sc.nextLine(); // Consume newline

            if(usageAmount < 0 || usageLimit < 0){
                throw new InvalidAmountException("Bills Cannot be Negative!");
            }

            UtilityBill utilityBill = new UtilityBill(utilityType, usageAmount, usageLimit);
            system.addUtilityBill(utilityBill);
        }
        catch(InvalidAmountException exc){
            System.out.println("Input Error: " + exc.getMessage());
        }
        catch(Exception exc){
            System.out.println("Error: Please provide valid inputs");
            sc.nextLine();
        }
    }

    private static void handleAddActivity() {
        System.out.println("\n--- Add Activity ---");
        System.out.println("1. Community Event");
        System.out.println("2. Habit");
        System.out.print("Type: ");
        int type = getIntInput();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        if (type == 1) {
            System.out.print("Impact Type (Environment/Social): ");
            String impact = sc.nextLine();
            system.addActivity(new CommunityEvent(title, date, impact));
        } else {
            // Default habit to not completed
            system.addActivity(new Habit(title, date, false));
        }
    }
    public static void main(String[] args){
        clearScreen();
        System.out.println("Welcome To My Life Manager!");
        while (true) {
            printMenu();
            
            try {
                // Get the user's choice
                int choice = getIntInput();
                
                // Validate choice (Custom Exception Requirement!)
                if (choice < 0 || choice > 5) {
                    throw new MenuOptionException("Please select 0-5 only.");
                }

                // 4. Handle the Choice
                switch (choice) {
                    case 1:
                        handleAddGoal();
                        promptEnterKey();
                        clearScreen(); 
                        break;
                    case 2:
                        handleAddBill();
                        promptEnterKey();
                        clearScreen();
                        break;
                    case 3:
                        handleAddActivity();
                        promptEnterKey();
                        clearScreen();
                        break;
                    case 4:
                        system.printEverything();
                        promptEnterKey();
                        clearScreen();
                        break;
                    case 5:
                        system.generateSmartSuggestions();
                        promptEnterKey();
                        clearScreen();
                        break;
                    case 0: 
                        System.out.println("Goodbye!"); 
                        return; // Exits the app
                }
            } catch (MenuOptionException e) {
                System.out.println("Error: " + e.getMessage());
                promptEnterKey();
                clearScreen();
            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                sc.nextLine(); // Clear the bad input from scanner
                promptEnterKey();
                clearScreen();
            }
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void promptEnterKey() {
        System.out.println("\nPress \"ENTER\" to continue...");
        sc.nextLine(); // Waits for user to press Enter
    }
}
