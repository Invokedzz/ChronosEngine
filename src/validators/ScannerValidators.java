package validators;

import java.util.Scanner;

public class ScannerValidators {

    private static boolean verifyScannerInt (Scanner initScanner) {

        return initScanner.hasNextInt();

    }

    private static boolean verifyScannerLong (Scanner initScanner) {

        return initScanner.hasNextLong();

    }

    private static long validationScannerForLong (Scanner initScanner) {

        while (!verifyScannerLong(initScanner)) {

            System.out.println("Enter a valid number!");

            initScanner.next();

        }

        return initScanner.nextLong();

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

    public static long displayScannerValidatorLong (Scanner initScanner) {

        return validationScannerForLong(initScanner);

    }

}
