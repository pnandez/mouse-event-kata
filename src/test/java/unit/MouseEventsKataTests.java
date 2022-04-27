package unit;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

import mouse.Mouse;
import mouse.MouseEventType;

public class MouseEventsKataTests {
    Mouse mouse;
    SpyListener listener;
    
    @Before
    public void setUp(){
        mouse = new Mouse();
        listener = new SpyListener();
        mouse.subscribe(listener);
    }

    @Test
    public void should_single_click(){
        MockedMouse.simulateOneSingleClick(mouse);
        assertThat(listener.receivedEventType).isEqualTo(MouseEventType.SingleClick);

        MockedMouse.simulateTwoSingleClicks(mouse);
        assertThat(listener.receivedEventType).isEqualTo(MouseEventType.SingleClick);
    }

    @Test
    public void should_double_click(){
        MockedMouse.simulateDoubleClick(mouse);
        assertThat(listener.receivedEventType).isEqualTo(MouseEventType.DoubleClick);
    }

    @Test
    public void should_triple_click(){
        MockedMouse.simulateTripleClick(mouse);
        assertThat(listener.receivedEventType).isEqualTo(MouseEventType.TripleClick);
    }

    @Test
    public void should_drag(){
        MockedMouse.simulateDrag(mouse);
        assertThat(listener.receivedEventType).isEqualTo(MouseEventType.Drag);
    }

    @Test
    public void should_drag_and_drop(){
        MockedMouse.simulateDragAndDrop(mouse);
        assertThat(listener.receivedEventType).isEqualTo(MouseEventType.Drop);
    }


}
