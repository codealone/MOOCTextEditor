package spelling;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
		size=0;
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{
	    //TODO: Implement this method.
		TrieNode curr=root;
		int s = size;
		String w = word.toLowerCase();
		for(int i=0;i<w.length();i++){
			Set <Character> c = curr.getValidNextCharacters();
			if(c.contains((Character)w.charAt(i))){
				curr = curr.getChild(w.charAt(i));
			}else{
				curr = curr.insert(w.charAt(i));
				if(curr!=null)
					size++;
				else
					curr=curr.getChild(w.charAt(i));
			}
			if(i==w.length()-1)
				curr.setEndsWord(true);
		}
		if(s==size)
			return false;
		else
			return true;
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
	    TrieNode curr=root,temp=root,prev=root;
	    int cnt=0,i;
	    ArrayList<TrieNode> c = new ArrayList<TrieNode>();
	    ArrayList<Character> ac = new ArrayList<Character>();
	    c.add(root);
	    while(!c.isEmpty())
	    {
	    	curr=c.get(0);
	    	if(curr==null)
	    		break;
	    	ac.addAll(curr.getValidNextCharacters());
	    	for(i=0;i<ac.size();i++)
	    	{
	    		temp=curr.getChild(ac.get(i));
	    		if(temp.endsWord())
	    			cnt++;
	    		c.add(temp);
	    	}
	    	ac.clear();
	    	c.remove(0);
	   }
	   return cnt;
	}
	
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{
	    // TODO: Implement this method
		boolean flag=true;
		String n = s.toLowerCase();
		TrieNode curr=root;
		if(n.length()==0)
			return false;
		else{
			for(int i=0;i<n.length();i++)
			{
				if(curr.getValidNextCharacters().contains((Character)n.charAt(i))){
					curr=curr.getChild(n.charAt(i));
				}
				else{
					flag=false;
					break;
				}
			}
			return flag;
		}
		
	}
	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 List<String> v = new ArrayList<String>();
    	 String pre = prefix.toLowerCase();
    	 TrieNode curr =root,temp=root;
    	 int i;
    	 if(pre.length()==0 || numCompletions==0);
    	 else
    	 {
    		 for(i=0;i<pre.length();i++)
        	 {
        		 if(curr.getValidNextCharacters().contains((Character)pre.charAt(i)))
        			 curr=curr.getChild(pre.charAt(i));
        		 else
        		 {
        			 curr=null;
        			 break;
        		 }
        		 if(i==pre.length()-1 && curr!=null){
        			 if(curr.endsWord())
        			v.add(curr.getText());
        		 }
        	 }
    	 }
    	 if(curr==null || numCompletions==0)
    		 return v;
    	 else
    	 {
        		 List<TrieNode> c = new ArrayList<TrieNode>();
        		 List<Character> ac = new ArrayList<Character>();
        		 c.add(curr);
        		 while(!c.isEmpty() && v.size()!=numCompletions)
        		 {
        			 curr=c.get(0);
        			 ac.addAll(curr.getValidNextCharacters());
        			 for(i=0;i<ac.size();i++)
        			 {
        				 temp=curr.getChild(ac.get(i));
        				 if(temp.endsWord() && v.size()<numCompletions)
        					 v.add(temp.getText());
        				 c.add(temp);
        			 }
        			 c.remove(0);
        			 ac.clear();
        		 }
        		 return v;
        	 }
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
}