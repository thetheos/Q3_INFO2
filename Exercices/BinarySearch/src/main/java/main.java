public class main {
    public static void main(String[] args) {
        char[] charAr= {'0','-','2','2'};

        System.out.print(BigDecimal.parseExp(charAr,0,3));
        try{
            System.out.print(BigDecimal.parseExp(charAr,0,0));
        }catch (Exception e){}

        char[] charAr2= {'0','+','0','0','0','0','0','0','0','0','0','0','0','2','2'};
        System.out.print(BigDecimal.parseExp(charAr2,0,15));

        char[] charAr3= {'0','-','2','2','2','2','2','2','2','2','2','2','2','2','2','2'};
        try{
            System.out.print(BigDecimal.parseExp(charAr3,0,16));
        }
        catch (Exception e){}

        char[] charAr4= {'A','-','2','2','2','C','D','E','F','2','2','2','2','2','2','2'};
        try{
            System.out.print(BigDecimal.parseExp(charAr4,0,16));
        }
        catch (Exception e){}


        char[] charAr5= {'0','-','1','A'};
        try{
            System.out.print(BigDecimal.parseExp(charAr5,0,4));
        }
        catch (Exception e){}
    }
}
