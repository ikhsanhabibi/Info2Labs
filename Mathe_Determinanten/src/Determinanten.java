import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Determinanten {
    private double[][] A;
    private int n, nrOfDigits, anzahlMult;
    
    public Determinanten(String filename){
        if (!readFromFile(filename)) return;
        nrOfDigits = 1;
        anzahlMult = 0;
        
        System.out.println("A:");
        showMatrix(A, nrOfDigits);
        System.out.println();
        long startTime = System.nanoTime();
        System.out.println("det(A) = "+det(A));
        long endTime = System.nanoTime();
        System.out.println( "dauer: " + ((double)(endTime - startTime)/1000000000) + "s" );
        System.out.println("Anzahl der Multiplikationen: "+anzahlMult);
    }

    public double det(double[][] A){
    	double out = 0;
    	int size = A.length;
    	////the Base Cases
    	if(n==1){return A[0][0];}
    	if(size==2){
    		out = A[0][0] * A[1][1] - A[0][1] * A[1][0];
    		anzahlMult += 2;
    	}
    	if(size==3){
    		out = A[0][0]*A[1][1]*A[2][2] + A[0][1]*A[1][2]*A[2][0] + A[0][2]*A[1][0]*A[2][1] 
    		     -A[0][2]*A[1][1]*A[2][0] - A[0][0]*A[1][2]*A[2][1] - A[0][1]*A[1][0]*A[2][2];
    		anzahlMult += 12;
    	}
    	else{
    		for(int t = 0;t<size;t++){
    			if(t%2 == 0){
    				//System.out.println("+" + A[t][0] + " * det:");
    				out += A[t][0] * det(makeSubMatrix(A,t,size));
    			}else{
    				//System.out.println("-" + A[t][0] + " * det:");
    				out -= A[t][0] * det(makeSubMatrix(A,t,size));
    			}
    			anzahlMult ++;
    		}
    	}
    	return out;
    }
    //generiert die submatrix mit [n-1][n-1]
    private double[][] makeSubMatrix(double[][] A,int t,int size){
    	double[][] B = new double[size-1][size-1];
    	for(int i=0;i<size;i++){
    		//schreibe alle Werte von a um eins nach rechts Versetzt in B und ignoriere die erste Splate
    		for(int j=0;j<(size-1);j++){
    			if(i<t){
    				//schreibe werte vor 'ignorieter Zeile' unverŠndert in B
    				B[i][j] = A[i][j+1];
    			}
    			//ignoriere Zeile t
    			else if(i>t){
    				//schreibe werte nach 'ignorierter Zeile' um ein nach oben verschoben in B
    				B[i-1][j] = A[i][j+1];
    			}
    		}
    	}
    	//showMatrix(B,size-1);
		return B;
    	
    }
    
    //reads the quadratic matrix A from a file; see Programmieraufgaben.pdf for the required format 
    public boolean readFromFile(String filename){
        ArrayList<String> stringList = new ArrayList<String>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            while (line!=null){
                stringList.add(line);
                line = br.readLine();
            }
            br.close();
            
            String[] parts = stringList.get(0).split("  ");
            n = parts.length;
            
    		if (n!=stringList.size()){
    			System.out.println("Matrix nicht quadratisch!");
    			return false;
    		}
            
            A = new double[n][n];

            for (int i=0; i<n; i++){
                parts = stringList.get(i).split("  ");
                for (int j=0; j<n; j++) A[i][j] = Double.valueOf(parts[j]);
            }
            return true;
        }
        catch(IOException e){
            System.out.println(""+e);
            return false;
        }
    }

    //writes a matrix M to the console; the coefficient will be rounded to nrOfDigits digits 
    public void showMatrix(double[][] M, int nrOfDigits){
        int m = M.length;
        int n = M[0].length;
        boolean hasNoNegativeEntry = true;
        double max = 0.0;
        for (int j=0; j<n; j++){
            for (int i=0; i<m; i++){
                if (M[i][j]>max) max = M[i][j];
                if (M[i][j]<0.0) hasNoNegativeEntry = false; 
            }
        }
        int l;
        if (max==0) l = 5;
        else l = (int) Math.log10(Math.abs(max))+nrOfDigits+5;//+1: log, +1: sign, +1: point, +2
        if (nrOfDigits==0) l--;
        if (hasNoNegativeEntry) l--;

        String f, s;
        f = "%"+l+"."+nrOfDigits+"f";
        for (int i=0; i<m; i++){
            s = "";
            for (int j=0; j<n; j++){
                s = s+String.format(f, M[i][j]);    
            }
            System.out.println(s);
        }
        System.out.println("");
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Determinanten det = new Determinanten("Test 2.txt");

	}
}


