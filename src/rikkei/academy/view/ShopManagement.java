package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.model.RoleName;
import rikkei.academy.model.User;
import rikkei.academy.service.UserServiceIMPL;

public class ShopManagement {
    public static User userLogin = null;

    public static void main(String[] args) {

        while (true) {
            Navbar.navbarHomePage();
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Goodbye babie!!!");
                    break;
                default:
                    System.err.println("please enter a number from 1 to 3, ok?");
            }
            if (choice == 3) {
                break;
            }
        }

    }

    public static void login() {
        User user = new UserView().formLogin();
        System.out.println("Login success");
        if (user == null) {
            System.err.println("Incorrect username or password");
            System.out.println("----------Login---------");
            System.out.println("1. Try Again");
            System.out.println("2. You forgot password?");
            System.out.println("3. You don't have account, register now");
            System.out.println("------------------------");
            System.out.println("Please enter choice");
            int choice = Config.scanner().nextInt();
            if (choice == 2) {
                // quên mật khẩu
               login();
            } else if (choice == 3) {
                // đăng kí
                register();
            } else {
                // đăng nhập lại
                login();
            }
        } else {
            userLogin = user;

            if (userLogin.getRole() == RoleName.ADMIN) {
                // chuyển hướng sang trang admin
                adminView();
            } else if (user.getRole() == RoleName.CUSTOMER) {
                // chuyển hướng sang trang người dùng
                customerView();
            }
        }
    }

    public static void register() {
        new UserView().formRegister();
    }

    public static void adminView() {
        while (true) {
            Navbar.navbarAdmin();
            System.out.println("Enter choice");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    categoryManagement();
                    break;
                case 2:
                    productManagement();
                    break;
                case 3:
                    userManagement();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.err.println("please enter a number from 1 to 6, ok?");
            }
            if (choice == 6) {
                break;
            }
        }

    }

    // quản lí danh mục
    public static void categoryManagement() {
        while (true) {
            Navbar.navbarCategoryManager();
            System.out.println("Enter choice");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new CategoryView().showFormCategoryList();
                    break;
                case 2:
                    new CategoryView().formCreateCategory();
                    break;
                case 3:
                    new CategoryView().formUpdateCategory();
                    break;
                case 4:

                    break;
                default:
                    System.err.println("please enter a number from 1 to 4, ok?");
            }
            if (choice == 4) {
                break;
            }
        }

    }

    // quản lí sản phẩm
    public static void productManagement() {
        while (true) {
            Navbar.navbarProductManager();
            System.out.println("Enter choice");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new ProductView().showListProduct();
                    break;
                case 2:
                    new ProductView().formCreateProduct();
                    break;
                case 3:
                    new ProductView().updateProducts();
                    break;
                case 4:
                    new ProductView().deleteProductById();
                    break;
                case 5:
                    new ProductView().searchProductsByName();
                    break;
                case 6:
                    break;
                default:
                    System.err.println("please enter a number from 1 to 6, ok?");
            }
            if (choice == 6) {
                break;
            }
        }

    }

    //    quản lí người dùng
    public static void userManagement() {
        while (true) {
            Navbar.navbarUserManager();
            System.out.println("Enter choice");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new UserView().showListUser();
                    break;
                case 2:
                    new UserView().changeUserStatus();
                    break;
                case 3:
                    break;
                default:
                    System.err.println("please enter a number from 1 to 3, ok?");
            }
            if (choice == 3) {
                break;
            }
        }
    }

    public static void customerView() {
        while (true) {
            Navbar.navbarCustomer();
            System.out.println("Enter choice");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new ProductView().showListProduct();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    cartView();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.err.println("please enter a number from 1 to 6, ok?");
            }
            if (choice == 6) {
                break;
            }
        }


    }

    public static void cartView() {
        while (true) {
            Navbar.navbarCart();
            System.out.println("Enter choice");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    new UserView().showListCart(userLogin);
                    break;
                case 2:
                    new UserView().addToCart(userLogin);
                    break;
                case 3:
                    new UserView().changeQuantityItem(userLogin);
                    break;
                case 4:
                    new UserView().deleteCartItem(userLogin);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.err.println("please enter a number from 1 to 6, ok?");
            }
            if (choice == 6) {
                break;
            }
        }
    }

}
