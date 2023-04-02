import java.util.ArrayList;
import java.util.stream.Collectors;

public class Solution2 {

	public static void main(String ar[]) {

		Solution2 sln = new Solution2();
		
		System.out.println("Solution -"+sln.solution("50552"));
		
		System.out.println("Solution -"+sln.solution("10101"));
		System.out.println("Solution -"+sln.solution("88"));

		
	}

	public int solution(String S) {
		int n=0;
		
		ArrayList<Integer> sl = new ArrayList<Integer>();
		
		if(S.startsWith("0")) {
			System.out.println("Input cannot start with 0");
			return 0;
		} 
		
		
		
		for (int i = 0; i < S.length(); i++) {
			if(i+2<S.length()) {
			Integer t=Integer.parseInt(S.substring(i,i+2));
			sl.add(t);	
			} else if(S.length() ==1 || S.length()== 2){
				Integer t=Integer.parseInt(S);
				sl.add(t);	
			}else {
			
				continue;
			}
			
		}
		
		sl=(ArrayList<Integer>) sl.stream().sorted().collect(Collectors.toList());
		
		
		if(sl.size()-1>0) {
			n=sl.get(sl.size()-1);
		} else
		{
			
		}

		// If all positive integers are present in the array, return the next integer
		return n ;
	}
}
