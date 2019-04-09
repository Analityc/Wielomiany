package ZmianaNotacji;

public class Test {
    public static void main(String[] args) {
        int[] tab = { 1, 2, 1 };
        int[] tab2 = { 1, 2, 1 };
        Wielomian a = new Wielomian(tab);
        Wielomian b = new Wielomian(tab2);
        Wielomian wynik = a.suma(b);
        wynik.ToString();
        wynik = a.iloczyn(b);
        wynik.ToString();
        wynik = a.zlozenie(b);
        wynik.ToString();
    }
}
