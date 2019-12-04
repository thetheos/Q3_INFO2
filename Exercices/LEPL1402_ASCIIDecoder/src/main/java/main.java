public class main {
    public static void main(String[] args) {
        /*FrenchBouledogue fb = new FrenchBouledogue();
        Dog dog2 = (Dog) fb;
        System.out.println(dog2.shout());
        */
        FrenchBouledogue fb = new FrenchBouledogue(/*...*/);
        Dog d = (Dog) fb;
        System.out.print(d.height);
    }
}
