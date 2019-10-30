package com.steelzack.b2b2java8.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by joao on 28-5-16.
 */
public class FullSetRetrieval {

    public static Set<TreeNode<String>> getAllLeaves(TreeNode<String> treeNode) {
        final Stream<TreeNode<String>> childrenStream = treeNode.getChildrenStream();
        if (childrenStream == null) {
            return null;
        }

        Set<TreeNode<String>> ownLeaves = treeNode.getLeaves();

        ownLeaves.addAll(childrenStream.flatMap(stringTreeNode -> {
            Set<TreeNode<String>> allChildLeaves = getAllLeaves(stringTreeNode);
            if (allChildLeaves == null) {
                return Stream.empty();
            } else {
                allChildLeaves.addAll(allChildLeaves);
                return allChildLeaves.parallelStream();
            }
        }).collect(Collectors.toSet()));

        return ownLeaves;
    }

    public static class TreeNode<E> {
        private Stream<TreeNode<E>> childrenStrem;

        private Set<TreeNode<E>> leaves;
        private String name;

        public void setChildrenStrem(Stream<TreeNode<E>> childrenStrem) {
            this.childrenStrem = childrenStrem;
        }

        public String getName() {
            return name;
        }

        public TreeNode(String name){
            this.name = name;
            leaves = new HashSet<>();
        }
        public Stream<TreeNode<E>> getChildrenStream() {
            return childrenStrem;
        }

        public Set<TreeNode<E>> getLeaves() {
            return leaves;
        }
    }
}
