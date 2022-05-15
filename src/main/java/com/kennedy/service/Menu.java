package com.kennedy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kennedy.model.Product;

public class Menu {

    static List<Product> dbProducts = new ArrayList<>();

    public static void start() {

        renderMenu();

        try (Scanner keyboard = new Scanner(System.in)) {
            int option = keyboard.nextInt();

            while (option != 0) {
                switch (option) {
                    case 1: {
                        ProductService.save(dbProducts);
                        break;
                    }
                    case 2: {
                        ProductService.list(dbProducts);
                        break;
                    }
                    default: {
                        System.out.println("Escolha uma opção do menu");
                    }

                }

                renderMenu();
                option = keyboard.nextInt();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static void renderMenu() {
        System.out.println("=========== MENU ===========");
        System.out.println("1 - Cadastrar produtos");
        System.out.println("2 - Listar produtos");
        System.out.println("0 - Sair");
        System.out.println("============================");
    }

}
