public class Level extends AbstractLevel {

    ElementFactory elmFactory = ElementFactory.getInstance();
    private LevelComponent[][] componentsObjects = null;
    private int size = 0;
    private String inputStr = null;

    public Level(String input){
        inputStr = input;
        String[] inputStr = input.split("\n");
        size = inputStr[0].length();
        componentsObjects = new LevelComponent[size][size];
        for(int i = 0 ; i<size; i++){
            for(int j = 0; j<size; j++){
                componentsObjects[i][j] = getElement(inputStr[i].charAt(j));
            }
        }
    }

    /* Example of level building with this String : String s = "#-K\n-D-\n#-K\n"
     * Gives : LevelComponent[][] componentsObjects = {
     *                                        {new Wall(), new Floor(), new Key()},
     *                                        {new Floor(), new Door(), new Floor()},
     *                                        {new Wall(), new Floor(), new Key()}}
     */
    public LevelComponent getElement(char  c){
        return elmFactory.getElement(c);
    }

    @Override
    public String toString() {
        return inputStr;
    }

    @Override
    LevelComponent[][] getComponents() {
        return componentsObjects;
    }

    @Override
    int getSize() {
        return size;
    }


}