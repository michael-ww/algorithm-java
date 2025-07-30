package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gorgeous.algorithm.common.TreeNode;

public class LeetCode297Test {

    @Test
    public void serialize_deserialize_validInput_performExpected() {
        // Arrange
        LeetCode297 leetCode297 = new LeetCode297();
        TreeNode<Integer> root = new TreeNode<>(1);
        root.setLeft(new TreeNode<>(2));
        root.setRight(new TreeNode<>(3));
        root.getRight().setLeft(new TreeNode<>(4));
        root.getRight().setRight(new TreeNode<>(5));

        // Act
        String preorderSerialized = leetCode297.preorderSerialize(root);
        TreeNode<Integer> preorderDeserialized = leetCode297.preorderDeserialize(preorderSerialized);
        String postorderSerialized = leetCode297.postorderSerialize(root);
        TreeNode<Integer> postorderDeserialized = leetCode297.postorderDeserialize(postorderSerialized);
        String levelSerialized = leetCode297.levelSerialize(root);
        TreeNode<Integer> levelDeserialized = leetCode297.levelDeserialize(levelSerialized);

        // Assert
        Assertions.assertEquals("[1,2,null,null,3,4,null,null,5,null,null]", preorderSerialized);
        Assertions.assertNotNull(preorderDeserialized);
        Assertions.assertEquals(1, preorderDeserialized.getValue().intValue());
        Assertions.assertNotNull(preorderDeserialized.getLeft());
        Assertions.assertEquals(2, preorderDeserialized.getLeft().getValue().intValue());
        Assertions.assertNull(preorderDeserialized.getLeft().getLeft());
        Assertions.assertNull(preorderDeserialized.getLeft().getRight());
        Assertions.assertNotNull(preorderDeserialized.getRight());
        Assertions.assertEquals(3, preorderDeserialized.getRight().getValue().intValue());
        Assertions.assertNotNull(preorderDeserialized.getRight().getLeft());
        Assertions.assertEquals(4, preorderDeserialized.getRight().getLeft().getValue().intValue());
        Assertions.assertNull(preorderDeserialized.getRight().getLeft().getLeft());
        Assertions.assertNull(preorderDeserialized.getRight().getLeft().getRight());
        Assertions.assertNotNull(preorderDeserialized.getRight().getRight());
        Assertions.assertEquals(5, preorderDeserialized.getRight().getRight().getValue().intValue());
        Assertions.assertNull(preorderDeserialized.getRight().getRight().getLeft());
        Assertions.assertNull(preorderDeserialized.getRight().getRight().getRight());

        Assertions.assertEquals("[null,null,2,null,null,4,null,null,5,3,1]", postorderSerialized);
        Assertions.assertNotNull(postorderDeserialized);
        Assertions.assertEquals(1, postorderDeserialized.getValue().intValue());
        Assertions.assertNotNull(postorderDeserialized.getLeft());
        Assertions.assertEquals(2, postorderDeserialized.getLeft().getValue().intValue());
        Assertions.assertNull(postorderDeserialized.getLeft().getLeft());
        Assertions.assertNull(postorderDeserialized.getLeft().getRight());
        Assertions.assertNotNull(postorderDeserialized.getRight());
        Assertions.assertEquals(3, postorderDeserialized.getRight().getValue().intValue());
        Assertions.assertNotNull(postorderDeserialized.getRight().getLeft());
        Assertions.assertEquals(4, postorderDeserialized.getRight().getLeft().getValue().intValue());
        Assertions.assertNull(postorderDeserialized.getRight().getLeft().getLeft());
        Assertions.assertNull(postorderDeserialized.getRight().getLeft().getRight());
        Assertions.assertNotNull(postorderDeserialized.getRight().getRight());
        Assertions.assertEquals(5, postorderDeserialized.getRight().getRight().getValue().intValue());
        Assertions.assertNull(postorderDeserialized.getRight().getRight().getLeft());
        Assertions.assertNull(postorderDeserialized.getRight().getRight().getRight());

        Assertions.assertEquals("[1,2,3,null,null,4,5,null,null,null,null]", levelSerialized);
        Assertions.assertNotNull(levelDeserialized);
        Assertions.assertEquals(1, levelDeserialized.getValue().intValue());
        Assertions.assertNotNull(levelDeserialized.getLeft());
        Assertions.assertEquals(2, levelDeserialized.getLeft().getValue().intValue());
        Assertions.assertNull(levelDeserialized.getLeft().getLeft());
        Assertions.assertNull(levelDeserialized.getLeft().getRight());
        Assertions.assertNotNull(levelDeserialized.getRight());
        Assertions.assertEquals(3, levelDeserialized.getRight().getValue().intValue());
        Assertions.assertNotNull(levelDeserialized.getRight().getLeft());
        Assertions.assertEquals(4, levelDeserialized.getRight().getLeft().getValue().intValue());
        Assertions.assertNull(levelDeserialized.getRight().getLeft().getLeft());
        Assertions.assertNull(levelDeserialized.getRight().getLeft().getRight());
        Assertions.assertNotNull(levelDeserialized.getRight().getRight());
        Assertions.assertEquals(5, levelDeserialized.getRight().getRight().getValue().intValue());
        Assertions.assertNull(levelDeserialized.getRight().getRight().getLeft());
        Assertions.assertNull(levelDeserialized.getRight().getRight().getRight());
    }
}
