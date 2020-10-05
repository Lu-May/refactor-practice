package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 * 
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		// print headers
		output.append(getHeadler());

		// print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
//        output.append(order.getCustomerLoyaltyNumber());

		// prints lineItems
		printsLineItems(output);
		return output.toString();
	}

	private void printsLineItems(StringBuilder output) {
		double totSalesTx = 0d;
		double tot = 0d;
		for (LineItem lineItem : order.getLineItems()) {
			lineItemsFormat(output, lineItem);

			// calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * getDouble();
            totSalesTx += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            tot += lineItem.totalAmount() + salesTax;
		}
		printTotSalesTxAndTot(output, totSalesTx, tot);

	}

	private void printTotSalesTxAndTot(StringBuilder output, double totSalesTx, double tot) {
		// prints the state tax
		output.append("Sales Tax").append('\t').append(totSalesTx);

		// print total amount
		output.append("Total Amount").append('\t').append(tot);
	}

	private double getDouble() {
		return .10;
	}

	private void lineItemsFormat(StringBuilder output, LineItem lineItem) {
		output.append(lineItem.getDescription());
		output.append('\t');
		output.append(lineItem.getPrice());
		output.append('\t');
		output.append(lineItem.getQuantity());
		output.append('\t');
		output.append(lineItem.totalAmount());
		output.append('\n');
	}

	private String getHeadler() {
		return "======Printing Orders======\n";
	}
}