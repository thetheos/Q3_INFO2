public class main {
    public static void main(String[] args) {
        D d = new D();
        d.display();
    }

}

class A{
    void foo(){
        System.out.println("Foo A");
    }
}

class B extends A{
    void foo(){
        System.out.println("Foo B");
    }
}

class C extends B{

}

class D extends C{
    void foo(){
        System.out.println("foo D");
    }
    void display(){
        super.foo();
    }
}