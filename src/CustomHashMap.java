public class CustomHashMap {
    private static int capacity = 16;
    private static int numberOfItems = 0;
    private Block[] blocks;

    public CustomHashMap(){
        this.blocks = new Block[capacity];
    }

    public void insert(int key, int val){
        if(numberOfItems >=  capacity / 2){
            resize();
        }
        var index = findIndex(key);
        var newNode = new Block(key, val);
        var currBlock = blocks[index];
        if(currBlock == null){
            blocks[index] = newNode;
        }
        else{
            currBlock.addLast(newNode);
        }
        numberOfItems++;

    }

    private void resize(){
        var oldBlocks = blocks;
        capacity *= 2;
        numberOfItems = 0;
        blocks = new Block[capacity];
        for(var block : oldBlocks){
            while(block != null){
                this.insert(block.key, block.val);
                block = block.next;
            }
        }
    }

    public int lookup(int key){
        var index = findIndex(key);
        var currBlock = blocks[index];
        if(currBlock == null) return -1;
        while(currBlock != null){
            if(currBlock.key == key){
                return currBlock.val;
            }
            currBlock = currBlock.next;
        }
        return -1;
    }

    public void display(){
        System.out.println("Total number of blocks:" + blocks.length);
        System.out.println("Total number of items: " + numberOfItems);
        for(int i = 0; i < blocks.length; ++i){
            var curr = blocks[i];
            if(curr == null) continue;
            System.out.println("Displaying Index:" + i);
            while(curr != null){
                System.out.print(String.format("Key: %s, Value: %s ", curr.key, curr.val));
                curr = curr.next;
            }
            System.out.println();
        }
    }


    private int findIndex(int key){
        return key % capacity;
    }

}
