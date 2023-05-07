import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Display {
    private JFrame frame;
    private Pixel[][] pixels;
    private final int size;

    public static void draw(boolean[][] booleans, int size) {
        Display display = new Display(booleans, size);
        display.drawField();
    }

    public static void drawConsole(boolean[][] booleans) {
        for (int y = 0; y < booleans[0].length; y++) {
            for (boolean[] aBoolean : booleans) {
                System.out.print(aBoolean[y] ? "◾" : "◽");
            }
            System.out.println();
        }
    }

    public Display(boolean[][] booleans, int size) {
        this.size = size;
        translateBooleanToPixel(booleans);
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Circle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(pixels[0].length, pixels.length, 0, 0));
    }

    private void translateBooleanToPixel(boolean[][] booleans) {
        this.pixels = new Pixel[booleans.length][booleans[0].length];
        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans[0].length; j++) {
                this.pixels[i][j] = booleans[i][j] ? Pixel.BLACK : Pixel.WHITE;
            }
        }
    }

    private void drawField() {
        for (int y = 0; y < pixels[0].length; y++) {
            for (int x = 0; x < pixels.length; x++) {
                JComponent comp = pixels[x][y].getIcon();
                comp.setToolTipText(pixels[x][y].toString() + ", " + x + ", " + y);
                frame.getContentPane().add(comp);
            }
        }
        frame.setSize(size, size);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private enum Pixel {
        WHITE, BLACK;

        public JComponent getIcon() {
            JPanel p = new JPanel();
            int size = 75;
            p.setPreferredSize(new Dimension(size, size));
            switch (this) {
                case WHITE -> p.setBackground(Color.WHITE);
                case BLACK -> p.setBackground(Color.DARK_GRAY);
                default -> {
                }
            }
            return p;
        }

        @Override
        public String toString() {
            return switch (this) {
                case BLACK -> "black";
                case WHITE -> "white";
                default -> "";
            };
        }
    }
}
