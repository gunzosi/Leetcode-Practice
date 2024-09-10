package med;

public class LC2807GreatestCommonDivisor {

    // Định nghĩa lớp ListNode
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // Hàm tính GCD sử dụng thuật toán Euclid
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Hàm chính để chèn các nút GCD vào danh sách liên kết
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Trả về nếu danh sách có 1 nút hoặc ít hơn
        }

        ListNode current = head;

        // Duyệt qua danh sách liên kết và chèn các nút GCD
        while (current.next != null) {
            // Tính GCD của giá trị nút hiện tại và nút tiếp theo
            int gcdValue = gcd(current.val, current.next.val);

            // Tạo một nút mới với giá trị GCD
            ListNode newNode = new ListNode(gcdValue);

            // Chèn nút mới giữa nút hiện tại và nút tiếp theo
            newNode.next = current.next;
            current.next = newNode;

            // Di chuyển đến cặp nút tiếp theo
            current = newNode.next;
        }

        return head;
    }

    // Hàm hỗ trợ in danh sách liên kết
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Xuống dòng sau khi in xong
    }

    // Hàm main để kiểm tra kết quả
    public static void main(String[] args) {
        // Tạo danh sách liên kết mẫu: [18, 6, 10, 3]
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);

        // Gọi hàm xử lý
        LC2807GreatestCommonDivisor solution = new LC2807GreatestCommonDivisor();
        ListNode updatedHead = solution.insertGreatestCommonDivisors(head);

        // In danh sách liên kết sau khi chèn GCD
        System.out.print("Danh sách sau khi chèn GCD: ");
        printList(updatedHead); // Output: 18 6 6 2 10 1 3
    }
}
