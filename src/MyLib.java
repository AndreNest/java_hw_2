import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public class MyLib {
    static void sortBobble() throws IOException {
        Logger logger = Logger.getGlobal();
        FileHandler fh = new FileHandler("log.txt");
        logger.setUseParentHandlers(false);
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        logger.info("Пользователь зашел в меню пузырьковой сортировки: ");
        int m = MyLib.insertInt("Сколько чисел будет введено в массив? ");
        logger.info("Пульзователь будет вводить: "+ m + " чисел.");
        int [] array = new int[m];
        for (int i = 0; i < m; i++) {
            String newText = "Введите число №";
            newText= newText + (i + 1) + " ";
            array[i] = MyLib.insertInt(newText);
            logger.info("Пульзователь ввел: "+ array[i]);
        }
        System.out.println("Полученный массив");
        printArray(array);
        System.out.println();
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                    logger.info("Цикл № "+ i);
                    logger.info(array[i]+ " меняем местами с " + array[i + 1]);
                }
            }
        }
        System.out.println("Отсортированный массив");
        printArray(array);
        System.out.println();
    }
    static int insertInt(String text) throws IOException {
        Logger logger = Logger.getGlobal();
        FileHandler fh = new FileHandler("log.txt");
        logger.setUseParentHandlers(false);
        logger.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);

        int num = 0;

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print(text);
            num = scanner.nextInt();
            logger.info("опльзователь ввел: " + num);
            return num;
        }
        catch (Exception exception) {
            logger.info("ошибка опльзователь ввел: " + num);
            System.err.println("ОШИБКА! Вы ввели не число!");
        }
        return insertInt("Введите число: ");
    }

    static void printArray(int[] array){
        for (int i = 0; i < array.length ; i++) {
            System.out.printf("%d  ",array[i]);
        }
    }
    static int fact(int n) {
        if (n == 1)
            return 1;
        return n * fact(n - 1);
    }

    static int sum(int a, int b){
        return a + b;
    }

    static int mult(int a, int b){
        return a * b;
    }
}
