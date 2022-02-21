package win.qinhang3.apad.map;

import lombok.Getter;

import java.util.Calendar;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/14
 **/
@Getter
public class TempMap implements Map{
    private int[][] data;
    private int N;
    private int M;

    public TempMap(int[][] data) {
        this.data = data;
        this.N = data.length;
        this.M = data[0].length;
    }

    @Override
    public void target(Calendar calendar) {

    }
}
