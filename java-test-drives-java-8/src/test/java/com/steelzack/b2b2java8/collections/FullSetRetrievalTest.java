package com.steelzack.b2b2java8.collections;

import org.junit.Test;

import java.util.Set;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

/**
 * Created by joao on 28-5-16.
 */
public class FullSetRetrievalTest {

    @Test
    public void getAllLeaves() throws Exception {

        final FullSetRetrieval.TreeNode<String> treeNode = new FullSetRetrieval.TreeNode<>("ROOT");
        FullSetRetrieval.TreeNode<String> currentTreeNode = treeNode;
        for (int i = 0; i < 100; i++) {
            final FullSetRetrieval.TreeNode<String> newTeeNode = new FullSetRetrieval.TreeNode<>("CHILD" + i);
            currentTreeNode.setChildrenStrem(Stream.of(newTeeNode));
            add10Leaves(currentTreeNode, i);
            currentTreeNode = newTeeNode;
        }

        Set<FullSetRetrieval.TreeNode<String>> fullLeaves = FullSetRetrieval.getAllLeaves(treeNode);

        fullLeaves.stream().forEach(stringTreeNode -> System.out.println(stringTreeNode.getName()));

        assertThat(fullLeaves, hasSize(3000));
    }

    private void add10Leaves(FullSetRetrieval.TreeNode<String> treeNode, int iteration) {
        for (int i = 0; i < 30; i++) {
            treeNode.getLeaves().add(new FullSetRetrieval.TreeNode<>("LEAVE" + iteration + "-" + i));
        }
    }

}
