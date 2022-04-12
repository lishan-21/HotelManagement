package hotel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;
class OutHotelTest {
    String[][] room = {{"EMPTY","EMPTY","EMPTY"}, {"EMPTY","EMPTY","EMPTY"}, {"EMPTY","EMPTY","EMPTY"}};
    int roomNo;
    @InjectMocks
    @Spy
    OutHotel outHotel;
    @Mock
    MainRun mainRun;
    Empty empty;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void Out_001() {
        roomNo=101;
        room[0][0]="EMPTY";
        Mockito.when(mainRun.getRoom()).thenReturn(room);
        String real = outHotel.out(roomNo);
        Assertions.assertEquals("该房间没有客人入住，退房失败!",real);
    }
    @Test
    void Out_002() {
        roomNo=202;
        room[1][1]="Mary";
        Mockito.when(mainRun.getRoom()).thenReturn(room);
        String real = outHotel.out(roomNo);
        Assertions.assertEquals(roomNo + "退房成功!",real);
    }
}