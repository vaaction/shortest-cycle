package org.ibukanov.list

import spock.lang.Specification

class ShortestCycleTest extends Specification {
    def "shortest cycle"() {
        when: "4 nodes cycle"
        def node1 = new MultiLinkedListNode(1)
        def node2 = new MultiLinkedListNode(2)
        def node3 = new MultiLinkedListNode(3)
        def node4 = new MultiLinkedListNode(4)
        def node5 = new MultiLinkedListNode(5)
        def node6 = new MultiLinkedListNode(6)
        node2.nodes.add(node3)
        node2.nodes.add(node4)
        node1.nodes.add(node2)
        node1.nodes.add(node4)
        node2.nodes.add(node5)
        node5.nodes.add(node6)
        node6.nodes.add(node2)
        node6.nodes.add(node1)
        def shortestCycle = new ShortestCycle(node1)
        then:
        shortestCycle.cycle.size() == 4
        shortestCycle.cycle[0] == node2
        shortestCycle.cycle[1] == node5
        shortestCycle.cycle[2] == node6
        shortestCycle.cycle[3] == node2

        when: "3 nodes cycle"
        node1.nodes.add(node6)
        shortestCycle = new ShortestCycle(node1)
        then:
        shortestCycle.cycle.size() == 3
        shortestCycle.cycle[0] == node6
        shortestCycle.cycle[1] == node1
        shortestCycle.cycle[2] == node6
    }
}