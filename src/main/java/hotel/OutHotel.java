package hotel;

public class OutHotel extends Empty {
    /**out退房方法
     * @param roomNo 房间号
     * @return 入住结果
     */
    public String out(int roomNo) {
        MainRun mr = new MainRun();
        if (isEmpty(roomNo)) {
            return "该房间没有客人入住，退房失败!";
        } else {
            mr.getRoom()[(roomNo / 100) - 1][(roomNo % 100) - 1] = "EMPTY";
            return roomNo + "退房成功!";
        }
    }
}
