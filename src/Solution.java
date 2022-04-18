import java.util.HashMap;
class Solution {
    public static void main(String [] args){
        String [] words = {"apple","apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(isAlienSorted(words, order));
    }
    public static boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> alphabet = new HashMap<>();
        for (int i = 0; i < order.length(); i ++){
            alphabet.put(order.charAt(i), i);
        }
        String current = "";
        String comparer = "";
        for (int i = 0; i < words.length - 1; i ++){
            int first = 0;
            int second = 0;
            current = words[i];
            comparer = words[i + 1];
            while (true){
                if (comparer.equals("") && current.equals("")){
                    break;
                }
                if (current.equals("") && !comparer.equals("")){
                    first = - 1;
                    second = alphabet.get(comparer.charAt(0));
                }
                else if (comparer.equals("") && !current.equals("")){
                    second = -1;
                    first = alphabet.get(current.charAt(0));
                }
                else {
                    first = alphabet.get(current.charAt(0));
                    second = alphabet.get(comparer.charAt(0));
                    if (second > first){
                        break;
                    }
                }
                if (first > second){
                    return false;
                }
                if (first == -1 && current.equals("")){
                    break;
                }
                current =  current.substring(1);
                comparer = comparer.substring(1);
            }

        }
        return true;
    }
}