package pertemuan9.code1;

import java.util.Scanner;

class ArrayToko {
    static String[] IDcode = {"a001", "a002", "a003"};
    static String[] Nama = {"Buku", "Pensil", "Pulpen"};
    static int[] Harga = {3000, 4000, 5000};

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Masukkan Item Barang: ");
            int jumlahBarang = scanner.nextInt();
            
            String[] IDBarang = new String[jumlahBarang];
            int[] jumlahPembelian = new int[jumlahBarang];
            int[] totalBarang = new int[jumlahBarang];
            
            for (int i = 0; i < jumlahBarang; i++) {
                System.out.println("Data ke " + (i + 1));

                System.out.print("Masukkan Kode : ");
                IDBarang[i] = scanner.next();
                
                System.out.print("Masukkan jumlah Beli : ");
                jumlahPembelian[i] = scanner.nextInt();

                totalBarang[i] = getHarga(IDBarang[i]) * jumlahPembelian[i];
            }

            System.out.println("\nTOKO SERBA ADA");
            System.out.println("****************************");
            System.out.printf("%-5s %-10s %-12s %-8s %-10s %-10s%n", "No", "Kode Barang", "Nama Barang", "Harga", "Jumlah Beli", "Jumlah Bayar");
            System.out.println("---------------------------------------------------------------");

            int totalPrice = 0;

            for (int i = 0; i < jumlahBarang; i++) {
                String itemName = getNama(IDBarang[i]);
                int itemPrice = getHarga(IDBarang[i]);

                totalPrice += totalBarang[i];

                System.out.printf("%-5d %-10s %-12s %-8d %-10d %-10d%n", (i + 1), IDBarang[i], itemName, itemPrice, jumlahPembelian[i], totalBarang[i]);
            }

            System.out.println("---------------------------------------------------------------");
            System.out.println("Total Bayar                 : " + totalPrice);
        }
    }

    static String getNama(String code) {
        for (int i = 0; i < IDcode.length; i++) {
            if (IDcode[i].equals(code)) {
                return Nama[i];
            }
        }
        return "Unknown";
    }

    static int getHarga(String code) {
        for (int i = 0; i < IDcode.length; i++) {
            if (IDcode[i].equals(code)) {
                return Harga[i];
            }
        }
        return 0;
    }
}

