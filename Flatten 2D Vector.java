public class Vector2D {
    Queue<Iterator<Integer>> queue;
    Iterator<Integer> cur = null;
    public Vector2D(List<List<Integer>> vec2d) {
        queue = new LinkedList<Iterator<Integer>>();
        for (int i = 0; i < vec2d.size(); i++) {
            queue.add(vec2d.get(i).iterator());
        }
        cur = queue.poll();
    }

    public int next() {
        return cur.next();
    }

    public boolean hasNext() {
        if (cur == null) {
            return false;
        }
        while (!cur.hasNext()) {
            if (!queue.isEmpty()) {
                cur = queue.poll();
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
