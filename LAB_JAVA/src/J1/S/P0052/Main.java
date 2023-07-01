package J1.S.P0052;

public class Main {

    // display menu
    private void DisplayMenu() {
        System.out.format("%35s\n", "MENU");
        System.out.println("==========================================================================");
        System.out.println("1. Input the information of 11 countries in Southeast Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries increasing with the country name");
        System.out.println("5. Exit");
        System.out.println("==========================================================================");
    }

    // select option
    private int SelectOption() {
        Inputter input = new Inputter();
        int option = input.InputOption(1, 5);
        return option;
    }

    public static void main(String[] args) {
        Main main = new Main();
        ManageEastAsiaCountries manage = new ManageEastAsiaCountries();
        // loop until exit program
        while (true) {
            // display menu
            main.DisplayMenu();
            // select option
            int option = main.SelectOption();
            switch (option) {
                case 1://add country information
                    manage.addCountryInformation();
                    break;
                case 2: //get recently information input
                    manage.getRecentlyEnteredInformation();
                    break;
                case 3:  // search information country by name
                    manage.searchInformationByName();
                    break;
                case 4://sort information in ascending order
                    manage.sortInformationByAscendingOrder();
                    break;
                case 5:// exit program
                    return;
            }
        }
    }

}
