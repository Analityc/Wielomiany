package ZmianaNotacji;

public class Stos {

    private static final int MAX = 1000;
    private static final String PELNY = "Stos Pelny!";

    private Wielomian[] elementy;
    private int rozmiar = 0;

    public Stos() {
        this.elementy = new Wielomian[MAX];
    }

    public boolean jestPusty() {
        return (rozmiar == 0);
    }

    public void wstaw(Wielomian x) {
        if (rozmiar <= MAX) {
            elementy[rozmiar] = x;
            ++rozmiar;
        } else {
            System.out.println(PELNY);
        }
    }

    public Wielomian pobierz() {
        if (!jestPusty()) {
            --rozmiar;
            return elementy[rozmiar];
        } else
            return null;
    }
}