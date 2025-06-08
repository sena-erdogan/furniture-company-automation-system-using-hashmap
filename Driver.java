public class Driver {
    public static void main(String[] args){
        MapIterator mapIterator = new MapIterator();
        System.out.println("MapIterator constructed");
        HashMapLL<Integer,Integer> hashMapLL1 = new HashMapLL<>();
        System.out.println("Linked list hash map of integer,integer type constructed");
        HashMapTS<Integer,Integer> hashMapTS1 = new HashMapTS<>();
        System.out.println("Tree set hash map of integer,integer type constructed");
        HashMapLL<String,String> hashMapLL2 = new HashMapLL<>();
        System.out.println("Linked list hash map of string,string type constructed");
        HashMapTS<String,String> hashMapTS2 = new HashMapTS<>();
        System.out.println("Tree set hash map of string,string type constructed");
        HashMapLL<Integer,String> hashMapLL3 = new HashMapLL<>();
        System.out.println("Linked list hash map of integer,string type constructed");
        HashMapTS<Integer,String> hashMapTS3 = new HashMapTS<>();
        System.out.println("Tree set hash map of integer,string type constructed");
        HashMapLL<String,Integer> hashMapLL4 = new HashMapLL<>();
        System.out.println("Linked list hash map of string,integer type constructed");
        HashMapTS<String,Integer> hashMapTS4 = new HashMapTS<>();
        System.out.println("Tree set hash map of string,integer type constructed");
    }
}

