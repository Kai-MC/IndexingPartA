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
            var request = getUserInput(); //get the user input
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

    /**
     * Asks user to input request type, key and value
     * @return Models.KeyValueRequest
     */
    private static KeyValueRequest getUserInput(){
        //user input
        var scanner = new Scanner(System.in);
        System.out.print("Enter Operation Type (1 for Insert, 2 for Lookup, any other key to quit):");
        var op = getOperation(scanner.nextLine()); // converts user input into enum to represent operation
        if(op == OperationType.EXIT) return null;
        System.out.print("Enter Key (integer):");
        var key = tryParseInt(scanner.nextLine()); // tries to convert user input into integer
        if(key == null) return null;
        if(op == OperationType.INSERT){
            System.out.print("Enter Value (integer):");
            var value = tryParseInt(scanner.nextLine()); // tries to convert user input into integer
            if(value == null) return null;
            return new KeyValueRequest(key, value, op);
        }
        return new KeyValueRequest(key, null, op); // returns request class and type.
    }

    /**
     * Converts user input string into OperationType enum
     * @param op
     * @return OperationType enum.
     */
    private static OperationType getOperation(String op){
        if(op.equals("1")) return OperationType.INSERT;
        if(op.equals("2")) return OperationType.LOOKUP;
        return OperationType.EXIT;
    }

    /**
     * Converts user input string into integer.
     * @param str
     * @return Integer if successful, null otherwise
     */
    private static Integer tryParseInt(String str){
        try{
            return Integer.parseInt(str);
        }
        catch (Exception ex){
            return null;
        }
    }
}
