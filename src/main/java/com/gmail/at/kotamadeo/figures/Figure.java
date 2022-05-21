package com.gmail.at.kotamadeo.figures;

import com.gmail.at.kotamadeo.utils.Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

abstract class Figure {
    protected final Scanner scanner = new Scanner(System.in);
    protected final double P = 3.14;
    protected String input;
    protected String name;
    protected String color;
    protected int operationNumber;
    protected double side;
    protected double resultArea;
    protected double resultPerimeter;

    protected Figure(String name) {
        this.name = name;
    }

    abstract void calculateArea();

    abstract void calculatePerimeter();

    protected void printResult() {
        System.out.println(Utils.ANSI_GREEN + "Площадь фигуры " + name + " равна: "
                + resultArea + " см²." + Utils.ANSI_RESET);
        System.out.println(Utils.ANSI_GREEN + "Периметр фигуры " + name + " равен: "
                + resultPerimeter + " см." + Utils.ANSI_RESET);
    }

    protected void round() {
        var resultAreaRound = BigDecimal.valueOf(resultArea);
        var resultPerimeterRound = BigDecimal.valueOf(resultPerimeter);
        System.out.println(Utils.ANSI_BLUE + "Результат округления площади фигуры " + name + " составляющей " +
                resultArea + " см². равен: " + resultAreaRound.setScale(0, RoundingMode.HALF_UP) + " см²." +
                Utils.ANSI_RESET);
        System.out.println(Utils.ANSI_BLUE + "Результат округления периметра фигуры " + name + " составляющей " +
                resultPerimeter + " см. равен: " + resultPerimeterRound.setScale(0, RoundingMode.HALF_UP)
                + " см." + Utils.ANSI_RESET);
    }

    abstract void printSubMenu();

    abstract void programLogic();

    protected void setColor(String color) {
        String[] colors = {"черный", "красный", "зеленый", "белый", "желтый", "фиолетовый", "циановый", "голубой"};
        if (color.length() != 0) {
            for (var i = 0; i < colors.length; i++) {
                String colorFromArray = colors[i];
                if (color.equalsIgnoreCase(colorFromArray)) {
                    this.color = color;
                    System.out.println("Цвет " + color + " задан.");
                }
            }
        } else {
            System.out.printf("%sТакого цвета: %s нет!%n%s", Utils.ANSI_RED, color, Utils.ANSI_RESET);
        }
    }

    @Override
    public String toString() {
        if (color != null) {
            if (color.equalsIgnoreCase("белый")) {
                return Utils.ANSI_WHITE + "Фигура: " + name + " цвета: " + color + " имеет площадь: "
                        + resultArea + " см². и периметр: " + resultPerimeter + " см." + Utils.ANSI_RESET;
            } else if (color.equalsIgnoreCase("черный")) {
                return Utils.ANSI_BLACK + "Фигура: " + name + " цвета: " + color + " имеет площадь: "
                        + resultArea + " см². и периметр: " + resultPerimeter + " см." + Utils.ANSI_RESET;
            } else if (color.equalsIgnoreCase("красный")) {
                return Utils.ANSI_RED + "Фигура: " + name + " цвета: " + color + " имеет площадь: "
                        + resultArea + " см². и периметр: " + resultPerimeter + " см." + Utils.ANSI_RESET;
            } else if (color.equalsIgnoreCase("циановый")) {
                return Utils.ANSI_CYAN + "Фигура: " + name + " цвета: " + color + " имеет площадь: "
                        + resultArea + " см². и периметр: " + resultPerimeter + " см." + Utils.ANSI_RESET;
            } else if (color.equalsIgnoreCase("зеленый")) {
                return Utils.ANSI_GREEN + "Фигура: " + name + " цвета: " + color + " имеет площадь: "
                        + resultArea + " см². и периметр: " + resultPerimeter + " см." + Utils.ANSI_RESET;
            } else if (color.equalsIgnoreCase("желтый")) {
                return Utils.ANSI_YELLOW + "Фигура: " + name + " цвета: " + color + " имеет площадь: "
                        + resultArea + " см². и периметр: " + resultPerimeter + " см." + Utils.ANSI_RESET;
            } else if (color.equalsIgnoreCase("фиолетовый")) {
                return Utils.ANSI_PURPLE + "Фигура: " + name + " цвета: " + color + " имеет площадь: "
                        + resultArea + " см². и периметр: " + resultPerimeter + " см." + Utils.ANSI_RESET;
            } else if (color.equalsIgnoreCase("голубой")) {
                return Utils.ANSI_BLUE + "Фигура: " + name + " цвета: " + color + " имеет площадь: "
                        + resultArea + " см². и периметр: " + resultPerimeter + " см." + Utils.ANSI_RESET;
            }
        } else {
            return "фигура: " + name + " цвет не задан " + " имеет площадь: " + resultArea + " см². и периметр: " +
                    resultPerimeter + " см.";
        }
        return null;
    }
}

