package modernjavaaction.com.DSL.lambda;

import java.util.function.Consumer;

import modernjavaaction.com.DSL.before.Order;
import modernjavaaction.com.DSL.before.Trade;

public class LambdaOrderBuilder {

	private Order order = new Order();

	public static Order order(Consumer<LambdaOrderBuilder> consumer) {
		LambdaOrderBuilder builder = new LambdaOrderBuilder();
		consumer.accept(builder);
		return builder.order;
	}

	public void forCustomer(String customer) {
		order.setCustomer(customer);
	}

	public void sell(Consumer<TradeBuilder> consumer) {
		trader(consumer, Trade.Type.SELL);
	}

	public void buy(Consumer<TradeBuilder> consumer) {
		trader(consumer, Trade.Type.BUY);
	}

	private void trader(Consumer<TradeBuilder> consumer, Trade.Type type) {
		TradeBuilder builder = new TradeBuilder();
		builder.type(type);
		consumer.accept(builder);
		order.addTrade(builder.getTrade());
	}

}
