package validators;

public class ValidatorsPackage {

    public static void displayChronosControl (char userInput) {

        chronosControl(userInput);

    }

    private static void chronosControl (char userInput) {

        if (userInput != 'y' && userInput != 'Y') {

            System.out.println("See ya!");

            return;

        }

        System.out.println("Welcome!");

    }

}
