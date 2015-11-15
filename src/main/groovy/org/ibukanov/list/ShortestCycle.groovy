package org.ibukanov.list

class ShortestCycle {
    final def cycle = []
    private final def used = []

    public ShortestCycle(MultiLinkedListNode node) {
        dfs(node)
    }

    private dfs(MultiLinkedListNode node) {
        if (!used.contains(node)) {
            used.add(node)
            node.nodes.each { MultiLinkedListNode adj ->
                computeCycle(node, adj)
                dfs(adj)
            }
        }
    }

    private computeCycle(MultiLinkedListNode parent, MultiLinkedListNode child) {
        def bfs = new BreadthFirstPaths(child)
        def pathToParent = bfs.pathTo(parent)
        if (!pathToParent.empty) {
            if (cycle.empty || cycle.size() > pathToParent.size() + 1) {
                changeCycle(parent, pathToParent)
            }
        }
    }

    private changeCycle(parent, List pathToParent) {
        cycle.clear()
        cycle.add(parent)
        cycle.addAll(pathToParent)
    }
}
