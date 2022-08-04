/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode head = new PolyNode();
        PolyNode cur  = head;
        
        while (poly1 != null && poly2 != null) {
            if (poly1.power > poly2.power) {
                cur.next = new PolyNode(poly1.coefficient, poly1.power);
                cur = cur.next;
                poly1 = poly1.next;
            }
            else if (poly2.power > poly1.power) {
                cur.next = new PolyNode(poly2.coefficient, poly2.power);
                cur = cur.next;
                poly2 = poly2.next;
            }
            else {
                if (poly1.coefficient + poly2.coefficient != 0) {
                    cur.next = new PolyNode(poly1.coefficient + poly2.coefficient, poly1.power);
                    cur = cur.next;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
        }
        
        if (poly1 != null) {
            cur.next = poly1;
        } else if (poly2 != null) {
            cur.next = poly2;
        }
        
        return head.next;
    }
}