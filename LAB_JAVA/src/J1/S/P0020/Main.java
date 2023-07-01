package J1.S.P0020;

public class Main {

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        //enter number of array
        int number = sort.EnterNumberOfArray();
        // input array
        int array[] = sort.InputArray(number);
        //display array before sort
        sort.DisplayArray(array, "Unsorted array:  [");
        //  use bubblesort to sort array
        sort.SelectionSort(array);
        //  display array after sort
        sort.DisplayArray(array, "\nSorted array:  [");
    }
}
