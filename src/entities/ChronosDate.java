package entities;

import java.time.LocalDate;

import java.time.LocalTime;

import java.time.format.DateTimeFormatter;

import java.util.Scanner;

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

        Scanner init = new Scanner (System.in);

        System.out.println("Enter (m or M) or (d or D): \n");

        char userChoice = init.next().charAt(0);

        askUserAboutDaysMonth(date, userChoice, init);

    }

    private static void askUserAboutDaysMonth (LocalDate date, char userChoice, Scanner init) {

        if (userChoice == 'M' || userChoice == 'm') {

            char askAnotherQuestion = init.next().charAt(0);

            if (askAnotherQuestion == 'p' || askAnotherQuestion == 'P') {

                int addValue = init.nextInt();

                LocalDate newDate = date.plusMonths(addValue);

                System.out.println(newDate);

            } else {

                int subtractValue = init.nextInt();

                LocalDate newDate = date.minusMonths(subtractValue);

                System.out.println(newDate);

            }

        } else if (userChoice == 'D' || userChoice == 'd') {

            char askAnotherQuestion = init.next().charAt(0);

            if (askAnotherQuestion == 'p' || askAnotherQuestion == 'P') {

                int addValue = init.nextInt();

                LocalDate newDate = date.plusDays(addValue);

                System.out.println(newDate);

            } else {

                int subtractValue = init.nextInt();

                LocalDate newDate = date.minusDays(subtractValue);

                System.out.println(newDate);

            }

        }

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
