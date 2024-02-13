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
    }
}
