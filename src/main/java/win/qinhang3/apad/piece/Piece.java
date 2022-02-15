package win.qinhang3.apad.piece;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
public abstract class Piece {
    public abstract int[][] getData();
    public abstract int getX();
    public abstract int getY();

    /**
     * 水平翻转
     * @return
     */
    public Piece flip(){
        Piece newPiece = new TempPiece(new int[getX()][getY()]);
        for (int i = 0; i < getX(); i++) {
            for (int j = 0; j < getY(); j++) {
                newPiece.getData()[i][j] = getData()[i][getY() - j - 1];
            }
        }
        return newPiece;
    }

    /**
     * 顺时针旋转90度
     * @return
     */
    public Piece rotate(){
        Piece newPiece = new TempPiece(new int[getY()][getX()]);
        for (int i = 0; i < getX(); i++) {
            for (int j = 0; j < getY(); j++) {
                newPiece.getData()[j][getX() - i - 1] = getData()[i][j];
            }
        }
        return newPiece;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < getX(); i++) {
            for (int j = 0; j < getY(); j++) {
                stringBuilder.append(getData()[i][j] == 1 ? "#":" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        int x = 0;
        for (int i = 0; i < getX(); i++) {
            for (int j = 0; j < getY(); j++) {
                x = (x << 1) | getData()[i][j];
            }
        }
        return x;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Piece)){
            return false;
        }
        Piece that = (Piece) obj;
        return this.getX() == that.getX() && this.getY() == that.getY() && this.hashCode() == that.hashCode();
    }
}
