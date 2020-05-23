package com;

import java.text.DateFormatSymbols;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class LocaleOp {
    private Locale currentLocale;
    private ResourceBundle resourceBundle;

    public LocaleOp() {
        currentLocale = new Locale("ro", "Ro");
        resourceBundle = ResourceBundle.getBundle("res.Messages", currentLocale);
    }

    public void displayLocales() {
        resourceBundle.getString("locales");
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (Locale locale : availableLocales) {
            System.out.println(locale.getDisplayCountry() + "\t" + locale.getDisplayLanguage(locale));
        }
    }

    public void setLocale(String language, String country) {
        Locale.setDefault(new Locale(language, country));
        currentLocale = new Locale(language, country);
        resourceBundle = ResourceBundle.getBundle("res.Messages", new Locale(language, country));
    }

    public void info() {
        Object[] arguments = {currentLocale.getDisplayLanguage()};
        System.out.println(new MessageFormat(resourceBundle.getString("info")).format(arguments));
        System.out.println("Country: " + currentLocale.getDisplayCountry(currentLocale));
        System.out.println("Language: " + currentLocale.getDisplayLanguage(currentLocale));
        Currency currency = Currency.getInstance(currentLocale);
        System.out.println("Currency: " + currency.getDisplayName(currentLocale));

        DateFormatSymbols dateFormat = new DateFormatSymbols(currentLocale);
        System.out.println("Week Days: " + Arrays.toString(dateFormat.getWeekdays()));
        System.out.println("Months: " + Arrays.toString(dateFormat.getMonths()));

        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter
                .ofLocalizedDate(FormatStyle.FULL)
                .withLocale(currentLocale);
        System.out.println("Today: " + today.format(formatter));
    }

    public Locale getCurrentLocale() {
        return currentLocale;
    }

    public void setCurrentLocale(Locale currentLocale) {
        this.currentLocale = currentLocale;
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }
}
