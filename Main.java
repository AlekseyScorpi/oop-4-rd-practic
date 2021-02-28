import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("1-st task");
        task1();
        System.out.println("2-nd task");
        task2();
        System.out.println("3-rd task");
        task3();
        System.out.println("4-rd task");
        task4();
        System.out.println("5-rd task");
        task5();
        System.out.println("6-rd task");
        task6();
        System.out.println("7-rd task");
        task7();
        System.out.println("8-rd task");
        task8();
        System.out.println("9-rd task");
        task9();
        System.out.println("10-rd task");
        task10();
    }
    public static void task1(){
        System.out.println(sevenBoom(new int[]{1, 2, 3, 4, 5, 6, 7}));
        System.out.println(sevenBoom(new int[]{8, 6, 33, 100}));
        System.out.println(sevenBoom(new int[]{2, 55, 60, 97, 86}));
    }

    public static String sevenBoom(int[] arr){
        for (int i : arr) {
            if (Integer.toString(i).contains("7")) {
                return "Boom!";
            }
        }
        return "there is no 7 in the array";
    }
    public static void task2(){
        System.out.println(cons(new int[]{5,1,4,3,2}));
        System.out.println(cons(new int[]{5,1,4,3,2,8}));
        System.out.println(cons(new int[]{5,6,7,8,9,9}));
    }
    public static int getMinValue(int[] arr){
        int result = arr[1];
        for (int i : arr) result = Math.min(i, result);
        return result;
    }
    public static boolean cons(int[] arr){
        boolean isFound = true;
        int min = getMinValue(arr);
        for (int i = min; i < arr.length + min; i++){
            for(int element : arr){
                if (element == i){
                    isFound = true;
                    break;
                }
                isFound = false;
            }
        }
        return isFound;
    }

    public static void task3(){
        System.out.println(unmix("123456"));
        System.out.println(unmix("hTsii  s aimex dpus rtni.g"));
        System.out.println(unmix("badce"));
    }
    public static String unmix(String str){
        StringBuilder newStr = new StringBuilder();
        StringBuilder string = new StringBuilder(str);
        String tempStr;
        while (string.length() > 1){
            tempStr = string.substring(0,2);
            char temp1 = tempStr.charAt(1);
            char temp2 = tempStr.charAt(0);
            tempStr = (Character.toString(temp1) + Character.toString(temp2));
            string.deleteCharAt(0);
            string.deleteCharAt(0);
            newStr.append(tempStr);
        }
        if (string.equals("")){
            return newStr.toString();
        }else{
            return newStr.toString() + string;
        }
    }
    public static void task4(){
        System.out.println(noYelling("What went wrong?????????"));
        System.out.println(noYelling("Oh my goodness!!!"));
        System.out.println(noYelling("I just!!! can!!! not!!! believe!!! it!!!"));
        System.out.println(noYelling("Oh my goodness!"));
        System.out.println(noYelling("I just cannot believe it."));
    }
    public static String noYelling(String str){
        char symbol;
        if (str.charAt(str.length()-1) == '?' || str.charAt(str.length()-1) == '!'){
            symbol = str.charAt(str.length()-1);
        }else {
            return str;
        }
        while(str.charAt(str.length() - 2) == symbol){
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
    public static void task5(){
        System.out.println(xPronounce("Inside the box was a xylophone"));
        System.out.println(xPronounce("The x ray is excellent"));
        System.out.println(xPronounce("OMG x box unboxing video x D"));
    }
    public static String xPronounce(String str){
        StringBuilder string = new StringBuilder(str);
        if (string.charAt(0) == 'x' && string.charAt(1) != ' '){
            string.deleteCharAt(0);
            str = "z" + string.toString();
        }
        while (str.contains(" x ")){
            str = str.replaceFirst(" x ", " ecks ");
        }
        while (str.contains(" x")) {
            str = str.replaceFirst(" x", " z");
        }
        while (str.contains("x")){
            str = str.replaceFirst("x", "cks");
        }
        return str;
    }

    public static void task6(){
        System.out.println(largestGap(new int[]{9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}));
        System.out.println(largestGap(new int[]{14, 13, 7, 1, 4, 12, 3, 7, 7, 12, 11, 5, 7}));
        System.out.println(largestGap(new int[]{13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9}));
    }
    public static int largestGap(int[] arr){
        Arrays.sort(arr);
        int result = 0;
        for(int i = 1; i < arr.length; i++){
            if ((arr[i] - arr[i-1]) > result){
                result = arr[i] - arr[i-1];
            }
        }
        return result;
    }
    public static void task7(){
        System.out.println(challenge(832));
        System.out.println(challenge(51));
        System.out.println(challenge(7977));
        System.out.println(challenge(1));
        System.out.println(challenge(665));
        System.out.println(challenge(149));
    }
    public static int challenge(int num){
        int newNum = 0;
        String str = Integer.toString(num);
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++){
            arr[i] = Character.getNumericValue(str.charAt(i));
        }
        Arrays.sort(arr);
        int dec = 1;
        for (int i = arr.length - 1; i >= 0; i--){
            newNum += dec * arr[i];
            dec *= 10;
        }
        return num - newNum;
    }
    public static void task8(){
        System.out.println(commonLastVowel("Hello World!"));
        System.out.println(commonLastVowel("Watch the characters dance!"));
        System.out.println(commonLastVowel("OOI UUI EEI AAI"));
    }
    public static int getMaxIndex(int[] arr){
        int result = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
                result = i;
            }
        }
        return result;
    }
    public static char commonLastVowel(String str){
        str = str.toLowerCase(Locale.ROOT);
        String[] words = str.split(" ");
        int[] arr = new int[6];
        for(String word : words){
            char symbol = word.charAt(word.length() - 1);
            switch (symbol){
                case'a':
                    arr[0]++;
                    break;
                case'e':
                    arr[1]++;
                    break;
                case'i':
                    arr[2]++;
                    break;
                case'o':
                    arr[3]++;
                    break;
                case'u':
                    arr[4]++;
                    break;
                case'y':
                    arr[5]++;
                    break;
            }
        }
        int index = getMaxIndex(arr);
        switch(index){
            case 0:
                return 'a';
            case 1:
                return 'e';
            case 2:
                return 'i';
            case 3:
                return 'o';
            case 4:
                return 'u';
            case 5:
                return 'y';
        }
        return '!';
    }
    public static void task9(){
        System.out.println(memeSum(26, 39));
        System.out.println(memeSum(122, 81));
        System.out.println(memeSum(1222, 30277));
    }
    public static int memeSum(int num1, int num2){
        int[] arr = new int[Integer.toString(Math.max(num1, num2)).length()];
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (num1 > 0 || num2 > 0){
            arr[i] = num1 % 10 + num2 % 10;
            num1 /= 10;
            num2 /= 10;
            i++;
        }
        for (int j = arr.length - 1; j >= 0; j--){
            result.append(arr[j]);
        }
        return Integer.parseInt(result.toString());
    }
    public static void task10(){
        System.out.println(unrepeated("teshahset"));
        System.out.println(unrepeated("hello"));
        System.out.println(unrepeated("aaaaa"));
        System.out.println(unrepeated("WWE!!!"));
        System.out.println(unrepeated("call 911"));
    }
    public static String unrepeated(String str){
        char symbol;
        StringBuilder string = new StringBuilder(str);
        for (int i = 0; i < string.length(); i++){
            symbol = string.charAt(i);
            if(i == string.length()) break;
            for (int j = i + 1; j < string.length(); j++){
                if (symbol == string.charAt(j)){
                    string.deleteCharAt(j);
                    j--;
                }
            }
        }
        return string.toString();
    }

}
