package code;

import java.util.ResourceBundle;

import com.lapsa.kz.LocalizedElement;
import com.lapsa.kz.country.KZArea;
import com.lapsa.kz.country.KZCity;
import com.lapsa.kz.country.KZCityType;

public class KZCityDump {

    public static void main(String[] args) {
	dumpKZStruct();
	dumpByTypes();
    }

    private static void dumpKZStruct() {
	ResourceBundle res = ResourceBundle.getBundle(LocalizedElement.BUNDDLE_BASE_NAME);
	for (KZArea area : KZArea.values()) {
	    System.out.println(String.format("\n= %1$s %2$s =", area.name(),
		    res.getString(String.format("%1$s.%2$s", area.getClass().getName(), area.name()))));
	    for (KZCityType type : KZCityType.values()) {
		boolean typeNotPrinted = true;
		for (KZCity city : KZCity.values()) {
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
    }

    private static void dumpByTypes() {
	ResourceBundle res = ResourceBundle.getBundle(LocalizedElement.BUNDDLE_BASE_NAME);
	for (KZCityType type : KZCityType.values()) {
	    System.out.println(String.format("\n= %1$s %2$s =", type.name(),
		    res.getString(String.format("%1$s.%2$s", type.getClass().getName(), type.name()))));
	    for (KZArea area : KZArea.values()) {
		boolean areaNotPrinted = true;
		for (KZCity city : KZCity.values()) {
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
}
