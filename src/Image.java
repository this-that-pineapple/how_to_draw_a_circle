import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.File;

public class Image {
    public static void save(boolean[][] pixels, String filename) {
        int[] pixelsInt = new int[pixels.length * pixels[0].length];
        for (int y = 0; y < pixels[0].length; y++){
            for (int x = 0; x < pixels.length; x++){
                //4 bytes per pixel: alpha, red, green, blue
                pixelsInt[x * pixels[0].length + y] = pixels[x][y] ? 0xFFFFFFFF : 0;
            }
        }

        try{
            BufferedImage bufferedImage = new BufferedImage(pixels[0].length, pixels.length, BufferedImage.TYPE_INT_ARGB);
            bufferedImage.setRGB(0, 0, pixels[0].length, pixels.length, pixelsInt, 0, pixels[0].length);
            ImageIO.write(bufferedImage, "png", new File(filename + ".png"));

        }catch (Exception e){
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
    }
}
