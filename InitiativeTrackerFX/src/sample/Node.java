/**
 * Created by GreenManPDX on 8/8/2016.
 */
package sample;
class Node
{
    //protected Character character;
    protected Node link;
    protected int order;

    /*  Constructor  */
    public Node()
    {
        link = null;
        order = 0;
    }
    /*  Constructor  */
    public Node(int val, Node n)
    {
        //character = incoming;
        order = val;
        link = n;
    }
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }
    /*  Function to set current to current Node  */
    public void setOrder(int d)
    {
        order = d;
    }
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }
    /*  Function to get initiative from current Node  */
    public int getOrder()
    {
        return order;
    }
}