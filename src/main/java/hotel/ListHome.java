package hotel;

/**
 * 显示酒店入住情况的类
 */
public class ListHome {
    /**
     * mr 主程序对象
     */
    MainRun mr = new MainRun();

    /**
     * 查询显示酒店所有房间的状态
     */
    public void search() {
        for (int i = 0; i < mr.getRoom().length; i++) {
            //打印每一层的房号
            for (int j = 0; j < mr.getRoom()[0].length; j++) {
                System.out.printf("%-9d", (i + 1) * 100 + (j + 1));
            } //内层for循环结束
            //打印每一层的房间状态
            System.out.println();
            for (int j = 0; j < mr.getRoom()[0].length; j++) {
                System.out.printf("%-9s", mr.getRoom()[i][j]);
            }
            System.out.println();
        } // 外层for循环结束

    }
}
