public class ZigzagIterator {
    LinkedList<Iterator> list;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<Iterator>();
        if (!v1.isEmpty()) {
            list.add(v1.iterator());
        }
        if (!v2.isEmpty()) {
            list.add(v2.iterator());
        }
    }

    public int next() {
        Iterator top = list.remove();
        int res = (Integer)top.next();
        if (top.hasNext()) {
            list.add(top);
        }
        return res;
    }

    public boolean hasNext() {
        return (!list.isEmpty());
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
