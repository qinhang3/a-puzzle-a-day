package win.qinhang3.apad;

import win.qinhang3.apad.suit.NormalSuit;
import win.qinhang3.apad.suit.Suit;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
public class Main {
    private static final ImageUtil imageUtil = new ImageUtil(10);

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        Suit suit = new NormalSuit();
        suit.getMap().target(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")));
//        Collections.shuffle(suit.getPieces());
        suit.run((map,finish) -> {
            imageUtil.add(map);
            BufferedImage draw = imageUtil.draw();
            try {
                ImageIO.write(draw, "png", new File("today.png"));
                finish.set(false);
            } catch (Exception e){
                e.printStackTrace();
            }
//            System.exit(0);
        });
        System.out.println(System.currentTimeMillis() - start);
    }


}
