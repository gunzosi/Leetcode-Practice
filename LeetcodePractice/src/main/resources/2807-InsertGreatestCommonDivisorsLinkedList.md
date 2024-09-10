> #### **Ước chung lớn nhất (GCD - Greatest Common Divisor)** của hai số là số nguyên dương lớn nhất chia hết cả hai số đó.

### # Cách tính GCD
Có nhiều cách để tính **Ước chung lớn nhất (GCD)**, nhưng phổ biến nhất là **thuật toán Euclid**. Thuật toán này dựa trên việc lặp đi lặp lại việc thay thế một số bằng phần dư của phép chia hai số cho đến khi một trong hai số bằng 0. Lúc đó, giá trị của số còn lại chính là **GCD**.

### # Công thức tính GCD (Thuật toán Euclid)
Giả sử cần tính GCD của hai số \(a\) và \(b\):
1. Nếu \(b = 0\), thì **GCD(a, b) = a**.
2. Nếu \(b ≠ 0\), thì **GCD(a, b) = GCD(b, a % b)** (với `%` là phép chia lấy dư).

### # Ví dụ:

1. **GCD của 18 và 6**:
    - GCD(18, 6) = 6 (vì 6 chia hết cho cả 18 và 6).

2. **GCD của 6 và 10**:
    - GCD(6, 10):
        - Lấy 10 chia 6, dư 4. Tính tiếp GCD(6, 4).
        - Lấy 6 chia 4, dư 2. Tính tiếp GCD(4, 2).
        - Lấy 4 chia 2, dư 0. Khi dư bằng 0, GCD là 2.
        - Vậy, GCD(6, 10) = 2.

3. **GCD của 10 và 3**:
    - GCD(10, 3):
        - Lấy 10 chia 3, dư 1. Tính tiếp GCD(3, 1).
        - Lấy 3 chia 1, dư 0. Khi dư bằng 0, GCD là 1.
        - Vậy, GCD(10, 3) = 1.

### # Tính chất của GCD:
- Nếu một số là ước của số còn lại, thì GCD của hai số chính là số nhỏ hơn.
- Nếu hai số không có ước chung ngoài 1, thì GCD của chúng là 1.

--------------------------------

Dưới đây là tài liệu **Markdown** cho bài 2807: **Chèn ước chung lớn nhất vào danh sách liên kết**, bao gồm hướng dẫn chi tiết và kết quả đầu ra sau mỗi đoạn code.

---

# 2807: Chèn Ước Chung Lớn Nhất vào Danh Sách Liên Kết

## Mô tả bài toán

Cho danh sách liên kết `head`, trong đó mỗi nút chứa một giá trị nguyên.

Giữa mỗi cặp nút liền kề, hãy chèn một nút mới với giá trị bằng **ước chung lớn nhất (GCD)** của hai giá trị đó.

Trả về danh sách liên kết sau khi đã chèn các nút.

**Ước chung lớn nhất (GCD)** của hai số là số nguyên dương lớn nhất chia hết cho cả hai số.

### Input:

- Một danh sách liên kết gồm các số nguyên.
- `1 <= Node.val <= 1000`
- `Số lượng nút trong danh sách nằm trong khoảng [1, 5000]`

### Output:

- Một danh sách liên kết sau khi đã chèn các nút mới giữa mỗi cặp nút liền kề.

---

## Ví dụ 1

**Input**: `head = [18,6,10,3]`

**Output**: `[18,6,6,2,10,1,3]`

### Giải thích:
- Chèn GCD của 18 và 6 = 6 giữa nút 1 và nút 2.
- Chèn GCD của 6 và 10 = 2 giữa nút 2 và nút 3.
- Chèn GCD của 10 và 3 = 1 giữa nút 3 và nút 4.
- Không còn cặp nút liền kề, trả về danh sách đã cập nhật.

## Ví dụ 2

**Input**: `head = [7]`

**Output**: `[7]`

### Giải thích:
- Không có cặp nút liền kề, trả về danh sách ban đầu.

---

## Các bước giải quyết

### 1. Định nghĩa lớp `ListNode`

Đầu tiên, chúng ta cần định nghĩa cấu trúc của một danh sách liên kết đơn giản trong Java.

```java
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}
```

### 2. Hàm tính GCD (sử dụng thuật toán Euclid)

Tiếp theo, ta cài đặt hàm tính **GCD** của hai số nguyên bằng cách sử dụng **thuật toán Euclid**.

```java
public static int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}
```

#### Ví dụ sử dụng:

```java
System.out.println(gcd(18, 6));  // Output: 6
System.out.println(gcd(6, 10));  // Output: 2
System.out.println(gcd(10, 3));  // Output: 1
```

### 3. Giải thuật chính: Chèn nút GCD vào danh sách liên kết

Bây giờ, chúng ta sẽ cài đặt thuật toán chính để duyệt qua danh sách liên kết, tính GCD giữa các nút liền kề và chèn một nút mới với giá trị GCD vào giữa chúng.

```java
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;  // Không có cặp nút liền kề
        }

        ListNode current = head;

        // Duyệt qua danh sách liên kết
        while (current != null && current.next != null) {
            // Tính GCD của nút hiện tại và nút tiếp theo
            int gcdValue = gcd(current.val, current.next.val);

            // Tạo một nút mới với giá trị GCD
            ListNode newNode = new ListNode(gcdValue);

            // Chèn nút mới giữa nút hiện tại và nút tiếp theo
            newNode.next = current.next;
            current.next = newNode;

            // Di chuyển đến cặp nút tiếp theo (bỏ qua nút mới chèn)
            current = newNode.next;
        }

        return head;
    }
}
```

### 4. Kiểm tra chương trình

Chúng ta sẽ tạo các test case để kiểm tra chương trình.

```java
public class Main {
    public static void main(String[] args) {
        // Tạo danh sách liên kết mẫu: [18, 6, 10, 3]
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);

        // Gọi hàm xử lý
        Solution solution = new Solution();
        ListNode updatedHead = solution.insertGreatestCommonDivisors(head);

        // In danh sách liên kết sau khi chèn GCD
        printList(updatedHead);
    }

    // Hàm hỗ trợ in danh sách liên kết
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
```

### 5. Kết quả:

Với danh sách liên kết đầu vào `[18, 6, 10, 3]`, chương trình sẽ xuất ra:

```
18 6 6 2 10 1 3
```

### Giải thích:
- Chèn GCD của 18 và 6 = 6.
- Chèn GCD của 6 và 10 = 2.
- Chèn GCD của 10 và 3 = 1.

Danh sách liên kết cuối cùng sẽ là: `[18, 6, 6, 2, 10, 1, 3]`.

Với danh sách liên kết đầu vào `[7]`, chương trình sẽ xuất ra:

```
7
```

### Giải thích:
- Không có cặp nút liền kề để xử lý, vì vậy kết quả vẫn giữ nguyên.

---

## Phân tích độ phức tạp

- **Độ phức tạp thời gian**: O(n), với `n` là số lượng nút trong danh sách liên kết. Chúng ta duyệt qua danh sách và chèn các nút mới vào giữa, mỗi lần tính GCD tốn thời gian hằng số.
- **Độ phức tạp không gian**: O(1), vì chúng ta chỉ sử dụng một lượng không gian hằng số cho các biến tạm thời để duyệt và chèn nút.

---
