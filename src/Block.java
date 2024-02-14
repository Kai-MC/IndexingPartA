/**
 * Represents the single block in the indexing structure. Essentially a node class.
 * Yukai Ma  002472067
 * Alexander Khoperia 002750203
 */
public class Block {
    public int key;
    public int val;
    public Block next; //pointer to the next block

    public Block(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
    }

    /**
     * Adds block at the end of the LinkedList. is used in hashmap to handle collisions
     * @param block
     */
    public void addLast(Block block){
        var curr = this;
        while(next != null){ //traverse to the end of the list
            curr = curr.next;
        }
        curr.next = block; // insert node.
    }
}
