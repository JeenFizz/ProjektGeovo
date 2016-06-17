package contract;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MobileOrder {
    Right,
    RightUp,
    RightDown,
    Up,
    Left,
    LeftUp,
    LeftDown,
    Down;

    private static final List<MobileOrder> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static MobileOrder random()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
