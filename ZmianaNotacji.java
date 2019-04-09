package ZmianaNotacji;

import java.util.Scanner;

public class ZmianaNotacji {

    private String Infiksowy = "";
    private int[] WspolczynnikiPoteg = null;
    private static final char dodawanie = '+';
    private static final char mnozenie = '*';
    private static final char zlozenie = '@';
    private static final char liniowy = 'x';
    private static final char minus = '-';
    private static final char potega = '^';

    public void NaTablice(String odwrotna) {
        Stos stos = new Stos();
        int i = 0;
        while (i < odwrotna.length()) {
            char aktualny = odwrotna.charAt(i);
            Wielomian a, b;
            switch (aktualny) {
            case dodawanie:
                b = stos.pobierz();
                a = stos.pobierz();
                stos.wstaw(a.suma(b));
                break;
            case mnozenie:
                b = stos.pobierz();
                a = stos.pobierz();
                stos.wstaw(a.iloczyn(b));
                break;
            case zlozenie:
                b = stos.pobierz();
                a = stos.pobierz();
                stos.wstaw(a.zlozenie(b));
                break;
            case liniowy:
                int[] tab = { 0, 1 };
                stos.wstaw(new Wielomian(tab));
                break;
            default:
                boolean ujemny = aktualny == minus;
                int x;
                if (ujemny) {
                    ++i;
                    aktualny = odwrotna.charAt(i);
                    x = aktualny - '0';
                    x = -x;
                } else {
                    x = aktualny - '0';
                }
                stos.wstaw(new Wielomian(x));
                break;
            }
            i += 2;
        }
        this.WspolczynnikiPoteg = stos.pobierz().tablica();
    }

    public void infiksowo() {
        int[] tab = this.WspolczynnikiPoteg;
        int i = tab.length - 1;
        StringBuilder s = new StringBuilder();
        if (i >= 0) {
            switch (i) {
            case 0:
                s.append(tab[i]);
                break;
            case 1:
                if (tab[i] == 1)
                    s.append(liniowy);
                else if (tab[i] == -1) {
                    s.append(minus);
                    s.append(liniowy);
                } else if (tab[i] != 0) {
                    s.append(tab[i]);
                    s.append(liniowy);
                }
                break;
            default:
                switch (tab[i]) {
                case 0:
                    break;
                case -1:
                    s.append(minus);
                case 1:
                    s.append(liniowy);
                    s.append(potega);
                    s.append(i);
                    break;
                default:
                    s.append(tab[i]);
                    s.append(liniowy);
                    s.append(potega);
                    s.append(i);
                    break;

                }
                break;
            }
            --i;
        }
        while (i >= 0) {
            switch (i) {
            case 0:
                if (tab[i] > 0) {
                    s.append(dodawanie);
                    s.append(tab[i]);
                } else if (tab[i] < 0)
                    s.append(tab[i]);
                break;
            case 1:
                if (tab[i] == 1) {
                    s.append(dodawanie);
                    s.append(liniowy);
                } else if (tab[i] == -1) {
                    s.append(minus);
                    s.append(liniowy);
                } else if (tab[i] < 0) {
                    s.append(tab[i]);
                    s.append(liniowy);
                } else if (tab[i] > 0) {
                    s.append(dodawanie);
                    s.append(tab[i]);
                    s.append(liniowy);
                }
                break;
            default:
                switch (tab[i]) {
                case 0:
                    break;
                case -1:
                case 1:
                    if (tab[i] < 0)
                        s.append(minus);
                    else
                        s.append(dodawanie);
                    s.append(liniowy);
                    s.append(potega);
                    s.append(i);
                    break;
                default:
                    if (tab[i] > 0)
                        s.append(dodawanie);
                    s.append(tab[i]);
                    s.append(liniowy);
                    s.append(potega);
                    s.append(i);
                    break;

                }
                break;
            }
            --i;
        }
        this.Infiksowy = s.toString();
    }

    public ZmianaNotacji(String odwrotna) {
        this.NaTablice(odwrotna);
        this.infiksowo();
    }

    public void wypisz() {
        System.out.println(this.Infiksowy);
    }

    public static void main(String[] args) {
        final Scanner wiersze = new Scanner(System.in);
        while (wiersze.hasNextLine()) {
            String wiersz = wiersze.nextLine();
            if (!wiersz.isEmpty()) {
                ZmianaNotacji a = new ZmianaNotacji(wiersz);
                a.wypisz();
            }
        }
        wiersze.close();
    }
}
