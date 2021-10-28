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
        culcSumMonthAverage(numMonth);
    }

    public static void checkYear(int number) {
        // первый метод проверит, второй - напечатает
        boolean checkYearForLeap = isLeapYear(number);
        printIsYearLeapResult(number, checkYearForLeap);
    }

    private static boolean isLeapYear(int number) {
        if (number % 400 == 0 || number % 4 == 0 && number % 100 != 0) {
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
        // первый метод проверит год, второй - ОСб третий - печатает
        boolean checkYearForOld = isYearOld(number);
        String clientOS = checkClientOS(os);
        printClientResult(clientOS, checkYearForOld);

    }

    private static boolean isYearOld(int number) {
        int currentYear = LocalDate.now().getYear();
        if (number < currentYear) {
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

    private static void printClientResult(String name, boolean isOld) {
        if (isOld) {
            System.out.println("Установите облегченную версию приложения для " + name + " по ссылке");
        } else {
            System.out.println("Установите  версию приложения для " + name + " по ссылке");
        }
    }

    public static void culcDeliveryDistance(int number) {
        // первый метод рассчитает, второй - напечатает
        int deliveryTime = culcDeliveryTime(number);
        printTimeResult(deliveryTime);
    }

    private static int culcDeliveryTime(int number) {
        int deliveryInitial = 1;
        int deliveryStep = 1;
        if (number <= 20) {
            return deliveryInitial;
        } else if (number <= 60) {
            return deliveryInitial + deliveryStep;
        } else if (number <= 100) {
            return deliveryInitial + deliveryStep * 2;
        } else {
            return deliveryInitial + deliveryStep * 3;
        }

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
        char arraySomeLetters[] = symbols.toCharArray();
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

    public static void culcSumMonthAverage(int number) {
        // первый метод определит число дней в месяце
        // второй сгенерит массив
        // третий расчитает итоговую сумму
        // четвертый  рассчитает среднее значение
        // пятый по традиции печатает;
        if (number > 12) {
            throw new RuntimeException("Некорректные данные для расчета!");
        }
        int dayInTheMonth = culcDayMonth(number);
        // Для получения массива случайных чисел
        int[] arr = generateRandomArray(dayInTheMonth);
        int sumMonth = calcSumMonth(arr);
        float sumAverage = calcsumAverage(sumMonth, dayInTheMonth);
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

    private static int culcDayMonth(int number) {
        int dayNumber = 0;
        switch (number) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayNumber = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayNumber = 30;
                break;
            case 2:
                dayNumber = 28;
                break;
        }
        return dayNumber;
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



