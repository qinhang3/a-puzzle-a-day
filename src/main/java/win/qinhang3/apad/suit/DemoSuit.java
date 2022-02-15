package win.qinhang3.apad.suit;

import com.google.common.collect.Lists;
import lombok.Getter;
import win.qinhang3.apad.map.DemoMap;
import win.qinhang3.apad.map.Map;
import win.qinhang3.apad.map.NormalMap;
import win.qinhang3.apad.piece.*;

import java.util.List;

/**
 * @description:
 * @author: hang
 * @create: 2022/2/11
 **/
@Getter
public class DemoSuit implements Suit{
    private final Map map = new DemoMap();
    private final List<Piece> pieces = Lists.newArrayList(new Piece5_1(), new Piece3_1());
}
