public class ElementFactory extends Factory {

    public static ElementFactory elementFactory = null;
    private ElementFactory(){}

    public static ElementFactory getInstance() {
        if(elementFactory == null){
            elementFactory = new ElementFactory();
            return elementFactory;
        }
        return elementFactory;
    }

    @Override
    LevelComponent getElement(char c) {
        switch (c){
            case '#':
                return new Wall();
            case '-':
                return new Floor();
            case 'K':
                return new Key();
            case 'D':
                return new Door();
            default:
                throw new IllegalArgumentException();
        }
    }
}