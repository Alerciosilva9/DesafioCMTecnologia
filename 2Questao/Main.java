import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matriz = {{9,8,7,3},
                          {8,7,9,8},
                          {7,8,8,7}};

        int[][] subMatriz = {{9,8},{8,7}};
        System.out.println(ContarSubMatriz(matriz,subMatriz));
    }

    static int ContarSubMatriz(int[][] matriz, int[][] submatriz){
        int count = 0;
        try{
            if(matriz[0].length <=0 || submatriz[0].length<=0)return 0;
            int leftsize = submatriz[0].length;
            for (int i = 0;i< matriz.length;i++){
                for (int j=0;j<matriz[i].length;j++){
                    if(j+leftsize<=matriz[i].length){
                        if(Arrays.equals(submatriz[0],Arrays.copyOfRange(matriz[i],j,j+leftsize))){
                            if(i+submatriz.length<=matriz.length){
                                if(compararMatrizes(Arrays.copyOfRange(matriz ,i,i+submatriz.length),submatriz,leftsize,j)){
                                    count++;
                                };
                            }
                        }
                    }
                }
            }
        }catch (NullPointerException e){
            System.out.println("As Matrizes não podem ser nulas");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return (count);
    }

    static boolean compararMatrizes(int[][] matriz, int[][] submatriz, int leftsize,int posCol){
        for (int i = 0;i< matriz.length;i++){
            if(!(Arrays.equals(Arrays.copyOfRange(matriz[i],posCol,posCol+leftsize),submatriz[i]))){
                return false;
            }
        }
        return  true;
    }

}