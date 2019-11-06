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
                return o1.compareTo(o2);
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
