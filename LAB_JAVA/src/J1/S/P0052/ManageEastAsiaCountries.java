package J1.S.P0052;

import java.util.*;

public class ManageEastAsiaCountries {

    private final List<Country> list = new ArrayList<>();
    private final Inputter input = new Inputter();

    public ManageEastAsiaCountries() {

    }

    // add country
    void addCountryInformation() {
        String code = input.InputStrNotEmpty("Enter code of country: ", "Code");
        // if code exist in list
        if (isExist(code)) {
            System.err.println("Code exist");
        } else {
            String name = input.InputName("Enter name of country: ");
            Country country = getCountry(name);
            // if country not exist in list
            if (country == null) {
                float TotalArea = input.InputTotalArea();
                String terrain = input.InputStrNotEmpty("Enter terrain of country: ", "Terrain");
                country = new Country(code, name, TotalArea, terrain);
                list.add(country);
            } else {
                System.err.println("Name exist");
            }

        }

    }

    // check code exist 
    private boolean isExist(String code) {
        // loop for traverse through list
        for (Country country : list) {
            // if code  exist in list
            if (code.equalsIgnoreCase(country.countryCode)) {
                return true;
            }
        }
        return false;
    }

    // get recently information input
    void getRecentlyEnteredInformation() {
        System.out.format("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        // loop for traverse through list 
        for (Country country : list) {
            country.display();
        }
    }

    // get country found by name
    private Country getCountry(String name) {
        // loop for traverse through list country
        for (Country country : list) {
            // if country name exist in list
            if (name.equalsIgnoreCase(country.countryName)) {
                return country;
            }
        }
        return null;
    }

    // search information country by name
    void searchInformationByName() {
        // if list empty
        if (list.isEmpty()) {
            System.err.println("List empty");
        } else {
            String name = input.InputName("Enter the name you want to search for: ");
            Country country = getCountry(name);
            // if name input not exist in list
            if (country == null) {
                System.err.println("Not Found name");
            } else {
                System.out.format("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
                country.display();
            }
        }
    }

    // sort information in ascending order
    void sortInformationByAscendingOrder() {
        Collections.sort(list);
        System.out.format("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        // loop for traverse through list all countries
        for (Country country : list) {
            country.display();
        }
    }

}
