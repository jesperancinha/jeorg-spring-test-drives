package org.jesperancinha.b2b2java8.collections;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by joao on 28-5-16.
 */
@Slf4j
public class FullSetRetrieval2WithLambdaMethodTest {
    @Test
    public void getAllLeaves() {

        final FullSetRetrieval2WithLambdaMethod.TreeNode<String> treeNode = new FullSetRetrieval2WithLambdaMethod.TreeNode<>("ROOT");
        FullSetRetrieval2WithLambdaMethod.TreeNode<String> currentTreeNode = treeNode;
        for (int i = 0; i < 100; i++) {
            final FullSetRetrieval2WithLambdaMethod.TreeNode<String> newTeeNode = new FullSetRetrieval2WithLambdaMethod.TreeNode<>("CHILD" + i);
            currentTreeNode.setChildrenStrem(Stream.of(newTeeNode));
            add10Leaves(currentTreeNode, i);
            currentTreeNode = newTeeNode;
        }

        Set<FullSetRetrieval2WithLambdaMethod.TreeNode<String>> fullLeaves = FullSetRetrieval2WithLambdaMethod.getAllLeaves(treeNode);

        fullLeaves.forEach(stringTreeNode -> log.info(stringTreeNode.getName()));

        assertThat(fullLeaves).hasSize(3000);
    }

    @Test
    public void getAllLeaves2Parallel() {

        final FullSetRetrieval2WithLambdaMethod.TreeNode<String> rootNode = new FullSetRetrieval2WithLambdaMethod.TreeNode<>("ROOT");
        final FullSetRetrieval2WithLambdaMethod.TreeNode<String> treeNode = new FullSetRetrieval2WithLambdaMethod.TreeNode<>("CHILD1-0");
        final FullSetRetrieval2WithLambdaMethod.TreeNode<String> treeNode2 = new FullSetRetrieval2WithLambdaMethod.TreeNode<>("CHILD2-0");
        rootNode.setChildrenStrem(Stream.of(treeNode, treeNode2));
        FullSetRetrieval2WithLambdaMethod.TreeNode<String> currentTreeNode = treeNode;
        FullSetRetrieval2WithLambdaMethod.TreeNode<String> currentTreeNode2 = treeNode2;
        add10Leaves(currentTreeNode, 0);
        add10Leaves(currentTreeNode2, 0);

        for (int i = 1; i < 100; i++) {
            final FullSetRetrieval2WithLambdaMethod.TreeNode<String> newTeeNode = new FullSetRetrieval2WithLambdaMethod.TreeNode<>("CHILD1-" + i);
            final FullSetRetrieval2WithLambdaMethod.TreeNode<String> newTeeNode2 = new FullSetRetrieval2WithLambdaMethod.TreeNode<>("CHILD2-" + i);
            currentTreeNode.setChildrenStrem(Stream.of(newTeeNode));
            currentTreeNode2.setChildrenStrem(Stream.of(newTeeNode2));
            add10Leaves(currentTreeNode, i);
            add10Leaves(currentTreeNode2, i);
            currentTreeNode = newTeeNode;
            currentTreeNode2 = newTeeNode2;
        }

        Set<FullSetRetrieval2WithLambdaMethod.TreeNode<String>> fullLeaves = FullSetRetrieval2WithLambdaMethod.getAllLeaves(rootNode);

        fullLeaves.stream().forEach(stringTreeNode -> System.out.println(stringTreeNode.getName()));

        assertThat(fullLeaves).hasSize(6000);
    }

    private void add10Leaves(FullSetRetrieval2WithLambdaMethod.TreeNode<String> treeNode, int iteration) {
        for (int i = 0; i < 30; i++) {
            treeNode.getLeaves().add(new FullSetRetrieval2WithLambdaMethod.TreeNode<>("LEAVE" + iteration + "-" + i));
        }
    }

}
