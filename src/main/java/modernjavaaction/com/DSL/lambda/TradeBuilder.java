package modernjavaaction.com.DSL.lambda;

import java.util.function.Consumer;

import modernjavaaction.com.DSL.before.Trade;

public class TradeBuilder {

	private Trade trade = new Trade();

	public void quantity(int quantity) {
		trade.setQuantity(quantity);
	}

	public void price(double price) {
		trade.setPrice(price);
	}

	public void type(Trade.Type type) {
		trade.setType(type);
	}

	public void stock(Consumer<StockBuilder> consumer) {
		StockBuilder builder = new StockBuilder();
		consumer.accept(builder);
		trade.setStock(builder.getStock());
	}

	public Trade getTrade() {
		return trade;
	}

}
