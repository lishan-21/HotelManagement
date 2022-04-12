package hotel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class EmptyTest {
    String[][] room = {
            {"EMPTY","EMPTY","EMPTY"},
            {"EMPTY","EMPTY","EMPTY"},
            {"EMPTY","EMPTY","EMPTY"}};
    int roomNo;
    @InjectMocks
    @Spy
    private Empty empty;
    @Mock
    MainRun mainRun;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void Emp_001() {
        roomNo = 101;
        room[0][0]="mary";
        Mockito.when(mainRun.getRoom()).thenReturn(room);
        boolean real = empty.isEmpty(roomNo);
        Assertions.assertEquals(false,real);
    }
    @Test
    void Emp_002() {
        roomNo = 202;
        room[1][1]="EMPTY";
        Mockito.when(mainRun.getRoom()).thenReturn(room);
        boolean real = empty.isEmpty(roomNo);
        Assertions.assertEquals(true,real);
    }
}