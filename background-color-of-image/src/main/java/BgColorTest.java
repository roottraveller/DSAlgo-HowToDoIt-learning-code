import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BgColorTest {

    public static void main(String[] args) throws IOException {
        for (int index = 1; index <= 10; ++index) {
            String inputFileName = "/Users/300067846/Pictures/bgcolortest/" + index + ".jpg";
            File imageFile = new File(inputFileName);

            BufferedImage img = ImageIO.read(imageFile);
            int rgb = img.getRGB(5, 5);
            Color color = new Color(rgb);
            String hex = "rgb(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ')';
            System.out.println(index + "= " + hex);
        }
    }
}
