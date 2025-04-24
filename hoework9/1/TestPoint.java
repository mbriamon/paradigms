public class TestPoint {
    public static void main(String[] args) {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(-3, 1);
        Point p3 = new Point(-2, -3);

        System.out.println(p1.equals(p2)); // false
        System.out.println(p1.equals(p3)); // true
        System.out.println(p1.equals(null)); // false
        System.out.println(p1.equals(p1)); // true
    }
}
