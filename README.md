# 🛢️ QuanLyKhoNhot - Hệ thống quản lý kho nhớt

> Ứng dụng web Spring Boot đơn giản hỗ trợ quản lý thương hiệu (`brands`) và sản phẩm (`products`) trong kho nhớt xe máy/ô tô.

---

## 🚀 Tính năng chính

- ✅ CRUD **Thương hiệu (Brands)**:
  - Thêm, sửa, xoá, lấy danh sách brand.
- ✅ CRUD **Sản phẩm (Products)**:
  - Bao gồm: mã, tên, dung tích, loại nhớt, thương hiệu, tồn kho.
- 🔍 Tìm kiếm và lọc theo thương hiệu, loại sản phẩm, tồn kho.
- 🌐 RESTful API rõ ràng, dễ tích hợp frontend.
- 🔐 Phân quyền (nếu có).
- 🧾 Ghi log hành động (nếu có bật).
- 🇻🇳 Hỗ trợ đa ngôn ngữ (đang phát triển).

---

## 🧱 Công nghệ sử dụng

| Công nghệ          | Vai trò                                   | 
|--------------------|-------------------------------------------|
| **Java 21**        | Ngôn ngữ lập trình chính                  |
| **Spring Boot 3.4**| Framework backend                         |
| **MyBatis**        | ORM quản lý truy vấn DB                   |
| **MariaDB**        | Cơ sở dữ liệu chính                       |
| **Lombok**         | Rút gọn code model                        |
| **Postman**        | Test API nhanh gọn                        |

---

## 🏁 Khởi chạy project

```bash
# Clone project
git clone https://github.com/chez1s/QuanLyKhoNhot.git
cd QuanLyKhoNhot

# Cấu hình DB trong file: src/main/resources/application.yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ten_database
    username: root
    password: your_password

# Chạy ứng dụng
./mvnw spring-boot:run
````

---

## 🔗 Các endpoint tiêu biểu

### 📁 Brands

| Method | Endpoint              | Mô tả                     |
| ------ | --------------------- | ------------------------- |
| GET    | `/api/v1/brands`      | Lấy danh sách thương hiệu |
| GET    | `/api/v1/brands/{id}` | Lấy chi tiết thương hiệu  |
| POST   | `/api/v1/brands`      | Thêm thương hiệu mới      |
| PUT    | `/api/v1/brands/{id}` | Cập nhật thương hiệu      |
| DELETE | `/api/v1/brands/{id}` | Xoá thương hiệu           |

### 📦 Products

| Method | Endpoint                | Mô tả                  |
| ------ | ----------------------- | ---------------------- |
| GET    | `/api/v1/products`      | Lấy danh sách sản phẩm |
| GET    | `/api/v1/products/{id}` | Lấy chi tiết sản phẩm  |
| POST   | `/api/v1/products`      | Thêm sản phẩm mới      |
| PUT    | `/api/v1/products/{id}` | Cập nhật sản phẩm      |
| DELETE | `/api/v1/products/{id}` | Xoá sản phẩm           |

---

## 🧪 Mẫu JSON request

### ✅ Thêm brand

```json
{
  "name": "Liqui Moly"
}
```

### ✅ Thêm product

```json
{
  "code": "LM10W40",
  "name": "Liqui Moly 10W40",
  "capacity": "1L",
  "type": "Nhớt tổng hợp",
  "brandId": 1,
  "stock": 50
}
```

---

## 📌 Ghi chú

* Đảm bảo database đã tạo các bảng `brands` và `products`.
---

## 🧑‍💻 Tác giả

* 🧠 Development : [Bùi Đức Trí](https://github.com/chez1s) a.k.a **cz**
* 🧠 Co-dev      : [Nguyễn Quang Minh](https://github.com/NguyenMinh1301) a.k.a **mn**
* 🤝 Dự án open source

---

## ❤️ Kết

Dự án còn đơn giản nhưng đủ dùng cho quản lý kho nhớt ở các tiệm vừa và nhỏ. Mong được đóng góp thêm để phát triển thêm tính năng như:

* Báo cáo tồn kho theo ngày/tháng
* Nhập/xuất kho có lịch sử
* Kết nối thiết bị đọc mã vạch (nếu cần)

---
