package app;

import entities.ChronosEntity;

import entities.ChronosDate;

import java.util.Scanner;

import java.util.Locale;

import validators.ValidatorsPackage;

import validators.ScannerValidators;

public class ChronosApp {

    public static void main (String[] args) throws  InterruptedException {

        Locale.setDefault(Locale.ITALIAN);

        startChronosEngine();

    }

    private static void startChronosEngine () throws InterruptedException {

        Scanner initScanner = new Scanner(System.in);

        System.out.println("Do you want to start Chronos?");

        char userCommand = initScanner.next().charAt(0);

        ValidatorsPackage.displayChronosControl(userCommand);

        chronosOptions(initScanner);

    }

    private static void chronosOptions (Scanner initScanner) throws InterruptedException {

        System.out.println("Select an option! (1), (2), (3), (4). ");

        int selectOption = ScannerValidators.displayScannerValidator(initScanner);

        switch (selectOption) {

            case 1:

                chronosChronometerControl(initScanner);

                break;

            case 2:

                displayDateToUserWithChronos();

                break;

            case 3:

                displayTimeToUserWithChronos();

                break;

            case 4:

                changeMonthOrDaysWithChronos(initScanner);

                break;

            default:

                System.out.println("Select a valid option!");

                break;

        }

    }

    private static void displayDateToUserWithChronos () {

        System.out.println("Let's display the current date for u. \n");

        ChronosDate.showDateWithChronos();

    }

    private static void changeMonthOrDaysWithChronos (Scanner init) {

        System.out.println("Enter a year: ");

        int year = ScannerValidators.displayScannerValidator(init);

        System.out.println("Enter a month: ");

        int month = ScannerValidators.displayScannerValidator(init);

        System.out.println("Enter a day: ");

        int day = ScannerValidators.displayScannerValidator(init);

        ChronosDate.timeProgressionWithChronos(year, month, day);

    }

    private static void displayTimeToUserWithChronos () {

        System.out.println("Let's display the current time for u. \n");

        ChronosDate.showTimeWithChronos();

    }


    private static void chronosChronometerControl (Scanner initScanner) throws InterruptedException {

        ChronosEntity chronos = new ChronosEntity();

        System.out.println("Turning on the chronometer \n");

        System.out.println("Select the time u want the chronometer to stop: ");

        int millisTime = ScannerValidators.displayScannerValidator(initScanner);

        chronos.startChronos();

        Thread.sleep(millisTime);

        chronos.pauseChronos();

        chronos.resetChronos();

    }

}