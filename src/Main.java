public class Main {
    public static void main(String[] args) {
        int size = 100;
//        boolean[][] pixels = Circle.circleWithSinAndCos(size + 1, size / 2, size / 2, size / 2);

        boolean[][] pix = Circle.circleWithSinAndCos(100, 20, 30, 20);
        Display.draw(pix, 800);
//        Display.drawConsole(pixels);
    }
}