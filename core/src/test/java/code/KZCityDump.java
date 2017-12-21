package code;

import java.util.ResourceBundle;

import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.KZCityType;

public class KZCityDump {

    public static void main(final String[] args) {
	dumpKZStruct();
	dumpByTypes();
    }

    private static void dumpKZStruct() {
	final ResourceBundle res = ResourceBundle.getBundle(KZArea.class.getCanonicalName());
	for (final KZArea area : KZArea.values()) {
	    System.out.println(String.format("\n= %1$s %2$s =", area.name(),
		    res.getString(String.format("%1$s.%2$s", area.getClass().getName(), area.name()))));
	    for (final KZCityType type : KZCityType.values()) {
		boolean typeNotPrinted = true;
		for (final KZCity city : KZCity.values())
		    if (city.getArea().equals(area) && city.getType().equals(type)) {
			if (typeNotPrinted) {
			    System.out.println(String.format("\n== %1$s %2$s ==", type.name(),
				    res.getString(String.format("%1$s.%2$s", type.getClass().getName(), type.name()))));
			    typeNotPrinted = false;
			}
			System.out.println(String.format("%1$s %2$s", city.name(),
				res.getString(String.format("%1$s.%2$s", city.getClass().getName(), city.name()))));
		    }

	    }
	}
    }

    private static void dumpByTypes() {
	final ResourceBundle res = ResourceBundle.getBundle(KZCityType.class.getCanonicalName());
	for (final KZCityType type : KZCityType.values()) {
	    System.out.println(String.format("\n= %1$s %2$s =", type.name(),
		    res.getString(String.format("%1$s.%2$s", type.getClass().getName(), type.name()))));
	    for (final KZArea area : KZArea.values()) {
		boolean areaNotPrinted = true;
		for (final KZCity city : KZCity.values())
		    if (city.getType().equals(type) && city.getArea().equals(area)) {
			if (areaNotPrinted) {
			    System.out.println(String.format("\n= %1$s %2$s =", area.name(),
				    res.getString(String.format("%1$s.%2$s", area.getClass().getName(), area.name()))));
			    areaNotPrinted = false;
			}
			System.out.println(String.format("%1$s %2$s", city.name(),
				res.getString(String.format("%1$s.%2$s", city.getClass().getName(), city.name()))));
		    }
	    }
	}
    }
}
