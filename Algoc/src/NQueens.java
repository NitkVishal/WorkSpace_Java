public class NQueens { 
  
    int[] x; 
  
    public NQueens(int N) { 
        x = new int[N]; 

    } 
  
    public boolean canPlaceQueen(int r, int c) { 
       
        for (int i = 0; i < r; i++) { 
            if (x[i] == c || (Math.abs(i - r) == Math.abs(x[i] - c)) )  
            { 
                return false; 
            } 
        } 
        return true; 
    } 
  
    public void printQueens(int[] x) { 
        int N = x.length; 
        for (int i = 0; i < N; i++) { 
            for (int j = 0; j < N; j++) { 
                if (x[i] == j) { 
                    System.out.print("Q "); 
                } else { 
                    System.out.print("* "); 
                } 
            } 
            System.out.println(); 
        } 
        System.out.println(); 
    } 
  
    public void placeNqueens(int r, int n) { 
        
        for (int c = 0; c < n; c++) { 
            if (canPlaceQueen(r, c)) { 
                x[r] = c; 
                if (r == n - 1) { 
                   printQueens(x); 
                } else { 
                    placeNqueens(r + 1, n); 
                } 
            } 
        } 
    } 
  
    public void callplaceNqueens() { 
        placeNqueens(0, x.length); 
    } 
  
    public static void main(String args[]) { 
        NQueens Q = new NQueens(8); 
        Q.callplaceNqueens(); 

       
    } 
}