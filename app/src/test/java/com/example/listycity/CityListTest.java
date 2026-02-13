package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CityListTest {

    /**Creates a CityList with one city already in it*/

    private CityList mockCityList(){
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**Creates a single City object*/

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(mockCity()));
        City newCity = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(newCity));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        cityList.delete(mockCity());
        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.hasCity(mockCity()));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        City city = new City("Calgary", "Alberta");
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.countCities());
        City city = new City("Vancouver", "British Columbia");
        cityList.add(city);
        assertEquals(2, cityList.countCities());
        cityList.delete(city);
        assertEquals(1, cityList.countCities());
    }
    }




