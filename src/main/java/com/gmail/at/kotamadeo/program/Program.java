package com.gmail.at.kotamadeo.program;

import com.gmail.at.kotamadeo.figures.Circle;
import com.gmail.at.kotamadeo.figures.Rectangle;
import com.gmail.at.kotamadeo.figures.Square;
import com.gmail.at.kotamadeo.figures.Triangle;
import com.gmail.at.kotamadeo.utils.Utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int input;
        while (true) {
            try {
                printMenu();
                input = scanner.nextInt();
                if (input == 0) {
                    scanner.close();
                    break;
                } else {
                    switch (input) {
                        case 1:
                            var circle = new Circle("круг");
                            circle.programLogic();
                            System.out.println();
                            break;
                        case 2:
                            var square = new Square("квадрат");
                            square.programLogic();
                            System.out.println();
                            break;
                        case 3:
                            var triangle = new Triangle("треугольник");
                            triangle.programLogic();
                            System.out.println();
                            break;
                        case 4:
                            var rectangle = new Rectangle("прямоугольник");
                            rectangle.programLogic();
                            System.out.println();
                            break;
                        default:
                            System.out.println(Utils.ANSI_RED + "Вы ввели неверный номер операции!" + Utils.ANSI_RESET);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println(Utils.ANSI_RED + "Неверный ввод!" + Utils.ANSI_RESET);
                break;
            }
        }
    }

    private void printMenu() {
        System.out.println(Utils.ANSI_YELLOW + "Эта программа способна вычислить периметр и площадь геометрических " +
                "фигур." + Utils.ANSI_RESET);
        System.out.println(Utils.ANSI_PURPLE + "Возможные команды программы:" + Utils.ANSI_RESET);
        System.out.println("0: чтобы выйти из программы.");
        System.out.println("1: выбрать круг.");
        System.out.println("2: выбрать квадрат.");
        System.out.println("3: выбрать треугольник.");
        System.out.println("4: выбрать прямоугольник.");
        System.out.print(">>>>>>>");
    }
}
