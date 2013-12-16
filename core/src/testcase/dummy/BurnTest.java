/*
TOD - Trace Oriented Debugger.
Copyright (c) 2006-2008, Guillaume Pothier
All rights reserved.

This program is free software; you can redistribute it and/or 
modify it under the terms of the GNU General Public License 
version 2 as published by the Free Software Foundation.

This program is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
General Public License for more details.

You should have received a copy of the GNU General Public License 
along with this program; if not, write to the Free Software 
Foundation, Inc., 59 Temple Place, Suite 330, Boston, 
MA 02111-1307 USA

Parts of this work rely on the MD5 algorithm "derived from the 
RSA Data Security, Inc. MD5 Message-Digest Algorithm".
*/
package dummy;

/**
 * A fully instrumented, CPU-intensive program.
 * @author gpothier
 */
public class BurnTest
{
	private static int rndSeed = 1234598;
	private static final int N = 50000;
	
	public static void main(String[] args)
	{
		System.out.println("Burn test");
//		StringBuilder b = new StringBuilder("ho");
//		while(true)
//		{
//			b.append(b.toString());
//		}
		
		// Warm up
		Node root = createTree(null, 10000);
		System.out.println("BurnTest.main()");
		for (int i=0;i<10;i++) root.visit();
		
		// Real thing
		long t0 = System.currentTimeMillis();
		root = createTree(null, N);
		long t1 = System.currentTimeMillis();
		for (int i=0;i<100;i++) root.visit();
		long t2 = System.currentTimeMillis();
		
		float dt1 = 1f*(t1-t0)/1000;
		float dt2 = 1f*(t2-t1)/1000;
		
		System.out.println(String.format("Create: %.2fs, visit: %.2fds", dt1, dt2));
	}
	
	public static int random(int max)
	{
		rndSeed = rndSeed*57 + 9;
		if (rndSeed<0) rndSeed = -rndSeed;
		return rndSeed % max;
	}
	
	/**
	 * Generates a tree with n nodes.
	 */
	public static Node createTree(Node parent, int n)
	{
		Node[] children = new Node[10];
		if (n == 1) return new Node(parent, null, "leaf");
		
		Node node = new Node(parent, children, "Subtree size: "+n);
		
		int remaining = n;
		int i=0;
		while (remaining > 0)
		{
			int subN = i < 9 ? random(1 + n/2) : remaining;
			children[i] = subN > 0 ? createTree(node, subN) : null;
			remaining -= subN;
			i++;
		}
		
		return node;
	}
	
	private static class Node
	{
		private Node itsParent;
		private Node[] itsChildren;
		private Object itsValue;

		public Node(Node aParent, Node[] aChildren, Object aValue)
		{
			itsParent = aParent;
			itsChildren = aChildren;
			itsValue = aValue;
		}

		public Node getParent()
		{
			return itsParent;
		}
		
		public Node[] getChildren()
		{
			return itsChildren;
		}
		
		public Object getValue()
		{
			return itsValue;
		}
		
		public void visit()
		{
			if (itsChildren != null)
			{
				for (Node child : itsChildren) if (child != null) child.visit();
			}
		}
	}
}
