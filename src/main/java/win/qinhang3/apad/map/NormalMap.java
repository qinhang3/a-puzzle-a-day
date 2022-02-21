package win.qinhang3.apad.map;

import lombok.Getter;

import java.util.Calendar;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
@Getter
public class NormalMap implements Map{
    private final int[][] data = new int[7][7];


    public NormalMap() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                data[i][j] = 0;
            }
            data[0][6] = -1;
            data[1][6] = -1;
            data[6][3] = -1;
            data[6][4] = -1;
            data[6][5] = -1;
            data[6][6] = -1;
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
    public void target(Calendar calendar){
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH) - 1;
        getData()[month / 6][month % 6] = 100;
        getData()[day / 7 + 2][day % 7] = 100;
    }
}
