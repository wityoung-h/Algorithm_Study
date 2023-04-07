import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int n = Integer.parseInt(br.readLine());
              
       BinaryTree parent = new BinaryTree(n);
       
       System.out.print(count(parent));
       
       br.close();
    }
    
    public static int count(BinaryTree nowVisit) {
    	if(nowVisit.height == 0) {
    		return 1;
    	} else {
    		return count(nowVisit.tree1) + count(nowVisit.tree2);
    	}
    }
}

class BinaryTree {
	int height;
	BinaryTree tree1;
	BinaryTree tree2;
	
	public BinaryTree(int n) {
		if(n == 0) {
			height = 0;
			tree1 = null;
			tree2 = null;
		} else {
			height = n;
			tree1 = new BinaryTree(n - 1);
			tree2 = new BinaryTree(n - 1);
		}
	}
}