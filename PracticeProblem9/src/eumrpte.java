import java.util.*;
public class eumrpte {
    public static void main(String [] args){
        String word;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        word = sc.nextLine();
        sc.close();

        ArrayList<String> list = permute(word);

        for(int i=0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
    // A class for permutation. Returns the list of scrambled letters.
    public static ArrayList<String> permute(String s){
        if (s.length()==0) {
            return new ArrayList<String>();
        }
        else if (s.length()==1) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(s);
            return list;
        }
        else {
            String temp;
            char first_char;
            // Creates the list
            ArrayList<String> list = new ArrayList<String>();
            ArrayList<String> tlist = null;
            // Scrambles the letters.
            for(int j=0; j<s.length(); j++){
                first_char = s.charAt(j);
                temp = s.substring(j+1) + s.substring(0,j);
                tlist = permute(temp);
                for(int i=0; i < tlist.size(); i++){
                    temp = tlist.get(i);
                    list.add(first_char + temp);
                }
                tlist.clear();
            }
            return list;
        }
    }
}