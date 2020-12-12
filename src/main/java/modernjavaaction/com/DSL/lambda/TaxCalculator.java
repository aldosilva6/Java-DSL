package modernjavaaction.com.DSL.lambda;

import java.util.function.DoubleUnaryOperator;

import modernjavaaction.com.DSL.before.Order;

public class TaxCalculator {

	public DoubleUnaryOperator taxFunction = d -> d;

	public TaxCalculator with(DoubleUnaryOperator f) {
		taxFunction = taxFunction.andThen(f);
		return this;
	}

	public double calculate(Order order) {
		return taxFunction.applyAsDouble(order.getValue());
	}

}
