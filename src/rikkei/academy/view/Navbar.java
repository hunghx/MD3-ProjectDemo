package rikkei.academy.view;




public class Navbar {
    public static void navbarHomePage(){
        System.out.println("*********************** H SỜ TO***********************");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.println("------------------------------------------------------");
    }
    public static void navbarAdmin(){
        System.out.println("*********************** Admin ***********************");
        System.out.println("1. Category Management");
        System.out.println("2. Product Management");
        System.out.println("3. User Management");
        System.out.println("4. Order Management");
        System.out.println("5. FeedBack");
        System.out.println("6. Exit");
        System.out.println("------------------------------------------------------");
    }

    // Admin
    public static void navbarCategoryManager() {
        System.out.println("*********************** Admin ***********************");
        System.out.println("1. Show list category");
        System.out.println("2. Create new category");
        System.out.println("3. Update category");
        System.out.println("4. Exit");
        System.out.println("------------------------------------------------------");
    }
    public static void navbarProductManager() {
        System.out.println("*********************** Admin ***********************");
        System.out.println("1. Show all product");
        System.out.println("2. Create new product");
        System.out.println("3. Update product");
        System.out.println("4. Delete product");
        System.out.println("5. Search product by name");
        System.out.println("6. Exit");
        System.out.println("------------------------------------------------------");
    }
    public static void navbarUserManager() {
        System.out.println("*********************** Admin ***********************");
        System.out.println("1. Show list user");
        System.out.println("2. Change status");
        System.out.println("3. Exit");
        System.out.println("------------------------------------------------------");
    }
    // Admin
    public static  void navbarCustomer(){
        System.out.println("*********************** H SỜ TO ***********************");
        System.out.println("1. Show al products");
        System.out.println("2. Search product by category's name");
        System.out.println("3. Search product by product's name");
        System.out.println("4. Cart");
        System.out.println("5. Order");
        System.out.println("6. Log out");
        System.out.println("------------------------------------------------------");
    }
    // Customer
    public  static  void navbarCart(){
        System.out.println("*********************** H SỜ TO ***********************");
        System.out.println("1. Show may cart");
        System.out.println("2. Add product to cart");
        System.out.println("3. Change quantity");
        System.out.println("4. Delete item");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
        System.out.println("------------------------------------------------------");
    }
    // Customer

}