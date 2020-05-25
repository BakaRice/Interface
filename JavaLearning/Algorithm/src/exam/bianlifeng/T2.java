package exam.bianlifeng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
你突然穿越到了西游记的世界，变成了孙悟空(好神奇)！ 你现在是在高老庄， 师傅答应了高老庄主收拾猪八戒，于是派你捉到他。

高老庄的地图：



要求：

要在最短的时间捉到他(猪八戒的位置不会变)

你和猪八戒的位置都是随机的

输出你所有的行动轨迹,根据地图: 东(east),南(south),西(west),北(north)

输入
起始位置和猪八戒位置

输出
路径字符串


样例输入
CUNKOU,GUIGE
样例输出
north,north,north,east,east,east,east,north,north,north,west
 */
public class T2 {

    static class Point {
        String name;

        boolean access;
        Point north;
        Point south;
        Point west;
        Point east;

        public Point(String name) {
            this.name = name;
        }
    }


    static List<Point> minlist = new ArrayList<>();
    static List<String> mindir = new ArrayList<>();

    static void dfs(Point start, Point end, List<Point> res, List<String> dir) {
        List<Point> resnew = res;
        if (start == null) {
            return;
        }
        if (start.access == true) {
            return;
        }
        if (start == end) {
            if (res.size() < minlist.size() || minlist.size() == 0) {
                minlist.clear();
                for (Point p : res) {
                    minlist.add(p);
                }
                mindir.clear();
                for (String s : dir) {
                    mindir.add(s);
                }
            }
            return;
        }

        start.access = true;
        res.add(start);


        dir.add("east");
        dfs(start.east, end, res, dir);
        dir.remove(dir.size() - 1);
        dir.add("south");
        dfs(start.south, end, res, dir);
        dir.remove(dir.size() - 1);
        dir.add("west");
        dfs(start.west, end, res, dir);
        dir.remove(dir.size() - 1);
        dir.add("north");
        dfs(start.north, end, res, dir);
        dir.remove(dir.size() - 1);
        res.remove(res.size() - 1);

    }

    public static void main(String[] args) {
        ArrayList<Point> list = new ArrayList<>();
        ArrayList<Point> temp = new ArrayList<>();
        ArrayList<String> direction = new ArrayList<>();
        {

            Point NONGSHE = new Point("NONGSHE");
            list.add(NONGSHE);
            Point CUNKOU = new Point("CUNKOU");
            list.add(CUNKOU);
            Point TULU = new Point("TULOU");
            list.add(TULU);
            Point DAOTIAN = new Point("DAOTIAN");
            list.add(DAOTIAN);
            Point TULU1 = new Point("TULU1");
            list.add(TULU1);
            Point DAOTIAN1 = new Point("DAOTIAN1");
            list.add(DAOTIAN1);
            Point TULU2 = new Point("TULOU2");
            list.add(TULU2);
            Point JIEDAO = new Point("JIEDAO");
            list.add(JIEDAO);
            Point LIUJIABUDIAN = new Point("LIUJIABUDIAN");
            list.add(LIUJIABUDIAN);
            Point TIEPU = new Point("TIEPU");
            list.add(TIEPU);
            Point JIEDAO1 = new Point("JIEDAO1");
            list.add(JIEDAO1);
            Point XIAOJIUGUAN = new Point("XIAOJIUGUAN");
            list.add(XIAOJIUGUAN);
            Point GAOJIADAYUAN = new Point("GAOJIADAYUAN");
            list.add(GAOJIADAYUAN);
            Point JIEDAO2 = new Point("JIEDAO2");
            list.add(JIEDAO2);
            Point TULU3 = new Point("TULU3");
            list.add(TULU3);
            Point QINGSHILU = new Point("QINGSHILU");
            list.add(QINGSHILU);
            Point ZHENGYUAN = new Point("ZHENGYUAN");
            list.add(ZHENGYUAN);
            Point ZHANGFANG = new Point("ZHANGFANG");
            list.add(ZHANGFANG);
            Point PIANFANG = new Point("PIANFANG");
            list.add(PIANFANG);
            Point ZHENGTING = new Point("ZHENGTING");
            list.add(ZHENGTING);
            Point PIANTING = new Point("PIANTING");
            list.add(PIANTING);
            Point FANTING = new Point("FANTING");
            list.add(FANTING);
            Point HOUYUAN = new Point("HOUYUAN");
            list.add(HOUYUAN);
            Point GUIGE = new Point("GUIGE");
            list.add(GUIGE);
            Point XIYIFANG = new Point("XIYIFANG");
            list.add(XIYIFANG);
            Point YASHI = new Point("YASHI");
            list.add(YASHI);
            Point HUAYUAN = new Point("HUAYUAN");
            list.add(HUAYUAN);


            NONGSHE.west = CUNKOU;//西

            CUNKOU.east = NONGSHE;//西
            CUNKOU.north = TULU;

            TULU.north = DAOTIAN;
            TULU.south = CUNKOU;

            DAOTIAN.south = TULU;
            DAOTIAN.north = TULU1;

            TULU1.north = DAOTIAN1;
            TULU1.south = DAOTIAN;
            TULU1.east = TULU2;//东

            TULU2.east = JIEDAO;//右东
            TULU2.west = TULU1;//西

            JIEDAO.east = JIEDAO1;
            JIEDAO.north = LIUJIABUDIAN;
            JIEDAO.south = TIEPU;

            LIUJIABUDIAN.south = JIEDAO;

            TIEPU.north = JIEDAO;

            JIEDAO1.south = XIAOJIUGUAN;
            JIEDAO1.west = JIEDAO;
            JIEDAO1.east = GAOJIADAYUAN;

            XIAOJIUGUAN.north = JIEDAO1;

            GAOJIADAYUAN.east = JIEDAO2;
            GAOJIADAYUAN.north = ZHENGYUAN;

            JIEDAO2.east = TULU3;
            JIEDAO2.west = GAOJIADAYUAN;

            TULU3.east = QINGSHILU;
            TULU3.west = JIEDAO2;

            QINGSHILU.west = TULU3;

            ZHENGYUAN.east = PIANFANG;
            ZHENGYUAN.south = GAOJIADAYUAN;
            ZHENGYUAN.west = ZHANGFANG;
            ZHENGYUAN.north = ZHENGTING;

            ZHANGFANG.east = ZHENGYUAN;

            PIANFANG.west = ZHENGYUAN;

            ZHENGTING.east = FANTING;
            ZHENGTING.south = ZHENGYUAN;
            ZHENGTING.west = PIANTING;
            ZHENGTING.north = HOUYUAN;

            FANTING.west = ZHENGTING;

            PIANTING.east = ZHENGTING;

            HOUYUAN.east = XIYIFANG;
            HOUYUAN.south = ZHENGTING;
            HOUYUAN.west = GUIGE;
            HOUYUAN.north = HUAYUAN;


            HUAYUAN.south = HOUYUAN;

            XIYIFANG.west = HOUYUAN;

            GUIGE.east = HOUYUAN;
            GUIGE.north = YASHI;

            YASHI.south = GUIGE;
        }
        Scanner s = new Scanner(System.in);
        String next = s.next();
        Point start = null;
        Point End = null;
        String[] p = next.split(",");
        for (Point pt : list) {
            if (pt.name.equals(p[0])) {
                start = pt;
            }
            if (pt.name.equals(p[1])) {
                End = pt;
            }
        }

        dfs(start, End, temp, direction);
        for (int i = 0; i < mindir.size() - 1; i++) {
            System.out.print(mindir.get(i) + ',');
        }
        System.out.print(mindir.get(mindir.size() - 1));
    }


}
