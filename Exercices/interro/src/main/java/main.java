public class main {
    public static void main(String[] args) {
        FrenchBouledogue fb = new FrenchBouledogue(/* ... */);
        Dog dog2 = (Dog) fb;
        System.out.println(dog2.shout());
    }
}
