import java.time.LocalDate;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Задание 1
        System.out.println("// Задание 1");
        int yearForCheck = 3014;
        checkYear(yearForCheck);
        // Задание 2
        System.out.println("// Задание 2");
        int yearOfThePhone = 2019;
        byte clientOS = 0;  // iOS is better
        checkYearAndOs(yearOfThePhone, clientOS);
        // Задание 3
        System.out.println("// Задание 3");
        int deliveryDistance = 95;
        culcDeliveryDistance(deliveryDistance);
        // Задание 4
        System.out.println("// Задание 4");
        String someLetters = "aabccddefgghiijjkk";
        checkDouble(someLetters);
        // Задание 5
        System.out.println("// Задание 5");
        int[] firstArray = {5, 8, 2, 3, 9};
        makeReverse(firstArray);
        // Задание 6
        System.out.println("// Задание 6");
        int numMonth = 12;
        if (numMonth > 12) {
            throw new RuntimeException("Некорректные данные для расчета!");
        }
        // Для получения массива случайных чисел
        int[] arr = generateRandomArray(culcDayMonth(numMonth));
        culcSumMonthAverage(arr);
    }

    public static void checkYear(int year) {
        // первый метод проверит, второй - напечатает
        boolean checkYearForLeap = isLeapYear(year);
        printIsYearLeapResult(year, checkYearForLeap);
    }
    
    private static boolean isLeapYear(int year) {
        if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            return false;
        }
    }
    
    private static void printIsYearLeapResult(int number, boolean isLeap) {
        if (isLeap) {
            System.out.println("Год  " + number + " является високосным");
        } else {
            System.out.println("Год " + number + " не является високосным");
        }
    }

    public static void checkYearAndOs(int number, byte os) {
        // первый метод проверит год, второй - ОС, третий - печатает
        boolean checkYearForOld = isYearOld(number);
        String clientOS = checkClientOS(os);
        printClientResult(clientOS, checkYearForOld);

    }

    private static boolean isYearOld(int year) {
        int currentYear = LocalDate.now().getYear();
        if (year < currentYear) {
            return true;
        }
        return false;
    }

    private static String checkClientOS(byte os) {
        int currentYear = LocalDate.now().getYear();
        if (os == 0) {
            return "iOS";
        }
        return "Android";
    }

    private static void printClientResult(String os, boolean isOld) {
        if (isOld) {
            System.out.println("Установите облегченную версию приложения для " + os + " по ссылке");
        } else {
            System.out.println("Установите  версию приложения для " + os + " по ссылке");
        }
    }

    public static void culcDeliveryDistance(int number) {
        // первый метод рассчитает, второй - напечатает
        int deliveryTime = culcDeliveryTime(number);
        printTimeResult(deliveryTime);
    }

    private static int culcDeliveryTime(int number) {
        int deliveryDay = 1;
        if (number > 20 && number <= 60) {
            deliveryDay =  deliveryDay * 2;
        } else if (number > 60 && number <= 100) {
            deliveryDay =  deliveryDay  * 3;
        } else {
            deliveryDay =  deliveryDay  * 4;
        }
         return deliveryDay;
    }

    private static void printTimeResult(int number) {
        System.out.println("Потребуется дней: " + number);
    }

    public static void checkDouble(String symbols) {
        // первый метод проверит дубли, второй - напечатает
        char doubleSymbol = findDoubleSymbol(symbols);
        printIsDoubleSymbol(doubleSymbol);
    }

    private static char findDoubleSymbol(String symbols) {
        char [] arraySomeLetters = symbols.toCharArray();
        for (int i = 0; i < arraySomeLetters.length - 1; ++i) {
            if (arraySomeLetters[i] == arraySomeLetters[i + 1]) {
                return arraySomeLetters[i];
            }
        }
        return ' ';
    }

    private static void printIsDoubleSymbol(char letter) {
        if (Character.isLetter(letter)) {
            System.out.println("В строке дублируется символ " + letter);
        } else {
            System.out.println("В строке нет дублей!");
        }
    }

    public static void makeReverse(int[] arrayUsing) {
        // первый метод перевернет, второй - напечатает
        printArray(arrayUsing);
        reverseArray(arrayUsing);
        printArray(arrayUsing);
    }

    private static void reverseArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // одна итерация = один сдвиг
            int tmpValue = array[0];
            for (int j = 1; j < array.length - i; j++) {
                array[j - 1] = array[j];
            }
            array[array.length - 1 - i] = tmpValue;
        }
    }

    private static void printArray(int[] array) {
        System.out.println("Массив " + Arrays.toString(array));
    }

    public static void culcSumMonthAverage(int [] arrMonth) {
        // первый метод расчитает итоговую сумму
        // второй рассчитает среднее значение
        // третий по традиции печатает;

        int sumMonth = calcSumMonth(arrMonth);
        float sumAverage = calcsumAverage(sumMonth, arrMonth.length);
        printSumAverage(sumAverage);
    }

    public static int[] generateRandomArray(int number) {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[number];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    private static int culcDayMonth(int numberMonth) {
        switch (numberMonth) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return 28;
            default:
                return 30;
        }
    }
    private static int calcSumMonth(int[] arr) {
        int sumMonth = 0;
        for (int item : arr) {
            sumMonth += item;
        }
        return sumMonth;
    }
    private static void printSumAverage(float sum) {
        System.out.println("Средняя сумма трат за месяц составила " + sum);
    }
    private static float calcsumAverage(int sum, int number) {
        float result = 0.0f;
        result = sum * 1.0f/ number;
        return result;
    }
}



