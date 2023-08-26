import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForeignExchange {
    private static List<BookTrade> trades = new ArrayList<>(); //to store trade transactions
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to FX Trading !");
        //to execute main menu
        while (true) {
            System.out.println("\n1. Book Trade"); //to trade
            System.out.println("2. Print Trades"); //to print transactions
            System.out.println("3. Exit"); //exits from application
            System.out.print("Select an option (1/2/3) : ");

            String choice = scanner.nextLine();

            if (choice.matches("[1-3]+")){
                if (Integer.parseInt(choice)==1){
                    BookTrade bookTrade = new BookTrade();
                    if (bookTrade.bookTrade()) {
                        trades.add(bookTrade);
                    }
                }
                else if (Integer.parseInt(choice)==2) {
                    PrintTrades printTrades = new PrintTrades(trades);
                    printTrades.printTrades();
                }
                else if (Integer.parseInt(choice)==3) {
                    exitProgram();
                }
            }
            else {
                System.out.println("Invalid choice. Please select a valid option.\n");
            }
        }
    }


    //for exit operation
    private static void exitProgram() {
        System.out.println("\nDo you really want to exit : ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select an Option (1/2) : ");
        String choice = scanner.nextLine();

        if (choice.matches("[1-2]+")){
            if (Integer.parseInt(choice)==1){
                System.out.println("\nBye - have a good day!");
                System.exit(0);
            } else if (Integer.parseInt(choice)==2) {
                System.out.println("\nReturning to main menu.");
            }
        }
       else {
            System.out.println("\nInvalid choice. Returning to main menu.");
        }
    }
}
