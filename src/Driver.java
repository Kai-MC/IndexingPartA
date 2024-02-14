import java.util.Scanner;

/**
 * This class serves as a driver. it prefills the indexing structure and allows user input to lookup/insert values.
 */
public class Driver {
    public static void main(String[] args) {
        var map = new CustomHashMap(); //Instantiates the custom indexing structure
        var items = new int[] {29,41,44,62,46,49,27,76,91,30,100,47,34,53,9,45};
        for(var item: items)
            map.insert(item, item);  //prefill the custom hashmap

        for(var item:items){ //lookup items to make sure all items are stored correctly
            System.out.println(map.lookup(item));
        }
        map.display(); // displays the content of the custom hashmap (also shows collisions that occur)
        while(true){ //user input loop
            var request = UserInputHelper.getUserInput(); //get the user input
            if(request == null){
                break; // quit if bad request or user specifically typed to quit.
            }
            var operation = request.getOperationType(); // current operation: Lookup, Insert or Quit
            if(operation == OperationType.INSERT){
                map.insert(request.getKey(), request.getValue()); //insert into current map
                map.display(); //display new indexing structure after insertion
            }
            else{
                System.out.println(map.lookup(request.getKey())); // retrieve value from hashmap.
            }
        }
    }


}
