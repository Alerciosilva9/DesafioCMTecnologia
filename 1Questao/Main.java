public class Main {
    public static void main(String[] args) {
        int[][] matriz = {{1, 2,5,7},
                          {2,5,6,7},
                          {7, 0, 9,6},
                          {5, 7, 6,9}};

        invertDiagonal(matriz);
        PrintarMatriz(matriz);
    }

    static void invertDiagonal(int[][] matriz){
        try {
            int[] posDig = {0,0};
            int[] posDigSec = {0,0};
            int aux = 0;
            int flagLine = 0;
            int flagCol = matriz.length - 1;
            for(int i=0;i<matriz.length;i++){
                if(matriz[i].length!=matriz.length)throw new Exception("Matriz cedida não é quadrada");
                for (int j = 0;j<matriz[i].length;j++){
                    if(j==i){
                        posDig = new int[]{i,j};
                    }
                    if(i==flagLine && j==flagCol){
                        posDigSec = new int[]{i,j};
                        flagLine++;
                        flagCol--;
                    }
                }
                aux = matriz[posDig[0]][posDig[1]];
                matriz[posDig[0]][posDig[1]] = matriz[posDigSec[0]][posDigSec[1]];
                matriz[posDigSec[0]][posDigSec[1]] = aux;
            }
        }catch (NullPointerException e){
            throw new NullPointerException("Informe Matrizes Validas");
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }


    }

    static void PrintarMatriz(int[][] matriz){
        for(int i=0;i<matriz.length;i++){
            for (int j = 0;j<matriz[i].length;j++){
                System.out.print("["+matriz[i][j]+"]");
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }
}