public class ArgParsing {
    public static void main(String[] args){
        //errorMaker();
        concurenceError();
    }


    public static void errorMaker(){
        try{
            Object a = null;
            a.toString();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void concurenceError(){
        try{
            String[] stringArr= {"a","b","c"};
            for(String elm : stringArr){
                stringArr[1] = "ok";
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
