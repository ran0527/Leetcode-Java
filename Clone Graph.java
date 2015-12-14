/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hm.put(node, head);
        stack.push(node);

        while (!stack.isEmpty()) {
            UndirectedGraphNode currNode = stack.pop();
            for (UndirectedGraphNode aNeighbor: currNode.neighbors) {
                if (!hm.containsKey(aNeighbor)) {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(aNeighbor.label);
                    stack.push(aNeighbor);
                    hm.put(aNeighbor, newNeighbor);
                }
                hm.get(currNode).neighbors.add(hm.get(aNeighbor));
            }
        }
        return head;
    }
}
