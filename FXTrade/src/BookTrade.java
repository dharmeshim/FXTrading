import java.util.Scanner;

public class BookTrade {
    private double usdInrRate = 66.00;
    private final Scanner scanner = new Scanner(System.in);
    private String customerName;
    private String currencyPair;
    private double amount;
    protected void setUsdInrRate(double usdInrRate) {
        this.usdInrRate = usdInrRate;
    }

    //to execute trade
    protected boolean bookTrade() {

        takeName();
        takeCurrencyPair();
        takeAmount();
        takeRate();
        return takeConfirmation();
    }

    //to get customer name
    private void takeName(){

        System.out.print("\nEnter customer Name: ");
        customerName = scanner.nextLine();
        if (!customerName.matches("^[a-zA-Z ]+$")) {
            System.out.println("Invalid customer name. Please enter a valid name containing only letters.");
           takeName();
        }
    }

    //to get currency pair
    private void takeCurrencyPair(){

        System.out.println("\nChoose Currency Pair: ");
        System.out.println("1. USDINR");
        System.out.println("2. INRUSD");
        System.out.print("Select an option (1/2) : ");

        String choice = scanner.nextLine();
        if (choice.matches("[1-2]+")){
            if (Integer.parseInt(choice)==1){
                currencyPair="USDINR";
            }
            else if (Integer.parseInt(choice)==2){
                currencyPair="INRUSD";
            }
        }
        else{
            System.out.println("Invalid choice. Please select a valid option.");
            takeCurrencyPair();
        }
        //Only USDINR for now
        if (!currencyPair.equals("USDINR")) {
            System.out.println("Invalid currency pair.(For now) Only USDINR is supported.");
            takeCurrencyPair();
        }
    }

    //to get transaction amount
    private void takeAmount(){
        System.out.print("\nEnter amount to transfer: ");

        String amountInput = scanner.nextLine();
        if (!amountInput.matches("^[0-9]+(\\.[0-9]*)?$")) {
            System.out.println("Invalid amount. Please check the amount you entered.\n");
            takeAmount();
        }
        else {
            amount = Double.parseDouble(amountInput);
        }
    }

    //to print rate if user wants
    private void takeRate(){
        this.amount = amount * usdInrRate;
        System.out.println("\nDo you want to get Rate : ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select an option (1/2) : ");

        String choice = scanner.nextLine();

        if (choice.matches("[1-2]+")){
            if (Integer.parseInt(choice)==1) {
                System.out.println("You are transferring INR " + formatAmount(amount) + " to " + customerName + " (Rate is " + usdInrRate + ")");
            }
        }
        else{
            System.out.println("Invalid Input");
            takeRate();
        }
    }

    //to confirm trade transaction from user
    private boolean takeConfirmation(){

        System.out.println("\nBook/Cancel this trade? : ");
        System.out.println("1. Book");
        System.out.println("2. Cancel");
        System.out.print("Select an option (1/2) : ");

        String choice = scanner.nextLine();

        if (choice.matches("[1-2]+")){
            if (Integer.parseInt(choice) ==1) {
                System.out.println("\nTrade for " + currencyPair + " has been booked with rate " + usdInrRate + ", The amount of Rs " + formatAmount(amount) + " will be transferred in 2 working days to " + customerName + ".\n");
                return true;
            }
            else if (Integer.parseInt(choice) ==2) {
                System.out.println("Trade is Canceled.");
                return false;
            }
        }
        else{
            System.out.println("Invalid Input");
            takeConfirmation();
        }
        return false;
    }

    private String formatAmount(double amount) {
        return String.format("%.2f", amount);
    }

    public double getUsdInrRate() {
        return usdInrRate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCurrencyPair() {
        return currencyPair;
    }

    public double getAmount() {
        return amount;
    }
}
