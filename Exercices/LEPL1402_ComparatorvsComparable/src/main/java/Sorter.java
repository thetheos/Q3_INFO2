import java.util.List;
import java.awt.Color;

import java.util.Comparator;
import java.util.List;

public class Sorter {


    /*
     * Should sort the list and order the Flower by color, in this specific order : red, blue, green
     */
    public static void sortFlowerByColor(List<Flower> list){
        Comparator<Flower> flowClrCompr = new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                if(o1.getPetalColor().equals(o2.getPetalColor())) return 0;
                if(o1.getPetalColor().getRed()==o2.getPetalColor().getRed() && o1.getPetalColor().getBlue()==o2.getPetalColor().getBlue()) return o1.getPetalColor().getGreen()- o2.getPetalColor().getGreen();
                if(o1.getPetalColor().getRed()==o2.getPetalColor().getRed()) return o1.getPetalColor().getBlue() -o2.getPetalColor().getBlue();
                return o1.getPetalColor().getRed()-o2.getPetalColor().getRed();
            }
        };
        list.sort(flowClrCompr);
    }
    /*
     * Should sort the Plant by name only
     */
    public static void sortPlantByName(List<Plant> list){
        Comparator<Plant> pltComp = new Comparator<Plant>() {
            @Override
            public int compare(Plant o1, Plant o2) {
                String s1 = o1.getName();
                String s2 = o2.getName();
                int comparison = 0;
                int c1, c2;
                for(int i = 0; i < s1.length() && i < s2.length(); i++) {
                    c1 = (int) s1.charAt(i);   // See note 1
                    c2 = (int) s2.charAt(i);   // See note 1
                    comparison = c1 - c2;   // See note 2

                    if(comparison != 0)     // See note 3
                        return comparison;
                }
                if(s1.length() > s2.length())    // See note 4
                    return 1;
                else if (s1.length() < s2.length())
                    return -1;
                else
                    return 0;
            }
        };
        list.sort(pltComp);
    }

    /*
     * Should sort the list and order the Tree by height
     */
    public static void sortTreeByHeight(List<Tree> list){
        Comparator<Tree> treeComp = new Comparator<Tree>() {
            @Override
            public int compare(Tree o1, Tree o2) {
                return o1.getHeight() - o2.getHeight();
            }
        };
        list.sort(treeComp);
    }
}
