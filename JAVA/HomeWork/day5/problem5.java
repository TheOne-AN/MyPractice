package day5;
//leetcode 925 长按键入
public class problem5 {
    public boolean isLongPressedName(String name, String typed){
        int i = 0;
        for (int j = 0; j < typed.length(); j++) {
            if (name.charAt(i)== typed.charAt(j)){
                    i++;
            }
            if ( i == name.length()) {
                break;
            }
        }
        return i == name.length();
    }
}
