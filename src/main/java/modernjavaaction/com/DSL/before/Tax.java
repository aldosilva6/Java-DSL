package modernjavaaction.com.DSL.before;

public class Tax {

	public static double regional(double value) {
		return value * 1.1;
	}

	public static double general(double value) {
		return value * 1.3;
	}

	public static double surcharge(double value) {
		return value * 1.5;
	}

	public static double calculate(Order order, boolean useRegional, boolean useGeneral, boolean useSurcharge) {
		double value = order.getValue();

		if (useRegional)
			value = regional(value);
		if (useGeneral)
			value = general(value);
		if (useSurcharge)
			value = surcharge(value);

		return value;
	}
}
