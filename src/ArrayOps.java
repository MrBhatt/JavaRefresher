import java.util.Arrays;

import static util.DisplayUtil.addDisplaySpace;

public class ArrayOps {

    public static void main(String[] args) {
        arrayOperations();
    }

    private static void arrayOperations() {

        // -------------------------
        // Array characteristics:
        // -------------------------
        // TypeSafe (You define the type of items the array can hold during initialization itself)
        // Type could be a primitive or a reference to an object
        // Internally implemented as an object (so every array variable is actually a reference to an array object)
        // Fixed size (You provide the size during initialization). The length property points to the capacity of the array
        // Array will occupy space as per its defined size (not by the number of elements in it)
        // Have dimension (one or more). Dimensions are represented by a pair of square brackets. Single dimension array is a linear data structure
        // Array elements are referenced by an index
        // Fills up the element spaces with default values, when values are not provided during initialization
        // example: all elements of a integer array have a value of 0, and all String or other object reference type elements are marked as "null"

        // 1. initialize array

        // 1.1 initialize an single dimension EMPTY array of integers (length of the array as 10)
        int[] integerArray = new int[10];

        // since it is an array of ints only ints values can be provided as its elements .
        // Assigning any other type of element will lead to IncompatibleTypesException
        // AT THIS STAGE: all elements are filled with default value for int (0)

        // 1.2 initialize an single dimension NON-EMPTY integer array (no need to provide the length)
        int[] integerNONEMPTYArray = new int[] {1,2,3,4,5};

        // AT THIS STAGE: a integer array of 5 elements (with their respective values) is instantiated
        // There is a simplified version without the "new" keyword, see String array example below

        // 1.3 an single dimension empty String array with no elements
        String[] employeeNamesArray = new String[10];
        // AT THIS STAGE: all elements are filled with default value for references (null)

        // 1.4 an single dimension String array with elements
        String[] metroCitiesInIndiaArray = new String[] {"Delhi", "Kolkata", "Mumbai", "Chennai"};

        // 1.5 simplified single dimension array with elements
        String[] majorITCitiesInIndiaArray = {"Bengaluru", "Pune", "Hyderabad", "Noida"};


        // ===================================
        // All below operations and behaviour apply to all types for array elements
        // ===================================

        // ------------------------------------------------------------------
        //     Length of the Array
        // ------------------------------------------------------------------

        // 2. Find the length of the array (it is referred to as length, not size)

        int employNamesArrayLength = employeeNamesArray.length;
        System.out.println("employeeNamesArrayLength = " + employNamesArrayLength);
        addDisplaySpace();

        // ------------------------------------------------------------------
        //     Access an specific element via its index
        // ------------------------------------------------------------------

        // 3. Access an element of the array by the index (single dimension example)
        System.out.println("int array element at the index 0: " +  integerNONEMPTYArray[0]);

        // ------------------------------------------------------------------
        //     Iterate over the array - for loop, for each and via streams
        // ------------------------------------------------------------------

        // 4. Display all elements of the array

        // 4.1 Iterate with a for loop based on index
        System.out.println("Displaying the elements of the employeeNamesArray, all elements should be null");
        for (int arrayIndex = 0; arrayIndex < employNamesArrayLength; arrayIndex++) {
            System.out.println(employeeNamesArray[arrayIndex]);
        }
        addDisplaySpace();

        // 4.2 Use a forEach loop to avoid referring by the index
        System.out.println("Displaying the elements of the metroCitiesInIndiaArray using forEach");
        for (String metroCityName : metroCitiesInIndiaArray) {
            System.out.println(metroCityName);
        }
        addDisplaySpace();

        // 4.3 convert the array in to a Stream (Java 1.8 and above) and display all elements
        // Refer to Stream example in other Stream class
        System.out.println("Displaying the elements of the majorItCitiesInIndiaArray via Streams");

        Arrays.stream(majorITCitiesInIndiaArray).forEach(majorCity -> System.out.println(majorCity));
        addDisplaySpace();

        // ------------------------------------------------------------------
        //     Assign values to a specific index position in the array
        // ------------------------------------------------------------------

        // 5. Add elements to an array (add it to a position by index, lets choose 0th index to add it to the first position)
        employeeNamesArray[0] = "Anupam Bhatt";
        // double check it got added, it should not be null
        System.out.println("Element 0 in the employeeNamesArray: " + employeeNamesArray[0]);


        // ------------------------------------------------------------------
        //     Copy all elements of the array (Clone, and using Arrays util class)
        // ------------------------------------------------------------------

        addDisplaySpace();

        // 6. Copy all elements of an array in to a new array

        // 6.1 Using clone (Array which is an object internally implements the Cloneable interface and hence we can call the clone method)
        System.out.println("Copying array in to a new one using clone method on the array");
        String[] newEmployeeNamesArray = employeeNamesArray.clone();

        // display all elements from the copied array to confirm
        Arrays.stream(newEmployeeNamesArray).forEach(newEmployeeName -> System.out.println(newEmployeeName));

        // 6.2 Using Arrays utility class
        System.out.println("Copying array in to anew one using Arrays.copyOf(..)");
        String[] reallyNewEmployeeArray = Arrays.copyOf(newEmployeeNamesArray, newEmployeeNamesArray.length);
        // display again to make sure this new array has all the elements
        Arrays.stream(reallyNewEmployeeArray).forEach(reallyNewEmployeeName -> System.out.println(reallyNewEmployeeName));

        // ------------------------------------------------------------------
        //     Arrays  utility class (special mention - again)
        // ------------------------------------------------------------------

        // Arrays is a util class which provides some most common required methods to work with arrays
        // Example:
        // copyOf - Copy array
        // sort
        // create a Stream out of the array

        // ------------------------------------------------------------------
        //     Multi-dimensional array (more than one dimension - pair of square brackets)
        // ------------------------------------------------------------------
        addDisplaySpace();

        int[][] twoDimensionalArray = new int[2][3];
        // AT THIS STAGE: a two dimensional array (of lengths 2 and 3 respectively are initialized)
        // think of it as a 2x3 matrix

        // assign a value to the 0,0 cell of the matrix (2 dimensional array)
        twoDimensionalArray[0][0] = 1;

        // display the value which just got added
        System.out.println("Displaying the 0,0 element of the 2 dimensional array");
        System.out.println(twoDimensionalArray[0][0]);
    }
}
