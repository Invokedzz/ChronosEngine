package entities;

import java.time.LocalDate;

import java.time.LocalTime;

import java.time.format.DateTimeFormatter;

public class ChronosDate {

    public static void showDateWithChronos () {

        new Thread(() -> {

            try {

                Thread.sleep(1000);

                dateByChronos();

            } catch (InterruptedException error) {

                Thread.currentThread().interrupt();

                System.out.println(error.getMessage());


            }

        }).start();

    }

    public static void showTimeWithChronos () {

        new Thread (() -> {

            try {

                Thread.sleep(1000);

                timeByChronos();

            } catch (InterruptedException error) {

                Thread.currentThread().interrupt();

                System.out.println(error.getMessage());

            }

        }).start();

    }

    public static void timeProgressionWithChronos (int year, int month, int day) {

        String manualParse = year + "-" + month + "-" + day;

        // 2007-12-03

        LocalDate date = LocalDate.parse(manualParse);

    }

    private static void askUserAboutDaysMonthYear () {

    }

    private static void dateByChronos () {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate date = LocalDate.now();

        String registeredElement = date.format(formatter);

        System.out.println(registeredElement);

    }

    private static void timeByChronos () {

        LocalTime time = LocalTime.now();

        System.out.println(time);

    }

}
