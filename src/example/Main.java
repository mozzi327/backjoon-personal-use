package example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static int queuePrinter(int bufferSize, int capacities, int[] documents) {
        // TODO:
        /*
            문제
                김코딩은 최근 인쇄할 일이 많이 생겨 창고에서 안 쓰던 프린터를 꺼냈습니다.
                이 프린터의 성능을 테스트하여 새로운 프린터를 장만할지 결정하려고 합니다.
                김코딩은 프린터의 인쇄 작업 목록의 크기와 최대 용량을 가정하고
                각기 다른 용량의 문서를 차례대로 인쇄하여 모든 문서가 인쇄되는데 최소 몇 초가 걸리는지 테스트하기로 했습니다.
                프린터 인쇄 작업 목록의 제한사항은 다음과 같습니다.

                [제한사항]

                인쇄 작업 목록은 칸으로 이루어져 있습니다.
                각 칸에는 한 개의 문서만 위치할 수 있습니다.
                문서는 1초에 한 칸만 이동할 수 있습니다.
                인쇄 작업 목록의 크기는 bufferSize 이고 최대 용량 capacities 만큼 문서를 담을 수 있습니다.
                만약, 인쇄 작업 목록의 크기가 2이고 최대 용량이 10Kib라면 크기가 [7, 4, 5, 6] Kib인 문서들이
                최단 시간 안에 순서대로 모두 인쇄되는 과정은 다음과 같습니다.

                1초가 지나면 인쇄 작업 목록에는 7Kib 크기의 문서가 추가됩니다.

                2초일 때 인쇄 작업 목록의 최대 용량이 10Kib이기 때문에 4Kib 문서는 작업 목록에 들어갈 수 없습니다.
                동시에 7Kib 문서는 작업 목록에서 1칸 앞으로 이동합니다.

                3초일 때 7Kib 문서는 인쇄 작업 목록에서 나와 프린터가 인쇄합니다.
                동시에 4Kib 문서는 인쇄 작업 목록에 추가됩니다.

                4초일 때 4Kib 문서는 인쇄 작업 목록에서 1칸 앞으로 이동합니다.
                동시에 5Kib 문서는 인쇄 작업 목록에 추가됩니다.

                5초일 때 4Kib 문서는 인쇄 작업 목록에서 나와 프린터가 인쇄합니다.
                동시에 5Kib 문서는 인쇄 작업 목록에서 1칸 앞으로 이동합니다.
                최대 용량 10Kib 제한으로 6Kib 문서는 인쇄 작업 목록으로 추가될 수 없습니다.

                6초일 때 5Kib 문서는 인쇄 작업 목록에서 나와 프린터가 인쇄합니다.
                동시에 6Kib 문서가 인쇄 작업 목록에 추가됩니다.

                7초일 때 6Kib 문서는 인쇄 작업 목록에서 1칸 앞으로 이동합니다.

                8초일 때 6Kib 문서가 마지막으로 인쇄됩니다.

                위 예시에서와 같이 모든 문서가 출력되는데 걸리는 최소 시간은 8초가 걸립니다.

                김코딩이 가지고 있는 프린터의 제한사항인 인쇄 작업 목록의 크기 bufferSize, 최대 용량 capacities가 주어집니다.
                인쇄할 문서의 크기가 나열된 배열 documents 가 모두 인쇄되는데 걸리는 최소 시간을 반환하는 솔루션을 만들어 주세요.

            입력
                인자1: bufferSize
                int 타입의 인쇄 작업 목록 크기
                인자 2: capacities
                int 타입의 인쇄 작업 목록에 추가될 수 있는 최대 용량
                인자 3: documents
                int 타입을 요소로 갖는 문서 크기가 나열된 배열

            출력
                int 타입을 리턴해야 합니다.
         주의사항
                bufferSize는 1 이상 100 이하입니다.
                capacities는 100Kib 이하입니다.
                인쇄할 문서의 개수(배열의 길이) 1이상 100 이하입니다.
                문서 하나의 크기는 capacities를 초과하지 않습니다.

        */

        Queue<Integer> printQue = new LinkedList<>();

        int addPrintBufferSize = 0;
        int totalPrintTime = bufferSize;

        for(int size : documents){
            while(true){
                //버퍼에 출력물이 없는 경우
                if(printQue.isEmpty()){
                    printQue.offer(size);
                    addPrintBufferSize += size;
                    totalPrintTime++;
                    break;
                    //버퍼에 출력물이 들어갈 자리가 없는 경우
                }else if(printQue.size() == bufferSize){
                    addPrintBufferSize -= printQue.poll();
                }else{//버퍼에 자리도 있고 다음 출력물의 크기를 더해도 괜찮은 경우 printQue.offer()
                    if(capacities >= addPrintBufferSize + size){
                        printQue.offer(size);
                        addPrintBufferSize += size;
                        totalPrintTime++;
                        break;
                    }else{//버퍼에 자리는 있지만 크기가 초과인 경우
                        //버퍼의 자리를 가상으로 채워주기 위해 0을 넣음
                        printQue.offer(0);
                        totalPrintTime++;
                    }
                }
            }
        }

        return totalPrintTime;
    }


    public static ArrayList<Stack> browserStack(String[] actions, String start) {
        Stack<String> prevStack = new Stack<>();
        Stack<String> nextStack = new Stack<>();
        Stack<String> current = new Stack<>();
        ArrayList<Stack> result = new ArrayList<>();
        // TODO:


        current.push(start);
        for (int i = 0; i < actions.length; i++) {
            if (64 < (int) actions[i].charAt(0) && (int) actions[i].charAt(0) < 91) {
                prevStack.push(current.pop());
                current.push(actions[i]);
                nextStack.clear();
            } else if (actions[i].equals("-1")) {
                if (prevStack.isEmpty()) continue;
                nextStack.push(current.pop());
                current.push(prevStack.pop());
            } else if (actions[i].equals("1")) {
                if (nextStack.isEmpty()) continue;
                prevStack.push(current.pop());
                current.push(nextStack.pop());
            }
        }

        result.add(prevStack);
        result.add(current);
        result.add(nextStack);

        return result;
    }

    public static int paveBox(int[] boxes) {
        // TODO:
        // 마트에서 장을 보고 박스를 포장하려고 합니다. 박스를 포장하는 데는 폭이 너무 좁습니다.
        // 그렇기에 한 줄로 서 있어야 하고, 들어온 순서대로 한 명씩 나가야 합니다.
        // 불행 중 다행은, 인원에 맞게 포장할 수 있는 기구들이 놓여 있어, 모두가 포장을 할 수 있다는 것입니다.
        // 짐이 많은 사람은 짐이 적은 사람보다 포장하는 시간이 길 수밖에 없습니다.
        // 뒷사람이 포장을 전부 끝냈어도 앞사람이 끝내지 못하면 기다려야 합니다. 앞사람이 포장을 끝내면,
        // 포장을 마친 뒷사람들과 함께 한 번에 나가게 됩니다.
        // 만약, 앞사람의 박스는 5 개고, 뒷사람 1의 박스는 4 개, 뒷사람 2의 박스는 8 개라고 가정했을 때,
        // 뒷사람 1이 제일 먼저 박스 포장을 끝내게 되어도 앞사람 1의 포장이 마칠 때까지 기다렸다가 같이 나가게 됩니다.
        // 이때, 통틀어 최대 몇 명이 한꺼번에 나가는지 알 수 있도록 함수를 구현해 주세요.

        int numOfBoxes = 0;
        int maxPassNumOfPerson = 1;
        int numOfPersonCount = 1;
        Queue<Integer> boxesQueue = new LinkedList<>();

        for (int i = 0; i < boxes.length; i++) {
            boxesQueue.add(boxes[i]);
        }

        numOfBoxes = boxesQueue.poll();
        while (!boxesQueue.isEmpty()) {
            if (numOfBoxes >= boxesQueue.peek()) {
                boxesQueue.poll();
                numOfPersonCount++;
            } else {
                numOfBoxes = boxesQueue.poll();
                numOfPersonCount = 1;
            }
            if (maxPassNumOfPerson < numOfPersonCount) maxPassNumOfPerson = numOfPersonCount;
        }

        return maxPassNumOfPerson;
    }

    public static void main(String[] args) throws IOException {
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7, 4, 5, 6};

        int output = queuePrinter(bufferSize, capacities, documents);
        System.out.println(output); // 8
    }
}


