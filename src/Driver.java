import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        var map = new CustomHashMap();
        var items = new int[] {29,41,44,62,46,49,27,76,91,30,100,47,34,53,9,45};
        for(var item: items)
            map.insert(item, item);

        for(var item:items){
            System.out.println(map.lookup(item));
        }
        map.display();
        while(true){
            var request = getUserInput();
            if(request == null){
                break;
            }
            var operation = request.getOperationType();
            if(operation == OperationType.INSERT){
                map.insert(request.getKey(), request.getValue());
                map.display();
            }
            else{
                System.out.println(map.lookup(request.getKey()));
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
        var op = getOperation(scanner.nextLine());
        if(op == OperationType.EXIT) return null;
        System.out.print("Enter Key (integer):");
        var key = tryParseInt(scanner.nextLine());
        if(key == null) return null;
        if(op == OperationType.INSERT){
            System.out.print("Enter Value (integer):");
            var value = tryParseInt(scanner.nextLine());
            if(value == null) return null;
            return new KeyValueRequest(key, value, op);
        }
        return new KeyValueRequest(key, null, op);
    }

    private static OperationType getOperation(String op){
        if(op.equals("1")) return OperationType.INSERT;
        if(op.equals("2")) return OperationType.LOOKUP;
        return OperationType.EXIT;
    }

    private static Integer tryParseInt(String str){
        try{
            return Integer.parseInt(str);
        }
        catch (Exception ex){
            return null;
        }
    }
}
