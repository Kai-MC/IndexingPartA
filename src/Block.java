public class Block {
    public int key;
    public int val;
    public Block next;

    public Block(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
    }

    public void addLast(Block block){
        var curr = this;
        while(next != null){
            curr = curr.next;
        }
        curr.next = block;
    }
}
