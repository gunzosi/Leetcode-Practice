# 2028. Find Missing Observations 

### # Bài toán: "2028. Find Missing Observations"

Bạn có m lần tung xúc xắc 6 mặt với các kết quả đã biết, và có n lần tung bị thiếu. Nhiệm vụ của bạn là tìm n kết quả bị thiếu sao cho **giá trị trung bình** của toàn bộ n + m lần tung bằng một số nguyên **mean** cho trước.

### # Yêu cầu chi tiết:
- Bạn có m lần tung đã biết, được lưu trữ trong mảng **rolls**. Ví dụ: `rolls = [3, 2, 4, 3]`.
- Bạn biết tổng cộng có n + m lần tung, nhưng n lần tung đã bị mất, và bạn cần tìm ra n giá trị này.
- Giá trị trung bình của tất cả các lần tung là **mean**.
- Mỗi giá trị tung xúc xắc đều nằm trong khoảng từ 1 đến 6.

### # Yêu cầu đầu ra:
Trả về một mảng gồm n số nguyên đại diện cho các kết quả bị thiếu, sao cho trung bình của n + m lần tung bằng **mean**. Nếu không có kết quả hợp lệ, trả về mảng rỗng.

### # Các ví dụ:

#### Ví dụ 1:
**Input:**
```
rolls = [3, 2, 4, 3]
mean = 4
n = 2
```
**Output:**
```
[6, 6]
```
**Giải thích:**
- Tổng của tất cả các lần tung phải bằng `4 * (2 + 4) = 24`.
- Tổng của các lần tung đã biết là `3 + 2 + 4 + 3 = 12`.
- Như vậy, tổng của 2 lần tung còn thiếu phải bằng `24 - 12 = 12`.
- Các kết quả hợp lệ là `[6, 6]` vì tổng của chúng là 12 và mỗi giá trị đều trong khoảng từ 1 đến 6.

#### Ví dụ 2:
**Input:**
```
rolls = [1, 5, 6]
mean = 3
n = 4
```
**Output:**
```
[2, 3, 2, 2]
```
**Giải thích:**
- Tổng của tất cả các lần tung phải bằng `3 * (4 + 3) = 21`.
- Tổng của các lần tung đã biết là `1 + 5 + 6 = 12`.
- Như vậy, tổng của 4 lần tung còn thiếu phải bằng `21 - 12 = 9`.
- Các kết quả hợp lệ là `[2, 3, 2, 2]`, vì tổng của chúng là 9.

#### Ví dụ 3:
**Input:**
```
rolls = [1, 2, 3, 4]
mean = 6
n = 4
```
**Output:**
```
[]
```
**Giải thích:**
- Tổng của tất cả các lần tung phải bằng `6 * (4 + 4) = 48`.
- Tổng của các lần tung đã biết là `1 + 2 + 3 + 4 = 10`.
- Tổng của 4 lần tung còn thiếu phải là `48 - 10 = 38`, nhưng điều này không khả thi vì mỗi kết quả tung xúc xắc phải nằm trong khoảng từ 1 đến 6, và 4 lần tung có tổng lớn nhất là `6 * 4 = 24`. Do đó, không thể có lời giải hợp lệ.

### # Cách giải bài toán:
1. Tính tổng của tất cả n + m lần tung theo công thức:

   $$
   total\_sum = mean \times (n + m)
   $$

2. Tính tổng của các lần tung đã biết:
   $$
   observed\_sum = \sum(rolls)
   $$
3. Tổng của n lần tung còn thiếu là:
   $$
   missing\_sum = total\_sum - observed\_sum
   $$
4. Kiểm tra điều kiện khả thi:
    - Nếu tổng của các lần tung bị thiếu không nằm trong khoảng hợp lệ
      $$
      n \leq missing\_sum \leq 6n`
      $$
    - Nếu không có kết quả hợp lệ và trả về mảng rỗng.

5. Nếu điều kiện khả thi, tìm các kết quả cho n lần tung bằng cách phân phối tổng thiếu vào các giá trị từ 1 đến 6 sao cho tổng đúng bằng **missing_sum**.




-------------------------------------------------------------
## Mô tả bài toán

- Bạn được cung cấp các quan sát của `n + m` lần tung xúc xắc 6 mặt, trong đó mỗi mặt được đánh số từ 1 đến 6. Tuy nhiên, `n` quan sát đã bị mất và bạn chỉ có `m` kết quả quan sát. May mắn thay, bạn biết **giá trị trung bình** của tất cả `n + m` lần tung.

- Bạn được cung cấp một mảng số nguyên `rolls` có độ dài `m`, trong đó `rolls[i]` là kết quả của lần tung xúc xắc thứ `i`. Ngoài ra, bạn còn được cung cấp hai số nguyên `mean` và `n`.

> Nhiệm vụ của bạn là trả về một mảng có độ dài `n` chứa các kết quả bị thiếu sao cho giá trị trung bình của tất cả `n + m` lần tung chính xác bằng **mean**. Nếu có nhiều câu trả lời hợp lệ, trả về một câu trả lời bất kỳ. Nếu không có câu trả lời hợp lệ, trả về mảng rỗng.

## Input
- `rolls`: Mảng số nguyên với `m` phần tử, đại diện cho các kết quả đã quan sát được.
- `mean`: Số nguyên đại diện cho giá trị trung bình của tất cả các lần tung.
- `n`: Số lần tung xúc xắc bị thiếu.

## Output
- Trả về một mảng gồm `n` số nguyên đại diện cho các kết quả bị thiếu sao cho trung bình của toàn bộ `n + m` lần tung đúng bằng **mean**. Nếu không có lời giải hợp lệ, trả về mảng rỗng.

## Ví dụ

### Ví dụ 1:

**Input:**
```text
rolls = [3, 2, 4, 3]
mean = 4
n = 2
```
**Output:**
```text
[6, 6]
```
**Giải thích:**
Tổng của tất cả các lần tung phải bằng `4 * (2 + 4) = 24`. Tổng của các lần tung đã biết là `3 + 2 + 4 + 3 = 12`. Vậy tổng của 2 lần tung còn thiếu là `24 - 12 = 12`. Các kết quả hợp lệ là `[6, 6]`.

### Ví dụ 2:
**Input:**
```text
rolls = [1, 5, 6]
mean = 3
n = 4
```
**Output:**
```text
[2, 3, 2, 2]
```
**Giải thích:**
Tổng của tất cả các lần tung là `3 * (4 + 3) = 21`. Tổng của các lần tung đã biết là `1 + 5 + 6 = 12`. Vậy tổng của 4 lần tung còn thiếu là `21 - 12 = 9`. Các kết quả hợp lệ là `[2, 3, 2, 2]`.

### Ví dụ 3:
**Input:**
```text
rolls = [1, 2, 3, 4]
mean = 6
n = 4
```
**Output:**
```text
[]
```
**Giải thích:**
Tổng của tất cả các lần tung phải là `6 * (4 + 4) = 48`. Tổng của các lần tung đã biết là `1 + 2 + 3 + 4 = 10`. Nhưng tổng của 4 lần tung còn thiếu là `38`, điều này không khả thi vì mỗi lần tung xúc xắc chỉ có giá trị từ 1 đến 6. Do đó, không có câu trả lời hợp lệ.

## Thuật toán

1. **Tính tổng cần thiết**:
    - Tổng của tất cả các lần tung là `mean * (n + m)`.

2. **Tính tổng của các lần tung đã biết**:
    - Tổng của mảng `rolls` là `observed_sum`.

3. **Tính tổng các giá trị bị thiếu**:
    - Tổng của các lần tung bị thiếu là `missing_sum = total_sum - observed_sum`.

4. **Kiểm tra điều kiện hợp lệ**:
    - Tổng của các lần tung bị thiếu phải nằm trong khoảng từ `n` đến `6 * n`. Nếu không, trả về mảng rỗng.

5. **Phân phối giá trị**:
    - Khởi tạo mảng kết quả với toàn bộ giá trị là 1.
    - Sau đó, phân phối dần các giá trị để đảm bảo tổng bằng `missing_sum`.

## Độ phức tạp

- **Độ phức tạp thời gian**: O(n + m), vì cần tính tổng của mảng `rolls` và phân phối giá trị cho mảng kết quả có độ dài `n`.
- **Độ phức tạp không gian**: O(n), sử dụng mảng kết quả để lưu trữ các giá trị bị thiếu.


--------------------

