package org.ibukanov.list

class BreadthFirstPaths {

    private final def initialNode
    private final def queue = []
    private final def childToParentMap = [:]
    private final def path = []

    public BreadthFirstPaths(MultiLinkedListNode initialNode) {
        this.initialNode = initialNode
        queue.push(initialNode)
        childToParentMap.put(initialNode, initialNode)
        bfs()
    }

    public pathTo(MultiLinkedListNode finalNode) {
        path.clear()
        if (initialNode.equals(finalNode)) {
            path.add(finalNode)
            path
        } else {
            if (childToParentMap.containsKey(finalNode)) {
                path.add(finalNode)
                computePath()
            }
            path.reverse()
        }
    }

    private bfs() {
        while (!queue.empty) {
            def node = queue.pop()
            node.nodes.each { MultiLinkedListNode adj ->
                if (!childToParentMap.containsKey(adj)) {
                    childToParentMap.put(adj, node)
                    queue.push(adj)
                }
            }
            bfs()
        }
    }

    private computePath() {
        def previousNode = childToParentMap.get(path.last())
        path.add(previousNode)
        if (!previousNode.equals(initialNode)) {
            computePath()
        }
    }
}
