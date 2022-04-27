package mouse;

import java.util.ArrayList;
import java.util.List;


public class Mouse {
    private List<MouseEventListener> listeners = new ArrayList<>();
    private boolean isButtonPressed;
    private long previousReleaseTime = 0;
    private long lastTime = 0;
    private boolean isSingleClick;
    private boolean isDoubleClick;
    private boolean isTripleClick;
    private boolean isDrag;
    public static final long clickTimeWindow = 500;
    private final long timeWindowInMillisecondsForDoubleClick = 500;


    public void pressLeftButton(long currentTimeInMilliseconds) {
        lastTime = currentTimeInMilliseconds;
        isButtonPressed = true;
    }

    public void releaseLeftButton(long currentTimeInMilliseconds) {
        if (isButtonPressed){
            isButtonPressed = false;
            resetEvents(currentTimeInMilliseconds);
            previousReleaseTime = currentTimeInMilliseconds;
            notifySubscribers(eventTypeTrigger());
        }
    }

    private void resetEvents(long currentTimeInMilliseconds) {
        boolean isTimeExpired = currentTimeInMilliseconds - previousReleaseTime > timeWindowInMillisecondsForDoubleClick;

        if (isTimeExpired){
            isSingleClick = false;
            isDoubleClick = false;
            isTripleClick = false;
            previousReleaseTime = 0;
        }
    }

    private MouseEventType eventTypeTrigger(){
        if (isDrag){
            isDrag = false;
            return MouseEventType.Drop;
        }

        if (!isSingleClick){
            isSingleClick = true;
            return MouseEventType.SingleClick;
        }

        if(!isDoubleClick) {
            isDoubleClick = true;
            return MouseEventType.DoubleClick;
        }

        if(!isTripleClick) {
            isTripleClick = true;
            return MouseEventType.TripleClick;
        }

        return null;
    }

    public void move(MousePointerCoordinates from, MousePointerCoordinates to, long currentTimeInMilliseconds) {
        if (!from.equals(to) && isButtonPressed){
            isDrag = true;
            notifySubscribers(MouseEventType.Drag);
        }
    }

    public void subscribe(MouseEventListener listener) {
        listeners.add(listener);
    }

    private void notifySubscribers(MouseEventType eventType) {
        listeners.forEach(listener -> listener.handleMouseEvent(eventType));
    }
}
