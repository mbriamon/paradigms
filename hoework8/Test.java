public class Test {
    public static void main(String[] args) {
        Homework8 hw = new Homework8();

        System.out.println(hw.check(new char[]{ 'W', '*', 'R'}, "WoRdle")); // true
        System.out.println(hw.check(new char[]{ 'W', '*'}, "wordle"));      // false
        System.out.println(hw.check(new char[]{ 'S', '*', 'G', '*', 'R'}, "SUGAR")); // true
        System.out.println(hw.check(new char[]{}, ""));                     // true
        System.out.println(hw.check(new char[]{ '*', '*', '*', '*', '*'}, "PARADIGMS")); // true
    }
}
