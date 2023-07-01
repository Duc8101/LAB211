package J1.S.P0001;

public class Main {

    public static void main(String[] args) {
        ArraySorting sort = new ArraySorting();
        //enter number of array
        int number = sort.EnterNumberOfArray();
        // generate random  element
        int array[] = sort.GenerateRandomElement(number);
//        int array[] = {5, 1, 12, -5, 16};
        //display array before sort
        sort.DisplayArray(array, "Unsorted array:  [", "\tunsorted");
        //  use bubble sort to sort array
        sort.BubbleSort(array);
        //  display array after sort
        sort.DisplayArray(array, "\nSorted array:  [", "\tsorted");
    }

}
