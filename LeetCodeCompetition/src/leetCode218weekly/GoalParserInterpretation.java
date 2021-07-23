package leetCode218weekly;

public class GoalParserInterpretation {
	
	public static String interpret(String command) {

		StringBuilder ret=new StringBuilder();
		
		for (int i=0;i<command.length();i++) {
			if (command.charAt(i)=='G') {
				ret.append('G');
			}else if (command.charAt(i)=='('&&command.charAt(i+1)==')') {
				ret.append('o');
			}else if (command.charAt(i)=='('&&command.charAt(i+1)=='a') {
				ret.append("al");
			}
		}
		
		return ret.toString();
		
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(interpret("(al)G(al)()()G"));
	}

}
