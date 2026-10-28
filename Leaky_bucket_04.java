package cnlab;

import java.util.Scanner;

public class Leaky1 {

    int[] q = new int[10];
    int f = 0, r = 0;
    final int size = 10;

    void insert(Scanner sc) {
        System.out.print("Enter the number of packets: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter packet " + (i + 1) + ": ");
            int packet = sc.nextInt();

            if (r >= size) {
                System.out.println("Queue full. Lost packet: " + packet);
            } else {
                q[r] = packet;
                r++;
            }
        }
    }

    void delete() {
        if (f == r) {
            System.out.println("Queue is empty. No packets to leak.");
            return;
        }

        System.out.println("Leaking packets:");

        while (f < r) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Packet leaking interrupted.");
                return;
            }

            System.out.println("Leaked Packet: " + q[f]);
            f++;
        }

        f = 0;
        r = 0;
        System.out.println("All packets leaked.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Leaky1 obj = new Leaky1();

        while (true) {
            System.out.println("\n--- LEAKY BUCKET ---");
            System.out.println("1. Insert Packets");
            System.out.println("2. Leak Packets");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    obj.insert(sc);
                    break;

                case 2:
                    obj.delete();
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
