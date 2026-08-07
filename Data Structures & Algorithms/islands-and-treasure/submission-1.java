class Node{
    int row,col,distance;
    public Node(int row,int col,int distance){
        this.row=row;
        this.col=col;
        this.distance=distance;
    }
}
class Solution {
    private boolean isValid(int row,int col,int rows,int cols){
        return (row>=0 && row<rows && col>=0 && col<cols);
    }
    
    public void islandsAndTreasure(int[][] rooms) {
        int rows=rooms.length;
        int cols=rooms[0].length;
        int[][] direction=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        Queue<Node> q=new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(rooms[i][j]==0){
                    q.add(new Node(i,j,0));//added all the source points
                }
            }
        }
        while(!q.isEmpty()){
          Node curr=q.poll();
          //iterate in 4 directions  
          for(int[] dir:direction){
            int newRow=curr.row+dir[0];
            int newCol=curr.col+dir[1];
            if(isValid(newRow,newCol,rows,cols)&& rooms[newRow][newCol]==Integer.MAX_VALUE){
                rooms[newRow][newCol]=curr.distance+1;
                q.add(new Node(newRow,newCol,rooms[newRow][newCol]));
            }

          }
        }
    }
}
