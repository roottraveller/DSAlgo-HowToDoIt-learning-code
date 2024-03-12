
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageCropTest {
    public static void main(String[] args) throws IOException {

        BufferedImage originalImg = ImageIO.read(new File("/Users/gussi_user/Desktop/cronimagetest/test-image1.png"));
        cronAndSaveImage(originalImg, 270, 130, 100, 100);
        cronAndSaveImage(originalImg, 290, 50, 100, 100);
        cronAndSaveImage(originalImg, 100, 400, 100, 100);
        cronAndSaveImage(originalImg, 220, 630, 100, 100);

    }

    private static void cronAndSaveImage(BufferedImage originalImg, int x, int y, int w, int h) {
        try {
            BufferedImage subImg = originalImg.getSubimage(x, y, w, h);
            System.out.println("originalImg=" + originalImg.getWidth() + " " + originalImg.getHeight());
            System.out.println("subImg=" + subImg.getWidth() + " " + subImg.getHeight());

            String postFix = String.format("%dx%d_%dx%d", x, y, w, h);
            File pathFile = new File(String.format("/Users/gussi_user/Desktop/cronimagetest/ImageCropped%s.png", postFix));
            boolean output = ImageIO.write(subImg, "png", pathFile);
            if (output) {
                System.out.println("Cropped Image created successfully");
            } else {
                System.out.println(output);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
