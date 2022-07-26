package example;

import java.util.*;

public class Solution {
    private String value;
    private ArrayList<Solution> children;

    public Solution() {	//전달인자가 없을 경우의 생성자
        this.value = null;
        this.children = null;
    }
    public Solution(String data) {	//전달인자가 존재할 경우의 생성자
        this.value = data;
        this.children = null;
    }

    public void setValue(String data) {
        this.value = data;
    }

    public String getValue() {      //현재 노드의 데이터를 반환
        return this.value;
    }
    public void addChildNode(Solution node) {
        if(children.size()==2) children = new ArrayList<>();
        children.add(node);
    }
    public void removeChildNode(Solution node) {
        if(node.getChildrenNode() != null) children.remove(node);
    }

    public ArrayList<Solution> getChildrenNode() {
        return children;
    }

    public boolean contains(String data) {      //재귀를 사용하여 값을 검색합니다.
        if(value.equals(data)) return true;

        if(children != null) {
            for(int i = 0; i < children.size(); i++) {
                return children.get(i).contains(children.get(i).getValue());
            }
        }
        return false;
    }
}
