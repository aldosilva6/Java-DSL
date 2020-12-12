package modernajavaaction.com.DSL.after;

import modernjavaaction.com.DSL.before.Order;

public class TestOrderBuilderMethod {

	public static void main(String[] args) {
		Order order = MethodChainingOrderBuilder.forCustomer("BigBank").buy(80).stock("IBM").on("NYSE").at(125.00)
				.sell(50).stock("GOOGLE").on("NASDAQ").at(375.00).end();

		double value = new TaxCalculator().withTaxRegioanl().withSurcharge().withTaxGeneral().calculate(order);

		System.out.println(order);

		System.out.println("Value: " + value);
	}

}
