package validators;

public class DateValidator {

    public static int [] grabDateElements (int year, int month, int day) {

        year = validateYear(year);

        month = validateMonth(month);

        day = validateDay(day);

        return new int[]{year, month, day};

    }

    private static int validateYear (int year) {

        if (year > 2024) {

            System.out.println("Enter a valid value!");

            return 2024;

        }

        return year;

    }

    private static int validateMonth (int month) {

        if (month > 12) {

            System.out.println("Enter a valid value!");

            return 12;

        }

        return month;

    }

    private static int validateDay (int day) {

        if (day <= 0 || day > 31) {

            System.out.println("Enter a valid value!");

            return 31;

        }

        return day;

    }

}
