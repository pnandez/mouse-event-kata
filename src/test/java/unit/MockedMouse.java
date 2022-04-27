package unit;

import mouse.Mouse;
import mouse.MousePointerCoordinates;

public class MockedMouse {

    public static void simulateOneSingleClick(Mouse m) {
        m.pressLeftButton(System.currentTimeMillis());
        m.releaseLeftButton(System.currentTimeMillis());
    }

    public static void simulateTwoSingleClicks(Mouse m) {
        simulateOneSingleClick(m);
        try {
            Thread.sleep(501);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        simulateOneSingleClick(m);
    }

    public static void simulateDoubleClick(Mouse m) {
        simulateOneSingleClick(m);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        simulateOneSingleClick(m);
    }

    public static void simulateTripleClick(Mouse m) {
        simulateDoubleClick(m);
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        simulateOneSingleClick(m);
    }

    public static void simulateDrag(Mouse m) {
        MousePointerCoordinates from = new MousePointerCoordinates(10, 10);
        MousePointerCoordinates to = new MousePointerCoordinates(20, 20);

        m.pressLeftButton(System.currentTimeMillis());
        m.move(from, to, System.currentTimeMillis() + 10);
    }

    public static void simulateDragAndDrop(Mouse m) {
        simulateDrag(m);
        m.releaseLeftButton(System.currentTimeMillis() + 20);
    }
}