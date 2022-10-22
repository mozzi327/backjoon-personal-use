package rabin_karp;


import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long beforeTime = System.currentTimeMillis();
        String parent = "abcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwddqwdascdasdasdaabacabacacabcabcsbabascbacbacacqcabcacbacbcabcabc";
        String pattern = "dasdasdasdwqdqwddqwdascdasdasdaabacabacacabcabcsbabascbacbacacqcabcacba";
        int parentSize = parent.length();
        int patternSize = pattern.length();
        int power = 1;
        int parentHash = 0;
        int patternHash = 0;
        int result = 0;

        for (int i = 0; i <= parentSize - patternSize; i++) {
            if (i == 0) {
                for (int j = 0; j < patternSize; j++) {
                    parentHash += parent.charAt(patternSize - 1 - j) * power;
                    patternHash += pattern.charAt(patternSize - 1 - j) * power;
                    if (j < patternSize - 1) power *= 2;
                }
            } else {
                parentHash = 2 * (parentHash - parent.charAt(i - 1) * power) + parent.charAt(patternSize - 1 + i);
            }
            if (parentHash == patternHash) {
                boolean finded = true;
                for (int j = 0; j < patternSize; j++) {
                    if (parent.charAt(i + j) != pattern.charAt(j)) {
                        finded = false;
                        break;
                    }
                }
                if (finded) {
                    System.out.println(i + 1 + "번째에서 발견했습니다.");
                    result++;
                }
            }
        }

        System.out.println(result);
        long afterTime = System.currentTimeMillis();
        double secDiffTime = (afterTime - beforeTime) /1000.0;
        System.out.println(secDiffTime);
    }



//    public static void main(String[] args) {
//        long beforeTime = System.currentTimeMillis();
//        String parent = "abcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwdbcdeeadsadwqdasadgsdfabcdaabcaaacbabdasdasdasdwqdqwddqwdascdasdasdaabacabacacabcabcsbabascbacbacacqcabcacbacbcabcabc";
//        String pattern = "dasdasdasdwqdqwddqwdascdasdasdaabacabacacabcabcsbabascbacbacacqcabcacba";
//        int parentSize = parent.length();
//        int patternSize = pattern.length();
//        int patternHash = pattern.hashCode();
//        int result = 0;
//
//        for (int i = 0; i <= parentSize - patternSize; i++) {
//            int partHash = parent.substring(i, i + patternSize).hashCode();
//            if (partHash == patternHash) {
//                System.out.println(i + 1+ "번째에서 발견됐습니다.");
//                result ++;
//            }
//        }
//
//        System.out.println(result);
//        long afterTime = System.currentTimeMillis();
//        double secDiffTime = (afterTime - beforeTime) /1000.0;
//        System.out.println(secDiffTime);
//    }
}

class Main2 {
    public List<Integer> search(String whole, String pattern) {
        List<Integer> pos = new LinkedList<>();
        int wholeSize = whole.length();
        int patternSize = pattern.length();
        int wholeHash = hash(whole, wholeSize);
        int partHash = hash(pattern, patternSize);
        int pow = 1 << (patternSize - 1);

        for (int i = 0; i < wholeSize - patternSize; i++) {
            if (i != 0) {
                int removeValue = whole.charAt(i - 1) * pow; // 맨 앖 해쉬 값
                int newValue = whole.charAt(i - 1 + patternSize); // 맨 뒤 값
                wholeHash = 2 * (wholeHash - removeValue) + newValue;
            }

            if (wholeHash == partHash) {
                boolean find = true;
                for (int j = 0; j < patternSize; j++) {
                    if (whole.charAt(i + j) != pattern.charAt(j)) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    pos.add(i);
                }
            }
        }

        return pos;
    }

    private static int hash(String string, int length) {
        int hash = 0, power = 1;

        for (int i = length - 1; i >= 0; i--) {
            hash += string.charAt(i) * power;
            power *= 2;
        }

        return hash;
    }
}
