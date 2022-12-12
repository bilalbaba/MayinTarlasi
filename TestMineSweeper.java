import java.util.Scanner;

public class TestMineSweeper {
    public static void main(String[] args) {
        int satirSayisi, sutunSayisi;
        try(var input = new Scanner(System.in)){
            System.out.println("Satır sayısını girin: ");
            satirSayisi = input.nextInt();
            System.out.println("Sütun sayısını girin: ");
            sutunSayisi = input.nextInt();
            MineSweeper mayin = new MineSweeper(satirSayisi, sutunSayisi);
            mayin.run();
        }
    }
}

