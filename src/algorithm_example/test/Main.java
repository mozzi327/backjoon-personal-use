package algorithm_example.test;

import java.lang.reflect.Field;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        int answer = 0;
        int number = 4;
        int power = 2;
        int limit = 3;

        int tmp;

        for(int i = 1; i <= number; i++) {
            tmp = 0;
            for(int j = 1; j <= number; j++) {
                if(i % j == 0) tmp++;
            }
            System.out.println(tmp);
            if(tmp <= limit) answer += tmp;
            else answer += power;
        }




    }


//    public static int solution(int[] elements) {
//        int answer = 0;
//        HashSet<Integer> result = new HashSet<>();
//        int size = elements.length;
//        int temp;
//        for(int i=0; i< (1<<size); i++) {
//            temp = 0;
//            for(int j=0; j< size; j++) {
//                if((i & 1 << j) != 0) {
//                    temp += elements[j];
//                }
//            }
//            result.add(temp);
//
//            System.out.println(result);
//        }
//
//        return result.size();
//    }


    public static class Temp {
        private int field1 = 0;
        private int field2 = 0;
        private int field3 = 0;
        private int field4 = 0;
        private int field5 = 0;
        private int field6 = 0;
        private int field7 = 0;
        private int field8 = 0;
        private int field9 = 0;
        private int field10 = 0;

        public void setField1(int field1) {
            this.field1 = field1;
        }

        public void setField2(int field2) {
            this.field2 = field2;
        }

        public void setField3(int field3) {
            this.field3 = field3;
        }

        public void setField4(int field4) {
            this.field4 = field4;
        }

        public void setField5(int field5) {
            this.field5 = field5;
        }

        public void setField6(int field6) {
            this.field6 = field6;
        }

        public void setField7(int field7) {
            this.field7 = field7;
        }

        public void setField8(int field8) {
            this.field8 = field8;
        }

        public void setField9(int field9) {
            this.field9 = field9;
        }

        public void setField10(int field10) {
            this.field10 = field10;
        }

        @Override
        public String toString() {
            return "Temp{" +
                    "field1=" + field1 +
                    ", field2=" + field2 +
                    ", field3=" + field3 +
                    ", field4=" + field4 +
                    ", field5=" + field5 +
                    ", field6=" + field6 +
                    ", field7=" + field7 +
                    ", field8=" + field8 +
                    ", field9=" + field9 +
                    ", field10=" + field10 +
                    '}';
        }
    }
}


