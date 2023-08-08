import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    int idx = 0;
    List<Integer> list;

    void add(List<NestedInteger> nestedList) {
        for (NestedInteger integer : nestedList) {
            if (!integer.isInteger())  // 不是数字, 递归
                add(integer.getList());
            else // 是数字, 直接加到 list
                list.add(integer.getInteger());
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        add(nestedList);
    }

    @Override
    public Integer next() {
        return list.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < list.size();
    }
public interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}