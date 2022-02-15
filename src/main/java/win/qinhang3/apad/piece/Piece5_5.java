package win.qinhang3.apad.piece;

import lombok.Getter;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
@Getter
public class Piece5_5 extends Piece{
    private final int[][] data = {
            {1,0},
            {1,0},
            {1,1},
            {1,0}
    };
    private final int x = data.length;
    private final int y = data[0].length;
}
