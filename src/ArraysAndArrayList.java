import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArraysAndArrayList {

    public static void main(String[] args) {
        arrayOperations();
        arrayListOperations();
    }

    private static void arrayOperations() {

        // Arrays are TypeSafe (You define the type of items the array can hold during initialization itself)
        // Homogeneous data structure
        // Hence, you can not store any other type in the array it is initialized with

        // 1. initialize array

        // 1.1 an empty array with no elements (all elements will be initialized to null)
        String[] employeeNamesArray = new String[10];

        // 1.2 an array with elements
        String[] metroCitiesInIndiaArray = new String[]{"Delhi", "Kolkata", "Mumbai", "Chennai"};

        // 1.3 simplified with elements
        String[] majorITCitiesInIndiaArray = {"Bengaluru", "Pune", "Hyderabad", "Noida"};


        // 2. Find the length of the array (it is referred to as length, not size)

        int employNamesArrayLength = employeeNamesArray.length;
        System.out.println("employeeNamesArrayLength = " + employNamesArrayLength);
        addDisplaySpace();

        // 3. Display all elements of the array

        // 3.1 Iterate with a for loop based on index
        System.out.println("Displaying the elements of the employeeNamesArray, all elements should be null");
        for (int arrayIndex = 0; arrayIndex < employNamesArrayLength; arrayIndex++) {
            System.out.println(employeeNamesArray[arrayIndex]);
        }
        addDisplaySpace();

        // 3.2 Use a forEach loop to avoid referring by the index
        System.out.println("Displaying the elements of the metroCitiesInIndiaArray using forEach");
        for (String metroCityName : metroCitiesInIndiaArray) {
            System.out.println(metroCityName);
        }
        addDisplaySpace();

        // 3.3 convert the array in to a Stream (Java 1.8 and above) and display all elements
        System.out.println("Displaying the elements of the majorItCitiesInIndiaArray via Streams");

        Arrays.stream(majorITCitiesInIndiaArray).forEach(majorCity -> System.out.println(majorCity));
        addDisplaySpace();

        // 4. Add elements to an array (add it to a position by index, lets choose 0th index to add it to the first position)
        employeeNamesArray[0] = "Anupam Bhatt";
        // double check it got added, it should not be null
        System.out.println("Element 0 in the employeeNamesArray: " + employeeNamesArray[0]);

        // 5. Copy all elements of an array in to a new array

        // 5.1 Using clone
        System.out.println("Copying array in to a new one using clone method on the array");
        String[] newEmployeeNamesArray = employeeNamesArray.clone();

        // display all elements from the copied array to confirm
        Arrays.stream(newEmployeeNamesArray).forEach(newEmployeeName -> System.out.println(newEmployeeName));

        // 5.2 Using Arrays utility class
        System.out.println("Copying array in to anew one using Arrays.copyOf(..)");
        String[] reallyNewEmployeeArray = Arrays.copyOf(newEmployeeNamesArray, newEmployeeNamesArray.length);
        // display again to make sure this new array has all the elements
        Arrays.stream(reallyNewEmployeeArray).forEach(reallyNewEmployeeName -> System.out.println(reallyNewEmployeeName));

    }

    private static void arrayListOperations() {
        // ArrayList can act as a heterogeneous data structure (raw Arraylist - not recommended)
        // It can be bound to a type too to accept only the specified type of array elements (recommended)
        // ArrayList is an implementation for the List interface and is backed by an Array internally


        // 1. Instantiate an ArrayList

        // 1.1 instantiate a raw ArrayList (not type safe, can lead to class cast exception when extracting elements)
        List employeeNameList = new ArrayList();
        // the employeeNameArrayList will be an empty arrayList unless elements are added to it explicitly
        System.out.println(employeeNameList.isEmpty()); // should be true

        // 1.2 instantiate an type safe ArrayList
        List<String> metroCitiesInIndiaList = new ArrayList<>();
        System.out.println(metroCitiesInIndiaList.isEmpty()); // should be true

        addDisplaySpace();

        // 2. Add elements to an ArrayList

        // 2.1 add elements to an raw arrayList (not bound to a type)
        employeeNameList.add("Anupam Bhatt");
        employeeNameList.add(123123212);  // since the array list is not bound to a specific type, we can add an element
        // of any type, but note that it would be a problem when we get elements from a raw ArrayList and type cast it to String in this case

        // 2.2 add elements to a type safe ArrayList
        metroCitiesInIndiaList.add("Delhi");
        metroCitiesInIndiaList.add("Mumbai");
        metroCitiesInIndiaList.add("Kolkata");
        metroCitiesInIndiaList.add("Chennai");
        // metroCitiesInIndiaList.add(123); // this will cause a compile time error as the ArrayList is bound to String type

        // 3. Get size (not length as in the case of array) of the ArrayList
        System.out.println("Display ArrayList size");
        System.out.println("employeeNameList size: " + employeeNameList.size());
        System.out.println("metroCitiesInIndiaList size: " + metroCitiesInIndiaList.size());

        addDisplaySpace();

        // 3. Fetch items from the ArrayList and display

        // 3.1 fetch using for loop based on index
        System.out.println("Fetching using for loop based on Index");

        for (int arrayListIndex = 0; arrayListIndex < employeeNameList.size(); arrayListIndex++) {
            System.out.println(employeeNameList.get(arrayListIndex)); // no problem here as we just display and don't
            // typecase the elements to a string. The elements fetched here are of type "Object"
        }

        addDisplaySpace();

        for (int arrayListIndex = 0; arrayListIndex < metroCitiesInIndiaList.size(); arrayListIndex++) {
            System.out.println(metroCitiesInIndiaList.get(arrayListIndex)); // elements fetched are of type "String"
        }

        addDisplaySpace();

        // 3.2 fetch using forEach

        System.out.println("Fetching ArrayList elements using forEach");

        // for (String employeeName: employeeNameList) // this will cause problems, all elements are not a String in this "raw" list
        for (Object employeeName: employeeNameList) { // we cannot expect a String here (since one element is a integer)
            System.out.println(employeeName);
        }

        addDisplaySpace();

        for (String metroCityName: metroCitiesInIndiaList) {
            System.out.println(metroCityName); // this display all the elements as String, elements are bound to a type
        }

        addDisplaySpace();

        // 3.3 fetch using iterator

        System.out.println("Fetching ArrayList elements using iterator");

        // Iterator<String> employeeNameListIterator = employeeNameList.iterator(); // this will cause problems for a raw list

        Iterator employeeNameListIterator = employeeNameList.iterator(); // iterator is not bound to a type but to the generic Object type
        while(employeeNameListIterator.hasNext()) {
            // String employeeName = (String) employeeNameListIterator.next(); // this will fail for the integer value at "runtime"
            Object employeeName = employeeNameListIterator.next();
            System.out.println(employeeName);
        }

        addDisplaySpace();

        Iterator<String> metroCitiesInIndiaIterator = metroCitiesInIndiaList.iterator();
        while (metroCitiesInIndiaIterator.hasNext()) {
            String metroCityName = metroCitiesInIndiaIterator.next();
            System.out.println(metroCityName);
        }

        // 3.4 Using ListIterator
        // refer to ListIterator documentation (bi-directional iteration along with CRUD operations)
    }

    private static void addDisplaySpace() {
        System.out.println("---------------------------------------------------------------\n");
    }
}
