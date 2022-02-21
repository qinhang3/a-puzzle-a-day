package win.qinhang3.apad;

import com.google.common.collect.Sets;
import win.qinhang3.apad.piece.Piece;
import win.qinhang3.apad.suit.DemoSuit;
import win.qinhang3.apad.suit.NormalSuit;
import win.qinhang3.apad.suit.Suit;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
public class Main {
    private Consumer<Map> callback;

    private static final ImageUtil imageUtil = new ImageUtil(1);

    public static void main(String[] args) throws IOException {
        Suit suit = new NormalSuit();
        suit.getMap().target(Calendar.getInstance());
        Collections.shuffle(suit.getPieces());
        suit.run(map -> {
            imageUtil.add(map);
            BufferedImage draw = imageUtil.draw();
            try {
                ImageIO.write(draw, "png", new File("test.png"));
            } catch (Exception e){
                e.printStackTrace();
            }
            System.exit(0);
        });
    }


}
