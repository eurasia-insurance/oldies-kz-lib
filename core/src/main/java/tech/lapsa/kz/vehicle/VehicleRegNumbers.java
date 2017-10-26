package tech.lapsa.kz.vehicle;

public final class VehicleRegNumbers {

    private VehicleRegNumbers() {
    }

    public static boolean valid(final String value) {
	return VehicleRegNumber.of(value).isValid();
    }

    public static boolean nonValid(final String value) {
	return !valid(value);
    }

    public static String requireValid(final String value) {
	return requireValid(value, null);
    }

    public static String requireValid(final String value, final String par) {
	VehicleRegNumber.of(value).requireValid();
	return value;
    }
}
