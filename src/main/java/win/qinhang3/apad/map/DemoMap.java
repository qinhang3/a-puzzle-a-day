package win.qinhang3.apad.map;

import lombok.Getter;

import java.util.Calendar;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
@Getter
public class DemoMap implements Map{
    private final int[][] data = new int[3][3];


    public DemoMap() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                data[i][j] = 0;
            }
        }
    }

    @Override
    public int getN() {
        return data.length;
    }

    @Override
    public int getM() {
        return data[0].length;
    }

    @Override
    public void target(Calendar calendar) {

    }
}
