import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    int satirSayisi;
    int sutunSayisi;
    int mayinSayisi;
    String[][] oyunHaritasi;
    String[][] mayinHaritasi;

    MineSweeper(int satirSayisi, int sutunSayisi) {
        this.satirSayisi = satirSayisi;
        this.sutunSayisi = sutunSayisi;
        this.oyunHaritasi = new String[satirSayisi][sutunSayisi];
        this.mayinHaritasi = new String[satirSayisi][sutunSayisi];
        this.mayinSayisi = (satirSayisi * sutunSayisi) / 4;
    }


    public void setFields() {
        Random rnd = new Random();
        int rndSatir;
        int rndSutun;
        for (int i = 0; i < mayinSayisi; i++)
        {
            rndSatir = rnd.nextInt(satirSayisi);
            rndSutun = rnd.nextInt(sutunSayisi);
            if (mayinHaritasi[rndSatir][rndSutun] != "*")
            {
                mayinHaritasi[rndSatir][rndSutun] = "*";
            } else {
                i--;
            }
        }
        for (int i = 0; i < satirSayisi; i++)
        {
            for (int j = 0; j < sutunSayisi; j++)
            {
                oyunHaritasi[i][j] = "-";
                if (mayinHaritasi[i][j] != "*")
                {
                    mayinHaritasi[i][j] = "-";
                }
                System.out.print(this.mayinHaritasi[i][j] + " ");
            }
            System.out.println();
        }
    }

    void getVisibleField() {
        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                System.out.print(oyunHaritasi[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===============================");
    }

    void getHiddenField() {
        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                System.out.print(mayinHaritasi[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("===============================");
    }

    void run() {
        Scanner consolGiris = new Scanner(System.in);
        int satir, sutun, toplamHamle = satirSayisi * sutunSayisi - mayinSayisi;
        setFields();
        System.out.println("=========MAYIN TARLASI=========");
        while (toplamHamle > 0) {
            System.out.print("Kaçıncı satır : ");
            satir = consolGiris.nextInt();
            System.out.print("Kaçıncı sütun : ");
            sutun = consolGiris.nextInt();

            if ((satir < 0 || satir >= satirSayisi) || (sutun < 0 || sutun >= sutunSayisi)) {
                System.out.println("=========YANLIS HAMLE==========");
                continue;
            }
            if (mayinHaritasi[satir][sutun] == "*") {
                System.out.println("=========OYUN BİTTİ :(=========");
                getHiddenField();
                break;
            } else {
                if (oyunHaritasi[satir][sutun] != "-") {
                    System.out.println("DİKKAT ET AYNI HAMLEYİ YAPTIN!!");
                } else {
                    int sayac = 0;
                    if (mayinHaritasi[satir][sutun] != "*") {
                        if (satir != 0) {
                            if (mayinHaritasi[satir - 1][sutun] == "*") sayac++;
                            if (sutun != 0)
                                if (mayinHaritasi[satir - 1][sutun - 1] == "*") sayac++;

                        }
                        if (satir != satirSayisi - 1) {
                            if (mayinHaritasi[satir + 1][sutun] == "*") sayac++;
                            if (sutun != sutunSayisi - 1)
                                if (mayinHaritasi[satir + 1][sutun + 1] == "*") sayac++;

                        }
                        if (sutun != 0) {
                            if (mayinHaritasi[satir][sutun - 1] == "*") sayac++;
                            if (satir != satirSayisi - 1)
                                if (mayinHaritasi[satir + 1][sutun - 1] == "*") sayac++;

                        }
                        if (sutun != sutunSayisi - 1) {
                            if (mayinHaritasi[satir][sutun + 1] == "*") sayac++;
                            if (satir != 0)
                                if (mayinHaritasi[satir - 1][sutun + 1] == "*") sayac++;

                        }

                        oyunHaritasi[satir][sutun] = Integer.toString(sayac);
                    }
                }
            }
            toplamHamle--;
            getVisibleField();
        }
        if (toplamHamle == 0) {
            System.out.println("========OYUNU KAZANDIN=========");
        }
        consolGiris.close();
    }
}
