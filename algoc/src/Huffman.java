

import java.util.*;

abstract class HuffmanTree implements Comparable<HuffmanTree> 
{
    public final int frequency; 
    public HuffmanTree(int freq) { frequency = freq; }

    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}

class HuffmanLeaf extends HuffmanTree {
    public final char value; 

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        value = val;
    }
}

class HuffmanNode extends HuffmanTree {
    public final HuffmanTree left, right;

    public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}

public class Huffman {
    public static HuffmanTree buildTree(int[] charFreqs, char[] test2) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();
        
        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], test2[i]));

        assert trees.size() > 0;
       
        while (trees.size() > 1) {
      
            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    public static void printCodes(HuffmanTree tree, StringBuffer prefix) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            System.out.println(leaf.value + "\t" + leaf.frequency + "\t" + prefix);

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;
            prefix.append('0');
            printCodes(node.left, prefix);
            prefix.deleteCharAt(prefix.length()-1);
            prefix.append('1');
            printCodes(node.right, prefix);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    public static void main(String[] args) {
        String str = "12345678"; 
        char[] test2 = str.toCharArray();
        int[] charFreqs = {36,18,12,9,7,6,5,4};
        HuffmanTree tree = buildTree(charFreqs,test2);
        System.out.println("SYMBOL\tFREQ\tHUFFMAN CODE");
        printCodes(tree, new StringBuffer());
    }
}
