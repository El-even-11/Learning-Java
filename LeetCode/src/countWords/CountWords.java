package countWords;

public class CountWords {
	
	public static int countSegments(String s) {
        if (s.length()==0){
            return 0;
        }

        String[] words=s.split(" ");
        
        int cnt=0;
        for (int i=0;i<words.length;i++) {
        	if (!words[i].equals("")) {
        		cnt++;
        	}
        }
        return cnt;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countSegments(", , , ,        a, eaefa"));
	}

}
