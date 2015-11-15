package org.ibukanov.list

import spock.lang.Specification

class MultiLinkedListNodeTest extends Specification {
    def "crete list"() {
        when:
        def list = new MultiLinkedListNode(3)
        list.nodes.add(new MultiLinkedListNode(2))
        then:
        list.nodes.size() == 1
        list.item == 3
        list.nodes[0].item == 2
        list.nodes[0].nodes.empty
    }
}