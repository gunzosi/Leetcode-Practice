# 2260 - Minimum Consecutive Cards to Pick Up

Chúng ta sẽ giải thích từng dòng của mã nguồn và tính toán chi tiết với ví dụ thực tế: **cards = [3, 4, 2, 3, 4, 7]**. Tôi sẽ giải thích từng dòng và tính toán kết quả của từng bước khi mã được chạy.

### Đoạn mã code solution:

```java
public int minimumCardPickup(int[] cards) {
    Map<Integer, Integer> map = new HashMap<>(); // Bản đồ để lưu giá trị lá bài và vị trí xuất hiện cuối cùng
    int min = Integer.MAX_VALUE; // Khởi tạo biến min với giá trị lớn nhất
    for (int i = 0; i < cards.length; i++) { // Duyệt qua từng lá bài trong mảng cards
        if (map.containsKey(cards[i])) { // Kiểm tra xem lá bài này đã xuất hiện trước đó chưa
            min = Math.min(i - map.get(cards[i]) + 1, min); // Tính và cập nhật khoảng cách nhỏ nhất
        }
        map.put(cards[i], i); // Cập nhật vị trí của lá bài hiện tại vào bản đồ
    }
    return min == Integer.MAX_VALUE ? -1 : min; // Trả về khoảng cách nhỏ nhất hoặc -1 nếu không có cặp trùng
}
```

### Áp dụng thực tế:

#### 1. **Khởi tạo bản đồ (`map`) và biến `min`:**
```java
Map<Integer, Integer> map = new HashMap<>();
int min = Integer.MAX_VALUE;
```
- **Thực tế:** Chúng ta cần một bản đồ (`map`) để lưu vị trí xuất hiện cuối cùng của mỗi lá bài.
- **`min`** được khởi tạo là **Integer.MAX_VALUE** (2^31 - 1 = 2147483647), là một giá trị rất lớn để so sánh sau này.
    - **`map` ban đầu:** `{}` (rỗng)
    - **`min` ban đầu:** `2147483647`

#### 2. **Vòng lặp qua từng lá bài (`for`):**

Vòng lặp này sẽ duyệt qua từng lá bài trong mảng **cards**. Chúng ta sẽ theo dõi từng bước với các tính toán chi tiết.

##### Bước 1: **i = 0**, **cards[0] = 3**

```java
if (map.containsKey(cards[i])) { // Không có lá bài 3 trong map
    // Không làm gì
}
map.put(cards[0], 0); // Thêm lá bài 3 vào map với vị trí 0
```

- **Thực tế:** Lá bài 3 chưa từng xuất hiện, vì vậy chúng ta chỉ thêm nó vào bản đồ (`map.put(3, 0)`).
    - **`map`:** `{3=0}`
    - **`min`:** `2147483647` (không thay đổi vì chưa có cặp trùng)

##### Bước 2: **i = 1**, **cards[1] = 4**

```java
if (map.containsKey(cards[1])) { // Không có lá bài 4 trong map
    // Không làm gì
}
map.put(cards[1], 1); // Thêm lá bài 4 vào map với vị trí 1
```

- **Thực tế:** Lá bài 4 chưa từng xuất hiện, chỉ cần thêm vào bản đồ (`map.put(4, 1)`).
    - **`map`:** `{3=0, 4=1}`
    - **`min`:** `2147483647` (không thay đổi vì chưa có cặp trùng)

##### Bước 3: **i = 2**, **cards[2] = 2**

```java
if (map.containsKey(cards[2])) { // Không có lá bài 2 trong map
    // Không làm gì
}
map.put(cards[2], 2); // Thêm lá bài 2 vào map với vị trí 2
```

- **Thực tế:** Lá bài 2 chưa từng xuất hiện, chỉ cần thêm vào bản đồ (`map.put(2, 2)`).
    - **`map`:** `{3=0, 4=1, 2=2}`
    - **`min`:** `2147483647` (không thay đổi vì chưa có cặp trùng)

##### Bước 4: **i = 3**, **cards[3] = 3**

```java
if (map.containsKey(cards[3])) { // Có lá bài 3 trong map ở vị trí 0
    min = Math.min(3 - map.get(3) + 1, min); // min = Math.min(3 - 0 + 1, 2147483647) = 4
}
map.put(cards[3], 3); // Cập nhật lại vị trí của lá bài 3 là 3
```

- **Thực tế:** Lá bài 3 đã xuất hiện trước đó ở vị trí 0. Tính khoảng cách giữa hai lá bài 3: `3 - 0 + 1 = 4`.
    - Cập nhật **`min = 4`**.
    - **`map`:** `{3=3, 4=1, 2=2}`
    - **`min`:** `4`

##### Bước 5: **i = 4**, **cards[4] = 4**

```java
if (map.containsKey(cards[4])) { // Có lá bài 4 trong map ở vị trí 1
    min = Math.min(4 - map.get(4) + 1, min); // min = Math.min(4 - 1 + 1, 4) = 4
}
map.put(cards[4], 4); // Cập nhật lại vị trí của lá bài 4 là 4
```

- **Thực tế:** Lá bài 4 đã xuất hiện trước đó ở vị trí 1. Tính khoảng cách giữa hai lá bài 4: `4 - 1 + 1 = 4`.
    - **`min`** không thay đổi vì giá trị khoảng cách mới bằng với giá trị hiện tại.
    - **`map`:** `{3=3, 4=4, 2=2}`
    - **`min`:** `4`

##### Bước 6: **i = 5**, **cards[5] = 7**

```java
if (map.containsKey(cards[5])) { // Không có lá bài 7 trong map
    // Không làm gì
}
map.put(cards[5], 5); // Thêm lá bài 7 vào map với vị trí 5
```

- **Thực tế:** Lá bài 7 chưa từng xuất hiện, chỉ cần thêm vào bản đồ (`map.put(7, 5)`).
    - **`map`:** `{3=3, 4=4, 2=2, 7=5}`
    - **`min`:** `4` (không thay đổi)

#### 3. **Trả về kết quả:**
```java
return min == Integer.MAX_VALUE ? -1 : min; // min != Integer.MAX_VALUE, nên trả về min = 4
```

- **Thực tế:** Giá trị của `min` đã được cập nhật là `4`, do đó hàm sẽ trả về **4**.

### Kết luận:

Kết quả của chương trình là **4**, có nghĩa là khoảng cách nhỏ nhất giữa hai lá bài giống nhau là 4 lá bài liên tiếp.

- **Ví dụ thực tế:** Tập hợp lá bài liên tiếp chứa cặp bài trùng nhỏ nhất là `[3, 4, 2, 3]` với khoảng cách là 4 lá bài.