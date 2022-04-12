package hotel;


public class Empty {
    /**
     * mr 主程序对象
     */
     MainRun mr = new MainRun();

    boolean isEmpty(int roomNo) {
        int floor = roomNo / 100 - 1;
        int num = roomNo % 100 - 1;
        String state = mr.getRoom()[floor][num];
        return state.equals("EMPTY");

    }

}
