package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
        String[] cities = new String[]{
                "Москва", "Санкт-Петербург", "Уфа", "Ярославль", "Пермь", "Казань", "Омск", "Курск"
        };
        Faker faker = new Faker(new Locale(locale));
        return cities[faker.number().numberBetween(0, cities.length - 1)];
    }

    //public static String generateCity() {
        //var sities = new String[]{
                //"Москва", "Санкт-Петербург", "Уфа", "Ярославль", "Пермь", "Казань", "Омск", "Курск"};
        //return sities[new Random().nextInt(sities.length)];
    //}

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale),generateName(locale),generatePhone(locale));
        }
    }
    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
