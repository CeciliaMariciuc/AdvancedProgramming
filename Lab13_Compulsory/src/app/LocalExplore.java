package app;

import com.LocaleOp;

import java.util.Scanner;

public class LocalExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocaleOp localeOp = new LocaleOp();
        boolean exit = false;
        System.out.println(localeOp.getResourceBundle().getString("prompt"));
        while (!exit) {
            String command = scanner.nextLine();
            if (command.equals("display locales")) {
                localeOp.displayLocales();
            } else if (command.equals("set locale")) {
                System.out.println("Alegeti limba:");
                String language = scanner.nextLine();
                System.out.println("Alegeti tara:");
                String country = scanner.nextLine();
                localeOp.setLocale(language, country);
            } else if (command.equals("info")) {
                localeOp.info();
            } else if (command.equals("exit")) {
                System.out.println("...Exit...");
                exit = true;
            } else {
                System.out.println(localeOp.getResourceBundle().getString("invalid"));
            }
        }
    }
}
