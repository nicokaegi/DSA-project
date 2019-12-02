package dependencies;
/*
 * Purpose: Data Structure and Algorithms Lab 11 Problem 3
 * Status: Complete and Thoroughly tested
 * Last update: 11/25/19
 * Submitted:  11/26/19
 * Comment: test suite and sample run attached
 * @author: Theresa Morris - Section 2
 * @version: 2019.11.25
 */

public class MyBinarySearchTreePlus <T extends KeyedItem<KT>, KT extends Comparable<? super KT>> extends MyBinarySearchTree<T,KT> implements BSTPInterface<T,KT>
{
    public int getHeight()
    {
        int left = 0;
        int right = 0;
        TreeNode<T> leftSide = root.getLeftChild();
        TreeNode<T> rightSide = root.getRightChild();

        if (root == null)
        {
            return 0;
        }
        if(leftSide == null && rightSide == null)
        {
            return 1;
        }
        else
        {
            //call ACTUAL recursive method to get my height
            left = findHeight(root.getLeftChild());
            right = findHeight(root.getRightChild());


        }
        if(left > right)
        {
            //we add one more to account for root.
            return left +1;
        }
        else
        {
            return right +1;
        }
    }


    private int findHeight(TreeNode<T> tnode)
    {

        int left;
        int right;
        if(tnode == null)
        {
            //when we reach the end of a tree, we stop.
            return 0;
        }
        else
        {
            left = findHeight(tnode.getLeftChild());
            right = findHeight(tnode.getRightChild());
        //we add one every time we return, per level.
          }
        if(left > right)
        {
          //we add one every time we return, per level.
            return left +1;
        }
        else
        {
            return right +1;
        }

    }

    public int getSize()
    {
        int size = 0;
        TreeNode<T> leftSide = root.getLeftChild();
        TreeNode<T> rightSide = root.getRightChild();

        if (root == null)
        {
            return 0;
        }
        if(leftSide == null && rightSide == null)
        {
            return 1;
        }
        else
        {
            //call ACTUAL recursive method to get my size
            size = findSize(root);
        }

        return size;

    }

    private int findSize(TreeNode<T> tnode)
    {
        int size;
        int left;
        int right;
        
        if(tnode == null)
        {
            //when we reach the end of a tree, we stop.
            return 0;
        }
        else
            {

        left = findSize(tnode.getLeftChild());
        right = findSize(tnode.getRightChild());
            }

        size = left + right + 1;

        return size;
    }


    public String toStringInorder()
    {
	StringBuilder buildList = new StringBuilder();
        return makeStringInOrder(root, buildList);
    }
    private String makeStringInOrder(TreeNode<T> tnode, StringBuilder buildList)
    {
        
        if(tnode == null)
        {
            return null;
        }
        makeStringInOrder(tnode.getLeftChild(),buildList);
        buildList.append(tnode.getItem().getKey() + " ");
        makeStringInOrder(tnode.getRightChild(),buildList);

        return buildList.toString();
    }

    public String toStringPreorder()
    {
        StringBuilder buildList = new StringBuilder();

        return makeStringPreorder(root,buildList);

    }

    private String makeStringPreorder(TreeNode<T> tnode,StringBuilder buildList)
    {

        if(tnode == null)
        {
            return null;
        }
        buildList.append(tnode.getItem().getKey() + " ");
        makeStringInOrder(tnode.getLeftChild(),buildList);
        makeStringInOrder(tnode.getRightChild(),buildList);
        return buildList.toString();
    }

    public String toStringPostorder()
    {
        StringBuilder buildList = new StringBuilder();
       
        return makeStringPostorder(root,buildList);

    }

    private String makeStringPostorder(TreeNode<T> tnode,StringBuilder buildList)
    {
        if(tnode == null)
        {
        	return null;
        }
        makeStringInOrder(tnode.getLeftChild(), buildList);
        makeStringInOrder(tnode.getRightChild(), buildList);
        buildList.append(tnode.getItem().getKey() + " ");
        return buildList.toString();
    }

    public MyBinarySearchTreePlus<T, KT> getCopyOfTree()
    {
	MyBinarySearchTreePlus<T, KT> copyTree = new MyBinarySearchTreePlus<T, KT>();
	copyTree.insert(root.getItem());
	copyNode(root, copyTree.root);
	
        return copyTree;
    }
    
    private void copyNode(TreeNode<T> old, TreeNode<T> copy)
    {
	if(old.getLeftChild() != null)
	    {
		copy.setLeftChild(new TreeNode<T>(old.getLeftChild().getItem()));
		copyNode(old.getLeftChild(), copy.getLeftChild());
	    }
	
	if(old.getRightChild() != null)
	    {
		copy.setRightChild(new TreeNode<T>(old.getRightChild().getItem()));
		copyNode(old.getRightChild(), copy.getRightChild());
	    }
    
    }
}
