public class Main {
    public static void main(String[] args) {
        int x1 = 7;
        int y1 = 12;
        int x2 = 3;
        int y2 = 12;
        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
        System.out.println("Equation: " + equation.equation());
        System.out.println("Slope: " + equation.slope());
        System.out.println("y-intercept: " + equation.yIntercept());
        System.out.println("Distance: " + equation.distance());
        System.out.println();
        System.out.println("----- Line info -----");
        System.out.println(equation.lineInfo());
        System.out.println();
        double testX = 4;
        System.out.println("Coordi``nate for x: " + equation.coordinateForX(testX));


    }
}