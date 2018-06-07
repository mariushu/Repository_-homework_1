package pl.stqa.ptf;

import com.buzzbuzhome.BBHLocation;
import com.buzzbuzhome.GeoIP;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void testMyIp() {
    BBHLocation userLocation = new GeoIP().getGeoIPSoap12().getUserLocation("31.182.251.230");
    assertEquals(userLocation.getCountryCode(), "PL");
  }

}
