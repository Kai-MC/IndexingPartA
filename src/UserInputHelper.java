import java.util.Scanner;

/**
 * Helper class to manage user input and convert it to a type that Java app can easily handle
 */
public class UserInputHelper {
    /**
     * Asks user to input request type, key and value
     * @return Models.KeyValueRequest
     */
    public static KeyValueRequest getUserInput(){
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
