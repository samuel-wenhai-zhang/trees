//(c) A+ Computer Science
//www.apluscompsci.com

//Name - Samuel Zhang

public class HistoTree<T extends Comparable<T>>
{
   private HistoNode<T> root;

	public HistoTree( )
	{
		root = null;
	}

	public void addData(T data)
	{
		add(data, root);
	}

	private HistoNode<T> add(T data, HistoNode<T> tree)
	{	
		if (root == null) {
			root = new HistoNode<T>(data, 1, null, null);
		}
		else if (tree == null) {
			tree = new HistoNode<T>(data, 1, null, null);
		}
		else {
			if (data.compareTo(tree.getData()) == 0) {
				tree.setDataCount(tree.getDataCount() + 1);
			}
			else if (data.compareTo(tree.getData()) < 0) {
				tree.setLeft(add(data, tree.getLeft()));
			}
			else {
				tree.setRight(add(data, tree.getRight()));
			}
		}
		return tree;
	}

	public HistoNode<T> search(T data)
	{
		return search(data, root);
	}

	private HistoNode<T> search(T data, HistoNode<T> tree)
	{
		if (tree != null) {
			if (tree.getData().compareTo(data) == 0) {
				return tree;
			}
			if (data.compareTo(tree.getData()) < 0) {
				return search(data, tree.getLeft());
			} 
			else {
				return search(data, tree.getRight());
			}
		}
		return null;
	}

	public String toString()
	{
		return toString(root);
	}

	private String toString(HistoNode<T> tree)
	{
		if (tree != null) {
			return toString(tree.getLeft()) + tree.getData() + " - " + tree.getDataCount() + "    " + toString(tree.getRight());
		}
		return "";
	}
}