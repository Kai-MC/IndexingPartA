/**
 * Custom indexing structure: Dynamically resized hashmap to hold key-value pairs in memory.
 */
public class CustomHashMap {
    private static int capacity = 16; // initial capacity
    private static int numberOfItems = 0; // number of blocks filled
    private Block[] blocks; // Array of blocks, where each index is a LinkedList of key-value pairs

    public CustomHashMap(){
        this.blocks = new Block[capacity];
    }

    /**
     * Inserts key-value pair into the hashmap. Also resizes the map if the number of blocks reaches capacity / 2
     * @param key
     * @param val
     */
    public void insert(int key, int val){
        if(numberOfItems >=  capacity / 2){
            resize(); // resize the map if capacity/2 is reached.
        }
        var index = findIndex(key); // determines the index of where should key-value be stored in the blocks array
        var newNode = new Block(key, val); // create new node
        var currBlock = blocks[index];
        if(currBlock == null){
            blocks[index] = newNode; // if no node is occupying the index, create new linked list.
        }
        else{
            currBlock.addLast(newNode); // handle collision, add to the tail the new node.
        }
        numberOfItems++;

    }

    /**
     * Resizes the blocks array. It is essential to recalculate the indexes to not lose the access to the data
     */
    private void resize(){
        var oldBlocks = blocks; // copy old blocks
        capacity *= 2; // double the capacity
        numberOfItems = 0; // reset the number of items, because we will be inserting current blocks one by one.
        blocks = new Block[capacity];
        for(var block : oldBlocks){
            while(block != null){ // handle collisions and perform insertion to the new blocks array.
                this.insert(block.key, block.val);
                block = block.next;
            }
        }
    }

    /**
     * Searches for the block based on the key.
     * @param key
     * @return value associated with key, or -1 if key not found.
     */
    public int lookup(int key){
        var index = findIndex(key); // find blocks index
        var currBlock = blocks[index];
        if(currBlock == null) return -1;
        while(currBlock != null){ // traverse the linked list to find the block with the same key as the input
            if(currBlock.key == key){
                return currBlock.val; // return value if key found.
            }
            currBlock = currBlock.next;
        }
        return -1; //key not found
    }

    /**
     * Displays all non-empty indexes stored in our in-memory storage.
     */
    public void display(){
        System.out.println("Total number of blocks:" + blocks.length);
        System.out.println("Total number of items: " + numberOfItems);
        for(int i = 0; i < blocks.length; ++i){ // traverse all blocks
            var curr = blocks[i];
            if(curr == null) continue;
            System.out.println("Displaying Index:" + i);
            while(curr != null){ // handle collision and display key and value.
                System.out.print(String.format("Key: %s, Value: %s ", curr.key, curr.val));
                curr = curr.next;
            }
            System.out.println();
        }
    }

    /**
     * returns an index of Blocks based on the key. It simply mods the key to find a specific index where that key
     * would be written in our indexing structure.
     * @param key
     * @return
     */
    private int findIndex(int key){
        return key % capacity;
    }

}
