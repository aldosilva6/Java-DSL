package modernajavaaction.com.DSL.after;

import modernjavaaction.com.DSL.before.Order;
import modernjavaaction.com.DSL.before.Tax;

public class TaxCalculator {

	private boolean useRegional;
	private boolean useGeneral;
	private boolean useSurcharge;

	public TaxCalculator withTaxRegioanl() {
		useRegional = true;
		return this;
	}

	public TaxCalculator withTaxGeneral() {
		useGeneral = true;
		return this;
	}

	public TaxCalculator withSurcharge() {
		useSurcharge = true;
		return this;
	}

	public double calculate(Order order) {
		return Tax.calculate(order, useRegional, useGeneral, useSurcharge);
	}
}
