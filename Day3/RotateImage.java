class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            int t=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=t;
        }
       } 
    
       for(int i=0;i<n;i++){
        rev(matrix[i]);
       }
    }
       public void rev(int[] row){
        int l=0,r=row.length-1;
        while(l<r){
            int t=row[l];
            row[l]=row[r];
            row[r]=t;
            l++;
            r--;
        }
       }

    }