package modernjavaaction.com.DSL.lambda;

import modernjavaaction.com.DSL.before.Stock;

public class StockBuilder {

	private Stock stock = new Stock();

	public void symbol(String symbol) {
		stock.setSymbol(symbol);
	}

	public void market(String market) {
		stock.setMarket(market);
	}

	public Stock getStock() {
		return stock;
	}

}
