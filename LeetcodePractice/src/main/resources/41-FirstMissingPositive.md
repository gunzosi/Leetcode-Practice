
### Ví Dụ: Mảng `[3, 4, -1, 1]`

#### 1. **Gọi Phương Thức:**

```java
public static void main(String[] args) {
    int[] nums = {3, 4, -1, 1};
    int result = firstMissingPositive(nums);
    System.out.println("Số nguyên dương nhỏ nhất không có: " + result);
}
```

**Đầu vào:** `[3, 4, -1, 1]`

#### 2. **Phương Thức `firstMissingPositive`:**

```java
public static int firstMissingPositive(int[] nums) {
    placeNumbers(nums);  // Sắp xếp các số vào đúng vị trí
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) {
            return i + 1;  // Trả về số nguyên dương nhỏ nhất không có trong mảng
        }
    }
    return nums.length + 1; // Trả về nums.length + 1 nếu tất cả các số từ 1 đến nums.length đều có mặt
}
```

**Bước 1: Gọi `placeNumbers(nums)`**

#### 3. **Phương Thức `placeNumbers`:**

```java
private static void placeNumbers(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n; i++) {
        while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
            swap(nums, i, nums[i] - 1);
        }
    }
}
```

**Bước 2: Thực hiện `placeNumbers`**

1. **Mảng ban đầu:** `[3, 4, -1, 1]`

    - **`i = 0`:** `nums[0] = 3`
        - Kiểm tra điều kiện `nums[i] > 0 && nums[i] <= n` (3 > 0 và 3 <= 4), và `nums[nums[i] - 1] != nums[i]` (`nums[3 - 1] != nums[0]` tương đương với `nums[2] != 3` (tức là `-1 != 3`)).
        - Điều kiện đúng, thực hiện hoán đổi: `swap(nums, 0, 2)`
            - Mảng sau khi hoán đổi: `[ -1, 4, 3, 1]`
        - Kiểm tra lại từ đầu `i = 0` vì giá trị đã thay đổi.

    - **`i = 0`:** `nums[0] = -1`
        - Kiểm tra điều kiện `nums[i] > 0` không đúng (vì -1 không lớn hơn 0), nên không thực hiện hoán đổi.

    - **`i = 1`:** `nums[1] = 4`
        - Kiểm tra điều kiện `nums[i] > 0 && nums[i] <= n` (4 > 0 và 4 <= 4), và `nums[nums[i] - 1] != nums[i]` (`nums[4 - 1] != nums[1]` tương đương với `nums[3] != 4` (tức là `1 != 4`)).
        - Điều kiện đúng, thực hiện hoán đổi: `swap(nums, 1, 3)`
            - Mảng sau khi hoán đổi: `[ -1, 1, 3, 4]`
        - Kiểm tra lại từ đầu `i = 1` vì giá trị đã thay đổi.

    - **`i = 1`:** `nums[1] = 1`
        - Kiểm tra điều kiện `nums[i] > 0 && nums[i] <= n` (1 > 0 và 1 <= 4), và `nums[nums[i] - 1] != nums[i]` (`nums[1 - 1] != nums[1]` tương đương với `nums[0] != 1` (tức là `-1 != 1`)).
        - Điều kiện đúng, thực hiện hoán đổi: `swap(nums, 1, 0)`
            - Mảng sau khi hoán đổi: `[1, -1, 3, 4]`
        - Kiểm tra lại từ đầu `i = 1` vì giá trị đã thay đổi.

    - **`i = 1`:** `nums[1] = -1`
        - Kiểm tra điều kiện `nums[i] > 0` không đúng (vì -1 không lớn hơn 0), nên không thực hiện hoán đổi.

    - **`i = 2`:** `nums[2] = 3`
        - Kiểm tra điều kiện `nums[i] > 0 && nums[i] <= n` (3 > 0 và 3 <= 4), và `nums[nums[i] - 1] != nums[i]` (`nums[3 - 1] != nums[2]` tương đương với `nums[2] != 3` (tức là `3 != 3`)).
        - Điều kiện không đúng, nên không thực hiện hoán đổi.

    - **`i = 3`:** `nums[3] = 4`
        - Kiểm tra điều kiện `nums[i] > 0 && nums[i] <= n` (4 > 0 và 4 <= 4), và `nums[nums[i] - 1] != nums[i]` (`nums[4 - 1] != nums[3]` tương đương với `nums[3] != 4` (tức là `4 != 4`)).
        - Điều kiện không đúng, nên không thực hiện hoán đổi.

**Mảng sau khi sắp xếp bằng `placeNumbers`:** `[1, -1, 3, 4]`

**Bước 3: Chạy vòng lặp kiểm tra kết quả**

- **Kiểm tra:** `for (int i = 0; i < nums.length; i++)`
    - **`i = 0`:** `nums[0] = 1`, đúng vị trí (`1 == 0 + 1`), tiếp tục kiểm tra.
    - **`i = 1`:** `nums[1] = -1`, không đúng vị trí (`-1 != 1`), trả về `i + 1`, tức là `2`.

**Kết quả:** `2`

---

### Ví Dụ 2: Mảng `[-2, -3, 2, 4]`

#### 1. **Gọi Phương Thức:**

```java
public static void main(String[] args) {
    int[] nums = {-2, -3, 2, 4};
    int result = firstMissingPositive(nums);
    System.out.println("Số nguyên dương nhỏ nhất không có: " + result);
}
```

**Đầu vào:** `[-2, -3, 2, 4]`

#### 2. **Phương Thức `firstMissingPositive`:**

```java
public static int firstMissingPositive(int[] nums) {
    placeNumbers(nums);  // Sắp xếp các số vào đúng vị trí
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) {
            return i + 1;  // Trả về số nguyên dương nhỏ nhất không có trong mảng
        }
    }
    return nums.length + 1; // Trả về nums.length + 1 nếu tất cả các số từ 1 đến nums.length đều có mặt
}
```

**Bước 1: Gọi `placeNumbers(nums)`**

#### 3. **Phương Thức `placeNumbers`:**

```java
private static void placeNumbers(int[] nums) {
    int n = nums.length;

    for (int i = 0; i < n; i++) {
        while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
            swap(nums, i, nums[i] - 1);
        }
    }
}
```

**Bước 2: Thực hiện `placeNumbers`**

1. **Mảng ban đầu:** `[-2, -3, 2, 4]`

    - **`i = 0`:** `nums[0] = -2`
        - Điều kiện `nums[i] > 0` không đúng (vì -2 không lớn hơn 0), nên không thực hiện hoán đổi.

    - **`i = 1`:** `nums[1] = -3`
        - Điều kiện `nums[i] > 0` không đúng (vì -3 không lớn hơn 0), nên không thực hiện hoán đổi.

    - **`i = 2`:** `nums[2] = 2`
        - Kiểm tra điều kiện `nums[i] > 0 && nums[i] <= n` (2 >

0 và 2 <= 4), và `nums[nums[i] - 1] != nums[i]` (`nums[2 - 1] != nums[2]` tương đương với `nums[1] != 2` (tức là `-3 != 2`)).
- Điều kiện đúng, thực hiện hoán đổi: `swap(nums, 2, 1)`
- Mảng sau khi hoán đổi: `[-2, 2, -3, 4]`
- Kiểm tra lại từ đầu `i = 2` vì giá trị đã thay đổi.

- **`i = 2`:** `nums[2] = -3`
    - Điều kiện `nums[i] > 0` không đúng (vì -3 không lớn hơn 0), nên không thực hiện hoán đổi.

- **`i = 3`:** `nums[3] = 4`
    - Kiểm tra điều kiện `nums[i] > 0 && nums[i] <= n` (4 > 0 và 4 <= 4), và `nums[nums[i] - 1] != nums[i]` (`nums[4 - 1] != nums[3]` tương đương với `nums[3] != 4` (tức là `4 != 4`)).
    - Điều kiện không đúng, nên không thực hiện hoán đổi.

**Mảng sau khi sắp xếp bằng `placeNumbers`:** `[-2, 2, -3, 4]`

**Bước 3: Chạy vòng lặp kiểm tra kết quả**

Sau khi chạy phương thức `placeNumbers`, mảng `[-2, 2, -3, 4]` được sắp xếp. Tiếp theo, phương thức `firstMissingPositive` sẽ thực hiện vòng lặp để tìm số nguyên dương nhỏ nhất không có mặt trong mảng. Dưới đây là chi tiết từng bước:

### Mảng sau khi sắp xếp bằng `placeNumbers`

Sau khi chạy phương thức `placeNumbers`, mảng là: `[-2, 2, -3, 4]`.

## 3. Chạy vòng lặp kiểm tra kết quả

Dưới đây là vòng lặp kiểm tra kết quả trong phương thức `firstMissingPositive`:

```java
for (int i = 0; i < nums.length; i++) {
    if (nums[i] != i + 1) {
        return i + 1;  // Trả về số nguyên dương nhỏ nhất không có trong mảng
    }
}
return nums.length + 1;
```

**Bước 1: Khởi tạo**

- `nums.length = 4`

**Bước 2: Vòng lặp kiểm tra**

- **`i = 0`:** `nums[0] = -2`
    - So sánh: `nums[0] != 0 + 1` (tức là `-2 != 1`)
    - Điều kiện đúng, vì `-2` không bằng `1`.
    - Trả về: `i + 1`, tức là `0 + 1 = 1`.

### Kết quả

- Vì điều kiện `nums[0] != 1` đúng, phương thức `firstMissingPositive` trả về `1`.

### Tổng Kết

Với mảng `[-2, 2, -3, 4]` sau khi sắp xếp, phương thức `firstMissingPositive` tìm số nguyên dương nhỏ nhất không có mặt trong mảng và trả về `1`.

#### Giải Thích Chi Tiết Vong Lặp trong `firstMissingPositive`

```java
for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
```

1. **Khởi tạo**: Mảng ban đầu là `[-2, 2, -3, 4]`.
2. **Sắp xếp**: Mảng không thay đổi sau khi chạy `placeNumbers` vì không có số nguyên dương trong khoảng `[1, nums.length]` để hoán đổi.
3. **Kiểm tra kết quả**:
    - `i = 0`: `nums[0]` là `-2`, không bằng `1`.
    - Do đó, phương thức trả về `1` ngay lập tức mà không kiểm tra các chỉ số khác.

Phương thức này hoạt động tốt để xác định số nguyên dương nhỏ nhất không có mặt trong mảng, trong trường hợp này là `1`.

- **Kiểm tra:** `for (int i = 0; i < nums.length; i++)`
    - **`i = 0`:** `nums[0] = -2`, không đúng vị trí (`-2 != 1`), trả về `i + 1`, tức là `1`.

**Kết quả:** `1`

---

