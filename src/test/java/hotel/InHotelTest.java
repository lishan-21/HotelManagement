package hotel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class InHotelTest {
    String[][] room = {{"EMPTY","EMPTY","EMPTY"}, {"EMPTY","EMPTY","EMPTY"}, {"EMPTY","EMPTY","EMPTY"}};
    int roomNo;
    @InjectMocks
    @Spy
    InHotel inHotel;
    @Mock
    MainRun mainRun;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void In_001(){
        roomNo=101;
        room[0][0]="Claire";//代表101号房间已经入住了Claire
        Mockito.doReturn(false).when(inHotel).isEmpty(roomNo);
        Mockito.when(mainRun.getRoom()).thenReturn(room);
        String real = inHotel.in(roomNo,"Mary");
        Assertions.assertEquals("该房间已经有客人入住！",real);

    }
    @Test
    void In_002(){
        roomNo=202;
        room[1][1]="EMPTY";
        Mockito.doReturn(true).when(inHotel).isEmpty(roomNo);
        Mockito.when(mainRun.getRoom()).thenReturn(room);
        String real = inHotel.in(roomNo,"Bob");
        Assertions.assertEquals("Bob成功入住202房间! ",real);


    }



}