public class Main {
    public static void main(String[] args) {
        SortedArray s = new SortedArray(5);
        s.put(2);
        s.put(7);
        s.put(3);
        s.put(5);
        s.put(1);
        System.out.println(s);
        System.out.println(s.existsElementRecursive(4));
        s.removeElementAt(4);
        System.out.println(s);
    }
}
