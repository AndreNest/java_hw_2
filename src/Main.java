//Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

public class Main {

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getGlobal();
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        logger.setUseParentHandlers(false);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);
        boolean flag = true;
        System.err.println("Программа запущена!");
        logger.info("Start program!");
        while (flag == true){
            Scanner iScanner = new Scanner(System.in);
            logger.info("Открыто главное меню");
            System.out.println(" 1 - Сложение двух чисел \n" +
                               " 2 - Умножение двух чисел? \n " +
                               "3 - Возведение числа во вторую степень?\n " +
                               "4 - факториал числа\n " +
                               "5 - сортировка массива пузырьком \n " +
                               "6 - завершить работу");
            System.out.print("Какое действие выполним? ");

            int n = iScanner.nextInt();
            switch (n) {
                case 1:
                    System.out.printf("Введите первое число: ");
                    int a_sum = iScanner.nextInt();
                    logger.info("Пользователь ввел: "+ a_sum);
                    System.out.printf("Введите второе число: ");
                    int b_sum = iScanner.nextInt();
                    logger.info("Пользователь ввел: "+ b_sum);
                    System.out.printf("%d + %d = %d \n", a_sum, b_sum, MyLib.sum(a_sum, b_sum));
                    logger.info("Ответ = " + (a_sum+b_sum));
                    break;
                case 2:
                    System.out.printf("Введите первое число: ");
                    int a_mult = iScanner.nextInt();
                    System.out.printf("Введите второе число: ");
                    int b_mult = iScanner.nextInt();
                    System.out.printf("%d * %d = %d \n", a_mult, b_mult, MyLib.mult(a_mult, b_mult));
                    break;
                case 3:
                    System.out.printf("Введите число: ");
                    int a_mult_x2 = iScanner.nextInt();
                    System.out.printf("Число %d во второй степени равно =  %d\n", a_mult_x2, (int)Math.pow(a_mult_x2, 2));
                    break;
                case 4:
                    System.out.printf("Введите число: ");
                    int fact = iScanner.nextInt();
                    System.out.printf("Факториал числа %d =  %d\n",fact, MyLib.fact(fact) );
                    break;
                case 5:
                    MyLib.sortBobble();
                    break;
                case 6:
                    System.err.println("Программа выключена!");
                    logger.info("Stop program.");
                    flag = false;
                    break;

            }

        }
    }
}