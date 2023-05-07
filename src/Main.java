public class Main {
    public static void main(String[] args) {
        boolean eval = false;
        int size = 100;
        boolean[][] pixels = Circle.circleWithSquareRootGood(size + 1, size / 2, size / 2, size / 2);

        Display.draw(pixels, 800);

        if (eval){
            System.out.println("Evaluation");
            System.out.println("Circle with Sin and Cos");
            Evaluation.timeOverAllRanges(Circle::circleWithSinAndCos, 1000000);

            System.out.println("Circle with Square Root");
            Evaluation.timeOverAllRanges(Circle::circleWithSquareRoot, 1000000);

            System.out.println("Circle with Square Root Good");
            Evaluation.timeOverAllRanges(Circle::circleWithSquareRootGood, 1000000);

            System.out.println("Circle with multiplication");
            Evaluation.timeOverAllRanges(Circle::circleWithMultiplication, 1000000);

            System.out.println("Circle with Addition and Subtraction");
            Evaluation.timeOverAllRanges(Circle::circleWithAdditionAndSubtraction, 1000000);
        }
    }
}