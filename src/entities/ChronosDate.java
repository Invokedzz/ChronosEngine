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

        String manualParse = String.format("%04d-%02d-%02d", year, month, day);

        // 2007-12-03

        LocalDate date = LocalDate.parse(manualParse);

        Scanner init = new Scanner (System.in);

        System.out.println("Enter (m or M for month) or (d or D for day): \n");

        char userChoice = init.next().charAt(0);

        askUserAboutDaysMonth(date, userChoice, init);

    }

    private static void askUserAboutDaysMonth (LocalDate date, char userChoice, Scanner init) {

        switch (userChoice) {

            case 'm' | 'M':

                System.out.println("(p or P) to add, otherwise we shall reduce the months ourselves \n");

                char askAnotherQuestion = init.next().charAt(0);

                if (askAnotherQuestion == 'p' || askAnotherQuestion == 'P') {

                    System.out.println("Enter a value to add: \n");

                    long addValue = init.nextLong();

                    LocalDate newDate = date.plusMonths(addValue);

                    System.out.println(newDate);

                    return;

                }

                System.out.println("Enter a value to subtract: \n");

                long subtractValue = init.nextLong();

                LocalDate newDate = date.minusMonths(subtractValue);

                System.out.println(newDate);

            case 'D' | 'd':

                System.out.println("Plus or minus? \n");

                char askNewQuestion = init.next().charAt(0);

                if (askNewQuestion == 'p' || askNewQuestion == 'P') {

                    System.out.println("Enter a value to add: \n");

                    long addValue = init.nextLong();

                    LocalDate newDateDays = date.plusDays(addValue);

                    System.out.println(newDateDays);

                    return;

                }

                System.out.println("Enter a value to subtract: \n");

                long subtractValueDays = init.nextLong();

                LocalDate newDateDays = date.minusDays(subtractValueDays);

                System.out.println(newDateDays);

            case 'y' | 'Y':

                System.out.println("Plus or minus? \n");

                char askQuestionAboutYear = init.next().charAt(0);

                if (askQuestionAboutYear == 'p' || askQuestionAboutYear == 'P') {

                    System.out.println("Enter a value to add: \n");

                    long addValue = init.nextLong();

                    LocalDate newDateYear = date.plusYears(addValue);

                    System.out.println(newDateYear);

                    return;

                }

                System.out.println("Enter a value to subtract: \n");

                long subtractValueYears = init.nextLong();

                LocalDate newDateYears = date.minusDays(subtractValueYears);

                System.out.println(newDateYears);

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
