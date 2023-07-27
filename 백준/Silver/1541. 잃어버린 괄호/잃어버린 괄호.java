import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String str = br.readLine();
    	String[] numbers = str.split("[^0-9]+");
    	String[] operators = str.split("[0-9]+");
    	
    	int[] nums = new int[numbers.length];
    	
    	for(int i = 0; i < numbers.length; i++) {
    		nums[i] = Integer.parseInt(numbers[i]);
    	}
    	
    	int total = nums[0];


    	for(int i = 1; i < operators.length; i++) {
    		if(operators[i].equals("-")) {
    			int sum = nums[i];
    			
    			while(i != operators.length - 1 &&operators[i + 1].equals("+")) {
    				sum += nums[i + 1];
    			
    				i++;
    			}

    			total -= sum;
    		} else {
    			total += nums[i];
    		}
    	}
		
    	System.out.print(total);
    	
    	br.close();
    }
    

}

