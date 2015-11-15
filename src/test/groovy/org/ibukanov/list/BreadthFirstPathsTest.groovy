package org.ibukanov.list

import spock.lang.Specification

class BreadthFirstPathsTest extends Specification {
    def "crete Breadth First Paths"() {
        when: "4 nodes"
        def node1 = new MultiLinkedListNode(1)
        def node2 = new MultiLinkedListNode(2)
        def node3 = new MultiLinkedListNode(3)
        def node4 = new MultiLinkedListNode(4)
        node2.nodes.add(node3)
        node2.nodes.add(node4)
        node1.nodes.add(node2)
        node1.nodes.add(node4)
        def bfs = new BreadthFirstPaths(node1)
        def path = bfs.pathTo(node4)
        then:
        path.size() == 2
        path[0] == node1
        path[1] == node4

        when: "6 nodes"
        def node5 = new MultiLinkedListNode(5)
        def node6 = new MultiLinkedListNode(6)
        node2.nodes.add(node5)
        node5.nodes.add(node6)
        node6.nodes.add(node2)
        node6.nodes.add(node1)
        def bfs2 = new BreadthFirstPaths(node2)
        def path2 = bfs2.pathTo(node6)
        then:
        path2.size() == 3
        path2[0] == node2
        path2[1] == node5
        path2[2] == node6

        when: "cycle"
        def path3 = bfs2.pathTo(node1)
        then:
        path3.size() == 4
        path3[0] == node2
        path3[1] == node5
        path3[2] == node6
        path3[3] == node1

        when: "same node"
        def path4 = bfs2.pathTo(node2)
        then:
        path4.size() == 1
        path4[0] == node2
    }
}