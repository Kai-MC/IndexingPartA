/**
 * Represents the user input class, has parameters such as key, value and operation type.
 * Yukai Ma  002472067
 * Alexander Khoperia 002750203
 */
public class KeyValueRequest {
    // member variables
    private int key;
    private Integer value;

    private OperationType operationType;

    //getters
    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public KeyValueRequest(int key, Integer value, OperationType operationType){
        this.key = key;
        this.value = value;
        this.operationType = operationType;
    }
}

/**
 * This enum represents the actions user can choose while interacting with the app.
 */
enum OperationType{
    LOOKUP,
    INSERT,
    EXIT
}
