package win.qinhang3.apad.piece;

import lombok.Getter;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
@Getter
public class TempPiece extends Piece{
    private final int[][] data;
    private final int x;
    private final int y;

    public TempPiece(int[][] data) {
        this.data = data;
        this.x = data.length;
        this.y = data[0].length;
    }
}
