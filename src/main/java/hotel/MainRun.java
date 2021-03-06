package hotel;

import java.util.Scanner;

/**
 * MainRun:程序运行的入口，用于酒店房间状态初始化、输入命令和执行
 */
public class MainRun {
    /**
     * rooms 代表所有酒店房间，共10层，每层12间房
     */
    private static String[][] rooms;
    /**
     * lh 展示酒店房间情况的对象
     */
    private static ListHome lh = new ListHome();
    /**
     * ih 入住类对象
     */
    private static InHotel ih = new InHotel();
    /**
     * oh 退房类对象
     */
    private static OutHotel oh = new OutHotel();

    public static void main(String[] args) {
        iniRooms();
        command();
    }

    /**
     * iniRooms 通过两重for循环，将所有房间的状态初始化为"EMPTY"
     */
    private static void iniRooms() {
        rooms = new String[10][12];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                rooms[i][j] = "EMPTY";
            }
        }
    }

    /**command
     *
     */
    public static void command() {
        String comm; //表示用户输入的命令

        while (true) {
            System.out.println("请输入命令: ");
            Scanner sca = new Scanner(System.in);
            System.gc();
            comm = sca.next();
            if ("search".equalsIgnoreCase(comm)) {
                lh.search(); //调用ListHome的search方法
            } else if ("in".equalsIgnoreCase(comm)) {
                int roomNo = sca.nextInt(); //获取房间号
                try {
                    if (validRoomNo(roomNo)) { //检验房间号
                        //若房间为空，则获取新入住的房客姓名，登记入住
                        String name = sca.next();
                        System.out.println(ih.in(roomNo, name));
                    } else {
                        System.out.println("房间号错！");
                    }
                } catch (Exception e) {
                    System.out.println("房间号错！");
                }
            } else if ("out".equalsIgnoreCase(comm)) {
                int roomNo = sca.nextInt();
                if (validRoomNo(roomNo)) {
                    System.out.println(oh.out(roomNo));
                } else {
                    System.out.println("房间号错！");
                }
            } else if ("exit".equalsIgnoreCase(comm)) {
                System.out.println("程序退出...");
                break;
            } else {
                System.out.println("命令输入错误,请重新输入: ");
            }
        } //while 循环结束
    }

    /**
     * 对输入的房间号进行初步验证。房间号的组成方式为 a*100+b，其中a={1...10},b={1...12}
     * 所以roomNo/100={1...10},roomNo%100={1...12}
     *
     * @param roomNo 要验证的房间号
     * @return 验证结果
     */
    private static boolean validRoomNo(int roomNo) {
        int floor = roomNo / 100; //代表输入的房间号的层号
        int num = roomNo % 100; //代表输入的房间号的房间序号

        return floor <= 10 && floor >= 1 && num <= 12 && num >= 1;
    }

    public String[][] getRoom() {
        return rooms;
    }

}
