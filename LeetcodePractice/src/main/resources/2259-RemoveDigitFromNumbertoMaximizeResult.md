# 2259. Remove Digit From Number to Maximize Result

### Áp dụng lại từng bước chính xác:

#### 1. **Khởi tạo biến `maxResult`:**

```java
String maxResult = "";
```
- **Thực tế:** Biến này được khởi tạo là một chuỗi rỗng. Nó sẽ lưu chuỗi lớn nhất tìm được sau khi xóa ký tự.

#### 2. **Duyệt qua từng ký tự của chuỗi (`for`):**

Vòng lặp này sẽ duyệt qua từng ký tự trong chuỗi **number**. Chúng ta sẽ theo dõi từng bước với các tính toán chi tiết.

##### Bước 1: **i = 0**, **number.charAt(0) = '1'**

```java
if (number.charAt(0) == digit) { // Ký tự tại vị trí 0 là '1', không phải là ký tự cần xóa
    // Không làm gì
}
```
- **Thực tế:** Ký tự tại vị trí `0` không phải là ký tự `'7'`, không thực hiện thay đổi.

##### Bước 2: **i = 1**, **number.charAt(1) = '7'**

```java
if (number.charAt(1) == digit) { // Ký tự tại vị trí 1 là '7', và digit cũng là '7'
    String newNumber = number.substring(0, 1) + number.substring(2);
    // newNumber = "1" + "4975" = "14975"
    if (newNumber.compareTo(maxResult) > 0) {
        maxResult = newNumber;
        // maxResult = "14975" vì "14975" lớn hơn ""
    }
}
```
- **Thực tế:** Ký tự tại vị trí `1` là `'7'`, chúng ta xóa ký tự này và tạo chuỗi mới `"14975"`.
    - **`newNumber`:** `"14975"`
    - **`maxResult`:** `"14975"` (cập nhật vì `"14975"` lớn hơn chuỗi rỗng ban đầu)

##### Bước 3: **i = 2**, **number.charAt(2) = '4'**

```java
if (number.charAt(2) == digit) { // Ký tự tại vị trí 2 là '4', không phải là ký tự cần xóa
    // Không làm gì
}
```
- **Thực tế:** Ký tự tại vị trí `2` không phải là ký tự `'7'`, không thực hiện thay đổi.

##### Bước 4: **i = 3**, **number.charAt(3) = '9'**

```java
if (number.charAt(3) == digit) { // Ký tự tại vị trí 3 là '9', không phải là ký tự cần xóa
    // Không làm gì
}
```
- **Thực tế:** Ký tự tại vị trí `3` không phải là ký tự `'7'`, không thực hiện thay đổi.

##### Bước 5: **i = 4**, **number.charAt(4) = '7'**

```java
if (number.charAt(4) == digit) { // Ký tự tại vị trí 4 là '7', và digit cũng là '7'
    String newNumber = number.substring(0, 4) + number.substring(5);
    // newNumber = "174" + "75" = "17495"
    if (newNumber.compareTo(maxResult) > 0) {
        maxResult = newNumber;
        // maxResult = "17495" vì "17495" lớn hơn "14975"
    }
}
```
- **Thực tế:** Ký tự tại vị trí `4` là `'7'`, chúng ta xóa ký tự này và tạo chuỗi mới `"17495"`.
    - **`newNumber`:** `"17495"`
    - **`maxResult`:** `"17495"` (cập nhật vì `"17495"` lớn hơn `"14975"`)

##### Bước 6: **i = 5**, **number.charAt(5) = '5'**

```java
if (number.charAt(5) == digit) { // Ký tự tại vị trí 5 không phải là '7'
    // Không làm gì
}
```
- **Thực tế:** Ký tự tại vị trí `5` không phải là ký tự `'7'`, không thực hiện thay đổi.

#### 3. **Trả về kết quả:**

```java
return maxResult;
```
- **Thực tế:** Kết quả cuối cùng của `maxResult` là `"17495"`, vì đây là chuỗi lớn nhất có thể đạt được sau khi xóa ký tự `'7'`.

### Kết luận:

Kết quả của chương trình là **"17495"**, có nghĩa là chuỗi lớn nhất có thể đạt được sau khi xóa một ký tự `'7'` từ chuỗi gốc `"174975"` là **"17495"**.

- **Ví dụ thực tế:** Khi xóa ký tự `'7'` tại vị trí `1`, chúng ta được chuỗi `"14975"`. Khi xóa ký tự `'7'` tại vị trí `4`, chúng ta được chuỗi `"17495"`, và đây là chuỗi lớn nhất trong tất cả các kết quả có thể.