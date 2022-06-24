package Practice;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageDownloder {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://plantic.in/image/total-plant-care1.jpg");
        BufferedImage img = ImageIO.read(url);
        File file = new File("downloaded.jpg");
        ImageIO.write(img, "jpg", file);
    }
}
