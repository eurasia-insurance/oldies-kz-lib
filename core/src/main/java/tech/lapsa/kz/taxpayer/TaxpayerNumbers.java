package tech.lapsa.kz.taxpayer;

public final class TaxpayerNumbers {

    private TaxpayerNumbers() {
    }

    public static boolean valid(final String value) {
	return TaxpayerNumber.of(value).isValid();
    }

    public static boolean nonValid(final String value) {
	return !valid(value);
    }

    public static String requireValid(final String value) {
	return requireValid(value, null);
    }

    public static String requireValid(final String value, final String par) {
	TaxpayerNumber.of(value).requireValid();
	return value;
    }
}
