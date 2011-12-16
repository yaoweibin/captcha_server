
import java.io.File;
import java.util.Random; 
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

class Captcha {

    public static String getRandomString(int length) {

        String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        return sb.toString();
    }

    public static void main(String args[]) throws java.io.IOException {

        ImageCaptchaGenerator gen = new ImageCaptchaGenerator();

        for (int i = 0; i < 10000; i++) {
            String word = getRandomString(7);
            BufferedImage bi = gen.getImage(word);
            String filename = "img/" + word + ".jpg";
            File out = new File(filename);
            ImageIO.write(bi, "jpg", out); 
        }
    }
}
