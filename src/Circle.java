public class Circle {

    public static boolean[][] circleWithSinAndCos(int size, int radius, int xCenter, int yCenter) {
        double TAU = 2 * Math.PI;
        boolean[][] pixels = new boolean[size][size];
        int numberOfPixels = (int) TAU * radius;

        for (int i = 0; i < numberOfPixels; i++) {
            pixels[(int) (Math.round(radius * Math.cos((TAU * i) / numberOfPixels)) + xCenter)]
                    [(int) (Math.round(radius * Math.sin((TAU * i) / numberOfPixels)) + yCenter)] = true;
        }

        return pixels;
    }

    public static boolean[][] circleWithSinAndCos2(int sizeX, int sizeY, int radius, int xCenter, int yCenter) {
        double PHI = 2 * Math.PI;
        boolean[][] pixels = new boolean[sizeX][sizeY];
        int numberOfPixels = (int) PHI * radius;

        for (int i = 0; i < numberOfPixels; i++) {
            pixels[(int) (Math.round(radius * Math.cos((PHI * i) / numberOfPixels)) + xCenter)]
                    [(int) (Math.round(radius * Math.sin((PHI * i) / numberOfPixels)) + yCenter)] = true;
        }

        return pixels;
    }

    public static boolean[][] circleWithSquareRoot(int size, int radius, int xCenter, int yCenter) {
        boolean[][] pixels = new boolean[size][size];

        for (int x = -radius; x < radius; x++) {
            int y = (int) Math.sqrt(radius * radius - x * x);
            pixels[x + xCenter][y + yCenter] = true;
            pixels[x + xCenter][-y + yCenter] = true;
        }

        return pixels;
    }

    public static boolean[][] circleWithSquareRootGood(int size, int radius, int xCenter, int yCenter) {
        boolean[][] pixels = new boolean[size][size];

        for (int x = 0; x < radius * 0.850903524534; x++) {
            int y = (int) Math.sqrt(radius * radius - x * x);
            pixels[x + xCenter][y + yCenter] = pixels[x + xCenter][-y + yCenter] =
                    pixels[y + xCenter][x + yCenter] = pixels[y + xCenter][-x + yCenter] =
                            pixels[-x + xCenter][y + yCenter] = pixels[-x + xCenter][-y + yCenter] =
                                    pixels[-y + xCenter][x + yCenter] = pixels[-y + xCenter][-x + yCenter] = true;
        }

        return pixels;
    }

    public static boolean[][] circleWithMultiplication(int size, int radius, int xCenter, int yCenter) {
        boolean[][] pixels = new boolean[size][size];

        int x = 0;
        int y = radius;
        pixels[xCenter][radius + yCenter] = pixels[radius + xCenter][yCenter] =
                pixels[xCenter][-radius + yCenter] = pixels[-radius + xCenter][yCenter] = true;

        float f = 5f / 4f - radius;

        while (x < y) {
            if (f < 0) {
                f = f + 2 * x + 1;
            } else {
                f = f + 2 * x - 2 * y + 2;
                y--;
            }
            x++;

            pixels[x + xCenter][y + yCenter] = pixels[-x + xCenter][y + yCenter] =
                    pixels[-y + xCenter][x + yCenter] = pixels[-y + xCenter][-x + yCenter] =
                            pixels[y + xCenter][x + yCenter] = pixels[y + xCenter][-x + yCenter] =
                                    pixels[x + xCenter][-y + yCenter] = pixels[-x + xCenter][-y + yCenter] = true;
        }

        return pixels;
    }

    public static boolean[][] circleWithAdditionAndSubtraction(int size, int radius, int xCenter, int yCenter) {
        boolean[][] pixels = new boolean[size][size];
        int x = 0;
        int y = radius;
        pixels[xCenter][radius + yCenter] = pixels[radius + xCenter][yCenter] =
                pixels[xCenter][-radius + yCenter] = pixels[-radius + xCenter][yCenter] = true;

        int f = 1 - radius;
        int de = 1;
        int dse = 2 - radius - radius;

        while (x < y) {
            if (f < 0) {
                f += de;
                dse += 2;
            } else {
                f += dse;
                dse += 4;
                y--;
            }
            x++;
            de += 2;

            pixels[x + xCenter][y + yCenter] = pixels[-x + xCenter][y + yCenter] =
                    pixels[-y + xCenter][x + yCenter] = pixels[-y + xCenter][-x + yCenter] =
                            pixels[y + xCenter][x + yCenter] = pixels[y + xCenter][-x + yCenter] =
                                    pixels[x + xCenter][-y + yCenter] = pixels[-x + xCenter][-y + yCenter] = true;
        }
        return pixels;
    }
}
