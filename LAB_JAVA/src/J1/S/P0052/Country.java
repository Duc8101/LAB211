package J1.S.P0052;

public class Country extends EastAsiaCountries implements Comparable<Country> {

    private String countryTerrain;

    public Country() {
    }

    public Country(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public Country(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    // display country information
    @Override
    void display() {
        System.out.format("%-10s%-25s%-20s%-25s\n", this.countryCode,
                this.countryName, this.totalArea, this.countryTerrain);
        System.out.println();
    }

    // sort country order by country name ASC
    @Override
    public int compareTo(Country o) {
        return this.countryName.compareTo(o.countryName);
    }
}
