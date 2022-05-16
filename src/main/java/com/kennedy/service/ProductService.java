package com.kennedy.service;

import java.util.List;
import java.util.Scanner;

import com.kennedy.model.Product;

public class ProductService {

    public static void list(List<Product> list) {
        double total = 0;
        if (list.size() == 0) {
            System.out.println();
            System.out.println("||=> Nenhum produto disponível");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("-----------------------------------------");
            for (Product p : list) {
                System.out.println(p);
                total += p.getPrice() * p.getAmount();
            }
            System.out.println("-----------------------------------------");
            System.out.println("||=> TOTAL = " + total);
            System.out.println();

        }
    }

    public static void save(List<Product> dbProducts) {
        int i = 1;
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("||=> Digite a quantidade de produtos:");
            int quantity = input.nextInt();

            while (i <= quantity) {
                System.out.println("||=> Digite o nome do produto " + i);
                String name = input.next();
                input.nextLine();

                System.out.println("||=> Digite o preço do produto " + i);
                Double price = input.nextDouble();

                System.out.println("||=> Digite a quantidade do produto " + i);
                Integer amount = input.nextInt();

                dbProducts.add(new Product(name, price, amount));
                i++;
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
