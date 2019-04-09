Program składający się z plików Stos.java, StosTablicowy.java i Test.java demonstruje definicję typu za pomocą interfejsu.

Metoda toString() w klasie StosTablicowy pokazuje, jak efektywnie budować długie napisy za pomocą obiektu klasy StringBuilder.

Napisz program czytający wyrażenie w odwrotnej notacji polskiej, którego wartością jest wielomian jednej zmiennej o współczynnikach całkowitych.

Wynikiem programu ma być infiksowy zapis wartości tego wyrażenia.

Program powinien być zgodny z poniższą specyfikacją.

Dane programu są w pierwszym wierszu wejścia.

W wyrażeniu mogą wystąpić,

liczby całkowite, reprezentujące wielomiany stałe,

litera x, reprezentująca wielomian liniowy x,

operatory +, *, @ reprezentujące, odpowiednio, operację dodawania, mnożenia i złożenia wielomianów.

Między kolejnymi elementami wyrażenia jest co najmniej jedna spacja.

Program pisze jeden wiersz z tekstowym zapisem wielomianu, będącego wartością wczytanego wyrażenia.

Postać wyniku nie jest precyzyjnie określona, ale warto zadbać, by był on możliwie jak najbardziej czytelny dla użytkownika.

Dla danych

x -3 + x -1 * 2 + *

wynikiem programu może być

-x^2+5x-6

Dla danych

x x * x 1 + @

wynikiem programu może być

x^2+2x+1

Dla danych

x 1 + x 1 + * x 1 + x 1 + * x 1 + x 1 + * @ @

wynikiem programu może być

x^8+8x^7+32x^6+80x^5+138x^4+168x^3+144x^2+80x+25
