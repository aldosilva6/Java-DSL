package modernjavaaction.com.DSL.lambda;

import modernjavaaction.com.DSL.before.Order;
import modernjavaaction.com.DSL.before.Tax;

public class TestLambdaBuilder {

	public static void main(String[] args) {
		Order order = LambdaOrderBuilder.order(o -> {
			o.forCustomer("BigBank");
			o.buy(t -> {
				t.quantity(80);
				t.price(125.00);
				t.stock(s -> {
					s.symbol("IBM");
					s.market("NYSE");
				});
			});
			o.sell(t -> {
				t.quantity(50);
				t.price(375.00);
				t.stock(s -> {
					s.symbol("GOOGLE");
					s.market("NASDAQ");
				});
			});
		});

		double value = new TaxCalculator().with(Tax::regional).with(Tax::surcharge).calculate(order);

		System.out.println(order);

		System.out.println("Value: " + value);
	}

}
