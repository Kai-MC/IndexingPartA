public class KeyValueRequest {
    private int key;
    private Integer value;

    private OperationType operationType;

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

enum OperationType{
    LOOKUP,
    INSERT,
    EXIT
}
