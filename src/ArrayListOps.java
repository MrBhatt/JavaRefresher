import java.util.Iterator;
import java.util.List;

import static util.DisplayUtil.addDisplaySpace;

public class ArrayListOps {
    public static void main(String[] args) {
        arrayListOperations();
    }

    private static void arrayListOperations() {
        // ArrayList can act as a heterogeneous data structure (raw Arraylist - not recommended)
        // It can be bound to a type too to accept only the specified type of array elements (recommended)
        // ArrayList is an implementation for the List interface and is backed by an Array internally


        // 1. Instantiate an ArrayList

        // 1.1 instantiate a raw ArrayList (not type safe, can lead to class cast exception when extracting elements)
        List employeeNameList = new java.util.ArrayList();

        // the employeeNameArrayList will be an empty arrayList unless elements are added to it explicitly
        System.out.println(employeeNameList.isEmpty()); // should be true

        // 1.2 instantiate an type safe ArrayList
        List<String> metroCitiesInIndiaList = new java.util.ArrayList<>();
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

        addDisplaySpace();

        // 3.4 fetch elements from the ArrayList by converting it to a Stream (remember Streams can be consumed only once)

        System.out.println("Fetching ArrayList elements by getting a Stream from the ArrayList");
        employeeNameList.stream().forEach(employeeName -> System.out.println(employeeName));

        addDisplaySpace();

        metroCitiesInIndiaList.stream().forEach(metroCityName -> System.out.println(metroCityName));

        // 3.5 Using ListIterator
        // refer to ListIterator documentation (bi-directional iteration along with CRUD operations)
    }
}
