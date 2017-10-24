package test.vehicle;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

import com.lapsa.kz.country.KZArea;

import tech.lapsa.kz.vehicle.VehicleRegNumber;

public class VehicleRegNumbersTest {

    @Test
    public void simpleTest1() {
	Optional<VehicleRegNumber> vrn1 = VehicleRegNumber.parse("237blm01");
	assertNotNull(vrn1);
	assertTrue(vrn1.isPresent());
	assertTrue(vrn1.get().optionalArea().isPresent());
	assertEquals(vrn1.get().optionalArea().get(), KZArea.GAST);
    }

    public static void main(String[] args) {
	{
	    VehicleRegNumber vrn1 = VehicleRegNumber.parse("237blm01").get();
	    System.out.println(vrn1);
	    VehicleRegNumber vrn2 = VehicleRegNumber.parse("23701blm").get();
	    System.out.println(vrn2);
	}
	{
	    VehicleRegNumber vrn1 = VehicleRegNumber.parse("249anm01").get();
	    System.out.println(vrn1);
	    VehicleRegNumber vrn2 = VehicleRegNumber.parse("24901anm").get();
	    System.out.println(vrn2);
	}
	{
	    VehicleRegNumber vrn = VehicleRegNumber.parse("389bk01").get();
	    System.out.println(vrn);
	}
	{
	    VehicleRegNumber vrn = VehicleRegNumber.parse("24901an").get();
	    System.out.println(vrn);
	}
	{
	    VehicleRegNumber vrn1 = VehicleRegNumber.parse("2401kb").get();
	    System.out.println(vrn1);
	    VehicleRegNumber vrn2 = VehicleRegNumber.parse("24kb01").get();
	    System.out.println(vrn2);
	}
	{
	    VehicleRegNumber vrn1 = VehicleRegNumber.parse("anm0124").get();
	    System.out.println(vrn1);
	    VehicleRegNumber vrn2 = VehicleRegNumber.parse("anm2401").get();
	    System.out.println(vrn2);
	}
	{
	    VehicleRegNumber vrn1 = VehicleRegNumber.parse("A105YRO").get();
	    System.out.println(vrn1);
	    VehicleRegNumber vrn2 = VehicleRegNumber.parse("A105YR").get();
	    System.out.println(vrn2);
	}
    }
}
