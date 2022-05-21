# **Задача №2 Расчет площади круга и длины его окружности**

## **Цель**:

1. Написать программу для для вычисления площади круга и длины произвольной окружности по заданному радиусу. Напомним,
   что площадь круга вычисляется по формуле: ```π x R² (константу π можно считать равной 3.14)```, а формула вычисления
   длины его окружности: ```2 x π x R```.

### *Пример*:

``` Пример 1
Введите радиус окружности в сантиметрах:
10 <enter>
Площадь круга: 314 см.кв.
Длина окружности: 62.8 см.
```

### **Моя реализация**:

1. Реализация осуществлена в парадигме ООП.
2. Создал структуру классов:

* **Program** - отвечающий за запуск программы, путем инициирования метода *start()* (с инициированием внутри себя
  вспомогательного метода *printMenu()*);

#### Класс **Program**:
``` java
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
```

* Абстрактный класс **Figure**, описывающий общую логику методов необходимых для классов **Circle**, **Square**, **Triangle** и
  **Rectangle**;

#### Класс **Figure**:
``` java
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
```

4. Реализовал возможность расчета формул периметра и площади для разных фигур посредством полиморфизма
   (см. вывод в консоль).
5. Использовал ```BigDecimal``` для верного округления дробных чисел.
6. Использовал ```try-catch```, чтобы избежать падение программы в исключения.

#### Метод *main()* в классе **Main**:
``` java
public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.start();
    }
}
```

## *Вывод в консоль*:

* Главное меню:
``` 
Эта программа способна вычислить периметр и площадь геометрических фигур.
Возможные команды программы:
0: чтобы выйти из программы.
1: выбрать круг.
2: выбрать квадрат.
3: выбрать треугольник.
4: выбрать прямоугольник.
>>>>>>>
```

* Подменю для круга:
```
Вы выбрали круг.
Возможные команды программы:
0 или выход: чтобы выйти из программы в главное меню.
1: ввести радиус.
2: рассчитать площадь и периметр фигуры.
3: вывести рассчитанный результат площади и периметра.
4: округлить площадь и периметр до целых чисел.
5: задать цвет фигуры.
6: вывести полную информацию о фигуре.
>>>>>>>
```

* Подменю для квадрата:
```
Вы выбрали квадрат.
Возможные команды программы:
0 или выход: чтобы выйти из программы в главное меню.
1: ввести длину сторону.
2: рассчитать площадь и периметр фигуры.
3: вывести рассчитанный результат площади и периметра.
4: округлить площадь и периметр до целых чисел.
5: задать цвет фигуры.
6: вывести полную информацию о фигуре.
>>>>>>>
```

* Подменю для треугольника:
```
Вы выбрали треугольник.
Возможные команды программы:
0 или выход: чтобы выйти из программы в главное меню.
1: ввести длины сторон (a,b,c) через пробел.
2: рассчитать площадь и периметр фигуры.
3: вывести рассчитанный результат площади и периметра.
4: округлить площадь и периметр до целых чисел.
5: задать цвет фигуры.
6: вывести полную информацию о фигуре.
>>>>>>>
```

* Подменю для прямоугольника:
```
  Вы выбрали прямоугольник.
  Возможные команды программы:
  0 или выход: чтобы выйти из программы в главное меню.
  1: ввести длины сторон (a, b) через пробел.
  2: рассчитать площадь и периметр фигуры.
  3: вывести рассчитанный результат площади и периметра.
  4: округлить площадь и периметр до целых чисел.
  5: задать цвет фигуры.
  6: вывести полную информацию о фигуре.
```