public class Valley{
    /*
     * Example:
     * [1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1]
     * Should return
     * [5, 3]
     */

     public static int[] valley ( int[] array){
        int crt_dst = 0;
        int crt_clb = 0;
        int max_v=0;
        int max_peak= 0;
        int prv_clb = 0;
        int prv_dst = 0;
        for(int i = 0; i<array.length; i++){
            if(array[i] < 0){
                if(crt_clb != 0){
                    prv_clb = crt_clb;
                    crt_clb = 0;
                    max_v = java.lang.Math.max(check_depth(prv_dst,prv_clb), max_v); //si on arrive ici c'est qu'il y a eu une descente puis une montée et qu'on entame une Troisième montée. Donc on update la taille de la vallée
                }
                crt_dst++;
                if(i+1 == array.length) prv_dst = crt_dst;
            }else if(array[i] > 0){
                if(crt_dst != 0){
                    prv_dst = crt_dst;
                    crt_dst = 0;
                    max_peak = java.lang.Math.max(check_depth(prv_dst,prv_clb),max_peak); //si on arrive ici c'est qu'il y a eu une montée puis une descente et qu'on entame une deuxième monté. Donc on update le plus haut pique
                }
                crt_clb++;
                if(i+1 == array.length) prv_clb = crt_clb;
            }
        }
        max_v = java.lang.Math.max(check_depth(prv_dst,prv_clb), max_v); //Verrifie une dernière fois, utile dans le cas où il n'y qu'une seule monté et descente
        max_peak = java.lang.Math.max(check_depth(prv_dst,prv_clb), max_peak);
        return new int[] {max_v,max_peak};
    }

    public static int check_depth(int dst, int clb){
         if (dst != 0 && clb != 0) {
             return (java.lang.Math.max(dst, clb) - java.lang.Math.abs(dst - clb));
         }
         return 0;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, -1, -1};
        //int[] a = {-1,-1,-1,-1,-1,1,1,1,1,1};
         valley(a);
    }
}
