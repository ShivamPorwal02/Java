public class Minesweeper {
    public static void main(String[] args) {
        int m =Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        String[][] a = new String[m][n];
        for (int i=0;i<k;i++){
            int mi= (int)(m * Math.random());
            int mj= (int)(n * Math.random());
            a[mi][mj]= "*";
        }
        int cnt;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                cnt=0;
                if (a[i][j]!="*"){
                    if(i!=0 && i!=(m-1) && j!=0 && j!=(n-1)){
                        if(a[i][j+1]=="*") cnt+=1;
                        if(a[i][j-1]=="*") cnt+=1;
                        if(a[i-1][j]=="*") cnt+=1;
                        if(a[i+1][j]=="*") cnt+=1;
                        if(a[i-1][j-1]=="*") cnt+=1;
                        if(a[i-1][j+1]=="*") cnt+=1;
                        if(a[i+1][j-1]=="*") cnt+=1;
                        if(a[i+1][j+1]=="*") cnt+=1;
                    }
                    if(i==0){
                        if(j!=0 && j!=(n-1)){
                            if(a[i+1][j]=="*") cnt+=1;
                            if(a[i+1][j+1]=="*") cnt+=1;
                            if(a[i+1][j-1]=="*") cnt+=1;
                            if(a[i][j+1]=="*") cnt+=1;
                            if(a[i][j-1]=="*") cnt+=1;
                        }
                        else if(j==0){
                            if(a[i][j+1]=="*") cnt+=1;
                            if(a[i+1][j]=="*") cnt+=1;
                        }
                        else if (j==(n-1)){
                            if(a[i][j-1]=="*") cnt+=1;
                            if(a[i+1][j]=="*") cnt+=1;
                        }
                    }
                    if(i==(m-1)){
                        if(j!=0 && j!=(n-1)){
                            if(a[i-1][j]=="*") cnt+=1;
                            if(a[i-1][j+1]=="*") cnt+=1;
                            if(a[i-1][j-1]=="*") cnt+=1;
                            if(a[i][j+1]=="*") cnt+=1;
                            if(a[i][j-1]=="*") cnt+=1;
                        }
                        else if(j==0){
                            if(a[i][j+1]=="*") cnt+=1;
                            if(a[i-1][j]=="*") cnt+=1;
                        }
                        else if (j==(n-1)){
                            if(a[i][j-1]=="*") cnt+=1;
                            if(a[i-1][j]=="*") cnt+=1;
                        }
                    }
                    if(j==0){
                        if(i!=0 && i!=(m-1)){
                            if(a[i][j+1]=="*") cnt+=1;
                            if(a[i-1][j+1]=="*") cnt+=1;
                            if(a[i+1][j+1]=="*") cnt+=1;
                            if(a[i-1][j]=="*") cnt+=1;
                            if(a[i+1][j]=="*") cnt+=1;
                        }
                    }
                    if(j==(n-1)) {
                        if (i != 0 && i != (m - 1)) {
                            if (a[i][j - 1] == "*") cnt += 1;
                            if (a[i - 1][j - 1] == "*") cnt += 1;
                            if (a[i + 1][j - 1] == "*") cnt += 1;
                            if (a[i - 1][j] == "*") cnt += 1;
                            if (a[i + 1][j] == "*") cnt += 1;
                        }
                    }
                    a[i][j]=String.valueOf(cnt);
                }
            }
        }

        for (int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        }
    }

