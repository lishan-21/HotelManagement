package hotel;

public class InHotel extends Empty {
    /**
     * room 房间号的组成为a*100+b(a为层数1-10，b为房间序号1-12)，room记录房间序号
     */
    private int room;
    /**
     * mr mainrun
     */
    MainRun mr = new MainRun();


    /**入住方法
     *
     * @param roomNo 房间号
     * @param name 入住者姓名
     * @return 返回入住结果
     */
    public String in(int roomNo, String name) {
        room = (roomNo % 100) - 1;
        if (isEmpty(roomNo)) {
             mr.getRoom()[(roomNo / 100) - 1][room] = name;
            return name + "成功入住" + roomNo + "房间! ";
        } else {
            return "该房间已经有客人入住！";
        }
    }

    /** 检查房间是否为空
     *
     * @param roomNo 待检查房间是否为空的房间号
     * @return 如何房间为空返回真，否则为假
     */
    @Override
    public boolean isEmpty(int roomNo) {
        String roomState = super.mr.getRoom()[(roomNo / 100) - 1][(roomNo % 100) - 1];
        return "EMPTY".equals(roomState);
    }
}
