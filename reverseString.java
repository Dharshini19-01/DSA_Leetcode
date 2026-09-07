public class reverseString {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        s=s.trim();
        String[]str=s.split("\\s+");
        for(int i=str.length-1;i>=0;i--){
            sb.append(str[i]);
            if(i>0){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
