package unit;

import mouse.MouseEventListener;
import mouse.MouseEventType;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class SpyListener implements MouseEventListener {
    public MouseEventType receivedEventType;
    public boolean wasEventTriggered;
    public int eventCount;

    @Override
    public void handleMouseEvent(MouseEventType eventType) {
        this.receivedEventType = eventType;
        this.wasEventTriggered = true;
        eventCount++;
    }
}
