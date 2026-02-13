package com.example.listycity;

/** This is a class that defines a City */
public class City implements Comparable<City>{
    private String city;
    private String province;
    City(String city, String province) {
        this.city = city;
        this.province = province;   }

    /**
     * Get the city name
     * @return The name of the city
     */
    String getCityName(){
        return this.city;   }

    /**
     * Get the province name
     * @return The name of the province
     */
    String getProvinceName(){
        return this.province;   }

    /**
     * Compare this city name to another city name
     * @return Negative if this city comes first alphabetically, positive if it comes after, 0 if equal
     */

    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     * Check if this city is equal to another object
     * @param obj The object to compare to
     * @return True if the cities have the same name and province, false otherwise
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        City other = (City) obj;
        return city.equals(other.city) && province.equals(other.province);
    }

    /**
     * Get the hash code for this city
     * @return The hash code based on city name and province
     */

    @Override
    public int hashCode() {
        return city.hashCode() + province.hashCode();
    }
}
