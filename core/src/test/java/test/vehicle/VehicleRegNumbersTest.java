package test.vehicle;

import static org.junit.Assert.*;

import org.junit.Test;

import com.lapsa.kz.country.KZArea;

import tech.lapsa.kz.vehicle.VehicleRegNumber;

public class VehicleRegNumbersTest {

    @Test
    public void simpleTest1() {
	final VehicleRegNumber vrn1 = VehicleRegNumber.of("237blm01");
	assertNotNull(vrn1);
	assertTrue(vrn1.optionalArea().isPresent());
	assertEquals(vrn1.getArea(), KZArea.GAST);
    }

    public static void main(final String[] args) {
	{
	    final VehicleRegNumber vrn1 = VehicleRegNumber.of("237blm01");
	    System.out.println(vrn1);
	    final VehicleRegNumber vrn2 = VehicleRegNumber.of("23701blm");
	    System.out.println(vrn2);
	}
	{
	    final VehicleRegNumber vrn1 = VehicleRegNumber.of("249anm01");
	    System.out.println(vrn1);
	    final VehicleRegNumber vrn2 = VehicleRegNumber.of("24901anm");
	    System.out.println(vrn2);
	}
	{
	    final VehicleRegNumber vrn = VehicleRegNumber.of("389bk01");
	    System.out.println(vrn);
	}
	{
	    final VehicleRegNumber vrn = VehicleRegNumber.of("24901an");
	    System.out.println(vrn);
	}
	{
	    final VehicleRegNumber vrn1 = VehicleRegNumber.of("2401kb");
	    System.out.println(vrn1);
	    final VehicleRegNumber vrn2 = VehicleRegNumber.of("24kb01");
	    System.out.println(vrn2);
	}
	{
	    final VehicleRegNumber vrn1 = VehicleRegNumber.of("anm0124");
	    System.out.println(vrn1);
	    final VehicleRegNumber vrn2 = VehicleRegNumber.of("anm2401");
	    System.out.println(vrn2);
	}
	{
	    final VehicleRegNumber vrn1 = VehicleRegNumber.of("A105YRO");
	    System.out.println(vrn1);
	    final VehicleRegNumber vrn2 = VehicleRegNumber.of("A105YR");
	    System.out.println(vrn2);
	}
    }
}
