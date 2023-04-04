package rikkei.academy.view.product;

import rikkei.academy.config.Config;

public class Navbar {
    public Navbar() {
        // xây menu
        System.out.println("*************Product Manager**************");
        System.out.println("1. Show all products");
        System.out.println("2. Create new product");
        System.out.println("3. Update product by Id");
        System.out.println("4. Delete product by Id");
        System.out.println("5. Search products by name");
        System.out.println("6. Back");
        System.out.println("Enter your choice");
        int choice = Config.scanner().nextInt();

        switch (choice) {
            case 1:
                // hiển thị tất cả sản phẩm
                new ProductView().showListProduct();
                new Navbar();
                break;
            case 2:
                // thêm mới 1 hoặc nhiều sp
                new ProductView().formCreateProduct();
                new Navbar();

                break;
            case 3:
                // sửa thông tin sản phẩm theo id
                new ProductView().updateProducts();
                new Navbar();
                break;
            case 4:
                // xoá sản phẩm theo id
                new ProductView().deleteProductById();
                new Navbar();
                break;
            case 5:
                // tìm kiếm sản phẩm theo tên
                new ProductView().searchProductsByName();
                new Navbar();
                break;
            case 6:
                System.out.println("Back");
                break;
            default:
                new Navbar();
                break;
        }

    }

    public static void main(String[] args) {
        new Navbar();
    }
}
