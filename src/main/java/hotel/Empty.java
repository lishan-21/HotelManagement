package hotel;


public class Empty {
    /**
     * mr 主程序对象
     */
    MainRun mr = new MainRun();

    boolean isEmpty(int roomNo) {
        return "EMPTY".equals(mr.getRoom()[(roomNo / 100) - 1][(roomNo % 100) - 1]);
    }

}
