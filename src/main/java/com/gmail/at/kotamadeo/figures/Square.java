package com.gmail.at.kotamadeo.figures;

import com.gmail.at.kotamadeo.utils.Utils;

public class Square extends Figure {

    public Square(String name) {
        super(name);
    }

    @Override
    protected void calculateArea() {
        resultArea = side * side;
    }

    @Override
    protected void calculatePerimeter() {
        resultPerimeter = 4 * side;
    }

    @Override
    protected void printSubMenu() {
        System.out.println(Utils.ANSI_YELLOW + "Вы выбрали квадрат." + Utils.ANSI_RESET);
        System.out.println(Utils.ANSI_PURPLE + "Возможные команды программы:" + Utils.ANSI_RESET);
        System.out.println("0 или выход: чтобы выйти из программы в главное меню.");
        System.out.println("1: ввести длину сторону.");
        System.out.println("2: рассчитать площадь и периметр фигуры.");
        System.out.println("3: округлить площадь и периметр до целых чисел.");
        System.out.println("4: задать цвет фигуры.");
        System.out.println("5: вывести полную информацию о фигуре.");
        System.out.print(">>>>>>>");
    }

    @Override
    public void programLogic() {
        while (true) {
            try {
                printSubMenu();
                input = scanner.nextLine();
                if ("0".equals(input) || "выход".equalsIgnoreCase(input)) {
                    break;
                } else {
                    operationNumber = Integer.parseInt(input);
                    switch (operationNumber) {
                        case 1:
                            System.out.println(Utils.ANSI_BLUE + "Введите длину стороны:" + Utils.ANSI_RESET);
                            input = scanner.nextLine();
                            side = Double.parseDouble(input);
                            break;
                        case 2:
                            calculateArea();
                            calculatePerimeter();
                            printResult();
                            break;
                        case 3:
                            round();
                            break;
                        case 4:
                            System.out.println(Utils.ANSI_BLUE + "Введите цвет фигуры:" + Utils.ANSI_RESET);
                            input = scanner.nextLine();
                            setColor(input);
                            break;
                        case 5:
                            System.out.println(this);
                            break;
                        default:
                            System.out.println(Utils.ANSI_RED + "Вы ввели неверный номер операции!" + Utils.ANSI_RESET);
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(Utils.ANSI_RED + "Неверный ввод!" + Utils.ANSI_RESET);
            }
        }
    }
}
