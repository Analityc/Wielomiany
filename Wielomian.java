package ZmianaNotacji;

import java.util.Arrays;

public class Wielomian implements Wielomiany {

    private int[] wspolczynniki;
    private int stopien;

    private static Wielomian wymnorz(Wielomian a, Wielomian b, int poziom) {
        if (poziom > a.stopien)
            return new Wielomian();
        else {
            int[] tab = new int[b.stopien + poziom + 1];
            int war = a.wspolczynniki[poziom];
            int i;
            for (i = 0; i <= b.stopien; ++i) {
                tab[i + poziom] = war * b.wspolczynniki[i];
            }
            Wielomian wynik = new Wielomian(tab);
            return wynik.suma(wymnorz(a, b, poziom + 1));
        }
    }

    public void ToString() {
        int i;
        for (i = 0; i < this.stopien; ++i) {
            System.out.print(this.wspolczynniki[i] + ",");
        }
        System.out.println(this.wspolczynniki[i]);
    }

    public Wielomian(int x) {
        this.stopien = 0;
        this.wspolczynniki = new int[this.stopien + 1];
        this.wspolczynniki[this.stopien] = x;
    }

    public Wielomian(int[] tab) {
        this.wspolczynniki = tab;
        this.stopien = tab.length - 1;
    }

    public Wielomian() {
        this.stopien = 0;
        this.wspolczynniki = new int[this.stopien + 1];
        this.wspolczynniki[0] = 0;
    }

    public Wielomian(int x, int y) {
        this.stopien = Math.max(x, y);
        this.wspolczynniki = new int[this.stopien + 1];
    }

    public Wielomian(Wielomian a) {
        this.stopien = a.stopien;
        this.wspolczynniki = Arrays.copyOf(a.wspolczynniki, a.stopien + 1);
    }

    public Wielomian suma(Wielomian a) {
        Wielomian wynikowy = new Wielomian(this.stopien, a.stopien);
        int i;
        int m = Math.min(this.stopien, a.stopien);
        int M = Math.max(this.stopien, a.stopien);
        Wielomian wiekszy = M == this.stopien ? this : a;
        for (i = 0; i <= m; ++i) {
            wynikowy.wspolczynniki[i] += (a.wspolczynniki[i] + this.wspolczynniki[i]);
        }
        for (; i <= M; ++i) {
            wynikowy.wspolczynniki[i] += wiekszy.wspolczynniki[i];
        }
        return wynikowy;
    }

    public Wielomian iloczyn(Wielomian a) {
        return wymnorz(this, a, 0);
    }

    public int[] tablica() {
        int[] tab = Arrays.copyOf(this.wspolczynniki, this.stopien + 1);
        return tab;
    }

    public Wielomian zlozenie(Wielomian a) {
        int i;
        Wielomian wynik = new Wielomian(this.wspolczynniki[0]);
        for (i = 1; i <= this.stopien; i++) {
            Wielomian b = new Wielomian(a);
            int j;
            for (j = 1; j < i; ++j) {
                b = b.iloczyn(b);
            }
            b = b.iloczyn(new Wielomian(this.wspolczynniki[i]));
            wynik = wynik.suma(b);
        }
        return wynik;
    }
}
