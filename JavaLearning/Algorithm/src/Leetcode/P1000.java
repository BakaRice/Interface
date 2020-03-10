package Leetcode;

import java.util.ArrayList;

public class P1000 {
    public static ArrayList<String> groud() {
        ArrayList<String> glist = new ArrayList<>();
        String groud = "##########################################";
        String groud2 = "#.#..#....#..##.#..#....#..##.#..#....#..#";
        String groud3 = "#.....#......##.....#......##.....#......#";
        String groud4 = "#..#....#....##..#....#....##..#....#....#";
        String groud5 = "#...#......#.##...#......#.##...#......#.#";
        glist.add(0, groud);
        glist.add(1, groud2);
        glist.add(2, groud);
        glist.add(3, groud3);
        glist.add(4, groud);
        glist.add(5, groud4);
        glist.add(6, groud);
        glist.add(7, groud5);
        glist.add(8, groud);
        return glist;
    }

    public static ArrayList<String> groud2() {
        ArrayList<String> glist = new ArrayList<>();
        String groud = "    ############";
        String groud1 = "    #----------#";
        String groud2 = "####################";
        String groud3 = "#------------------#";


        glist.add(0, groud);
        glist.add(1, groud1);
        glist.add(2, groud1);
        glist.add(3, groud1);
        glist.add(4, groud1);
        glist.add(5, groud2);
        glist.add(6, groud3);
        glist.add(7, groud3);
        glist.add(8, groud2);
        return glist;
    }

    public static void main(String[] args) {
            String name = "                ********\n" +
                    "               ************\n" +
                    "               ####....#.\n" +
                    "             #..###.....##....\n" +
                    "             ###.......######              ###            ###\n" +
                    "                ...........               #...#          #...#\n" +
                    "               ##*#######                 #.#.#          #.#.#\n" +
                    "            ####*******######             #.#.#          #.#.#\n" +
                    "           ...#***.****.*###....          #...#          #...#\n" +
                    "           ....**********##.....           ###            ###\n" +
                    "           ....****    *****....\n" +
                    "             ####        ####\n" +
                    "           ######        ######";

            String all = "                ********\n" +
                    "               ************\n" +
                    "               ####....#.\n" +
                    "             #..###.....##....\n" +
                    "             ###.......######              ###            ###\n" +
                    "                ...........               #...#          #...#\n" +
                    "               ##*#######                 #.#.#          #.#.#\n" +
                    "            ####*******######             #.#.#          #.#.#\n" +
                    "           ...#***.****.*###....          #...#          #...#\n" +
                    "           ....**********##.....           ###            ###\n" +
                    "           ....****    *****....\n" +
                    "             ####        ####\n" +
                    "           ######        ######\n" +
                    "##############################################################\n" +
                    "#...#......#.##...#......#.##...#......#.##------------------#\n" +
                    "###########################################------------------#\n" +
                    "#..#....#....##..#....#....##..#....#....#####################\n" +
                    "##########################################    #----------#\n" +
                    "#.....#......##.....#......##.....#......#    #----------#\n" +
                    "##########################################    #----------#\n" +
                    "#.#..#....#..##.#..#....#..##.#..#....#..#    #----------#\n" +
                    "##########################################    ############\n";
//        System.out.println(name);
//        for (int i = groud().size()-1; i >= 0; i--) {
//            System.out.print(groud().get(i));
//            System.out.print(groud2().get(i));
//            System.out.println();
//        }
        System.out.println(all);
    }
}
