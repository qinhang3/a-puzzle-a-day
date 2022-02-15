package win.qinhang3.apad;

import win.qinhang3.apad.map.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/14
 **/
public class ImageUtil {
    private static int C = 10;
    private static Color[] colors = {Color.CYAN, Color.YELLOW, Color.BLUE, Color.GREEN, Color.RED, Color.PINK, Color.ORANGE, Color.MAGENTA};

    private static java.util.List<Map> maps = new ArrayList<>();

    public static void draw(Map map){
        maps.add(map.copy());
        int count = maps.size();

        int R = count / C;
        if (count % C > 0){
            R++;
        }
        BufferedImage newBuf = new BufferedImage(C * 80 + 10, R * 80 + 10, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = newBuf.createGraphics();
        for (int n = 0; n < maps.size(); n++) {
            int tx = (n % C) * 80 + 10;
            int ty = (n / C) * 80 + 10;
            graphics.setColor(Color.BLACK);
            graphics.fillRect(tx,ty, 70, 70);
            Map nowMap = maps.get(n);
            for (int i = 0; i < nowMap.getN(); i++) {
                for (int j = 0; j < nowMap.getM(); j++) {
                    int k = nowMap.getData()[i][j];
                    if (k == -1){
                        graphics.setColor(Color.DARK_GRAY);
                    }
                    if (k == 100){
                        graphics.setColor(Color.WHITE);
                    }
                    if (k >= 10 && k <= 20){
                        graphics.setColor(colors[k - 10]);
                    }
                    graphics.fillRect(tx + j * 10, ty + i * 10, 10, 10);
                }
            }
        }

        try {
            ImageIO.write(newBuf, "png", new File("/Users/hang/Downloads/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("print finish");
    }
}
