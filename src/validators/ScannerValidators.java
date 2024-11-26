package validators;

import java.util.Scanner;

public class ScannerValidators {

    private static boolean verifyScannerInt (Scanner initScanner) {

        return initScanner.hasNextInt();

    }

    private static int validationScanner (Scanner initScanner) {

        while (!verifyScannerInt(initScanner)) {

            System.out.println("Enter a valid number!");

            initScanner.next();

        }

        return initScanner.nextInt();

    }

    public static int displayScannerValidator (Scanner initScanner) {

        return validationScanner(initScanner);

    }

}
