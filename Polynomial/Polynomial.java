
class Node {
    private  Node head = null;
    int coefficient;
    int power;
    Node next = null;
    
    Node(int coefficient,int power) {
        this.coefficient = coefficient;
        this.power = power;
        this.head = this;
    }

    Node createNode(int coefficient, int power) {
        head = this;
        Node node = new Node(coefficient,power);
        if(head == null) {
            head = node;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return head;
        
    }

    static void display(Node node) {
        while(node != null) {
            if(node.next != null)
                System.out.print( "" + node.coefficient + "x^" + node.power + "+" );
            else 
            System.out.print( "" + node.coefficient + "x^" + node.power  );
            node = node.next;
        }
    }
}

/**
 * Polynomial
 */
public class Polynomial {
    public static void main(String[] args) {
        //Creating Frist Polynomial
        Node poly1 = new Node(3,4);
        poly1.createNode(12, 2);
        poly1.createNode(10, 0);
        System.out.println("Displaying Polynomial 1");
        Node.display(poly1);
        System.out.println();
        System.out.println();
        
        //Creating Second Polynomial
        Node poly2 = new Node(5, 3);
        poly2.createNode(4, 2);
        poly2.createNode(3, 0);
        System.out.println("Displaying Polynomial 2");
        Node.display(poly2);
        System.out.println();
        System.out.println();

        // Arithmetic of two Polynomial
        Node arithmetic = arithmetic(poly1, poly2);
        System.out.println("Arithmetic of two polynomial");
        System.out.println();
        Node.display(arithmetic);
        System.out.println();
        

    }

    static Node  arithmetic(Node p1, Node p2) {
        Node poly3 = null;
        Node curp1 = p1;
        Node curp2 = p2;
        while(curp1 != null && curp2 != null) {
            if(curp1.power > curp2.power) {
                if(poly3 == null) {
                    poly3 = new Node(curp1.coefficient, curp1.power);
                    
                }
                else {
                    poly3.createNode(curp1.coefficient, curp1.power);
                }
                curp1 = curp1.next;
            }
            else if(curp1.power < curp2.power) {
                if(poly3 == null) {
                    poly3 = new Node(curp2.coefficient, curp2.power);
                    
                }
                else {
                    poly3.createNode(curp2.coefficient, curp2.power);
                }
                curp2 = curp2.next;
            }
            else {
                if(poly3 == null) {
                    poly3 = new Node(curp2.coefficient + curp1.coefficient, curp2.power);
                    
                }
                else {
                    poly3.createNode(curp2.coefficient + curp1.coefficient, curp2.power);
                }
                curp2 = curp2.next;
                curp1 = curp1.next;
            }
        }
        
        return poly3;
    }
}