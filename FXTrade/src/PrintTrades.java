import java.util.List;
class PrintTrades {
    private List<BookTrade> trades;
    protected PrintTrades(List<BookTrade> trades) {
        this.trades=trades;
    }

    //to print trade transactions
    public void printTrades() {
        System.out.println("\nTradeNo\tCurrencyPair\tCustomerName\tAmount\t\tRate");
        for (int i = 0; i < trades.size(); i++) {
            BookTrade trade = trades.get(i);
            System.out.println((i + 1) + "\t\t" + trade.getCurrencyPair() + "\t\t\t" +
                    trade.getCustomerName() + "\t\t\tINR " + formatAmount(trade.getAmount()) + "\t\t" +
                    formatAmount(trade.getUsdInrRate()));
        }
    }

    //to format amount in two decimal values
    private String formatAmount(double amount) {
        return String.format("%.2f", amount);
    }
}