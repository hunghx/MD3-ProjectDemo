package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.ProductController;
import rikkei.academy.controller.UserController;
import rikkei.academy.model.CartItem;
import rikkei.academy.model.Product;
import rikkei.academy.model.RoleName;
import rikkei.academy.model.User;

import java.util.List;


public class UserView {
    ProductController productController = new ProductController();
    UserController userController = new UserController();
    List<User> userList = userController.findAll();

    public User formLogin() {
        System.out.println("Enter username");
        String userName = Config.scanner().nextLine();
        System.out.println("Enter password");
        String password = Config.scanner().nextLine();
        User user = userController.login(userName, password);
        return user;
    }

    public void formRegister() {
        User newUser = new User();
        if (userList.size() == 0) {
            newUser.setId(1);
        } else {
            newUser.setId(userList.get(userList.size() - 1).getId() + 1);
        }
        System.out.println("Enter username");
        while (true) {
            newUser.setUsername(Config.scanner().nextLine());
            if (userController.checkUsernameExists(newUser.getUsername())) {
                // tồn tại
                System.err.println("Username is exist");
            } else {
                // chưa tồn tại
                break;
            }
        }
        System.out.println("Enter password");
        newUser.setPassword(Config.scanner().nextLine());
        System.out.println("Enter full name");
        newUser.setFullName(Config.scanner().nextLine());
        userController.create(newUser);
        System.out.println("Create success");
    }

    public void showListUser() {
        for (User u : userList) {
            System.out.println(u);
        }
    }

    public void changeUserStatus() {
        System.out.println("Enter id");
        int id = Config.scanner().nextInt();
        User user = userController.findById(id);
        if (user == null) {
            System.err.println("Id not found");
        } else {
            if (user.getRole() == RoleName.CUSTOMER) {
                userController.changeStatus(id);
                System.out.println("Change status success");
            } else {
                System.err.println("You can't change Admin's status");
            }
        }
    }
    public void showListCart(User user){
        for (CartItem cartItem:user.getCart()){
            System.out.println(cartItem);
        }
    }
    public void addToCart(User user){
        List<CartItem> cart = user.getCart();
        System.out.println("enter product id");
        int id = Config.scanner().nextInt();
        if(productController.searchProductById(id) == null){
            System.err.println("id not found");
        }else {
            Product product =productController.searchProductById(id);
            System.out.println("enter quantity");
            int quantity = Config.scanner().nextInt();
            int idNew = (cart.size()==0)?1:(cart.get(cart.size()-1).getId()+1);
            CartItem newCartItem = new CartItem(idNew,product,quantity);
            if (cart.size()==0){
                // giò hàng trống
                cart.add(newCartItem);
            }else {
                if (checkCartItemExists(cart,id)){
//                    sản phẩm trùng
                    for (CartItem item: cart) {
                        if (item.getProduct().getProductId()==id){
                            item.setQuantity(item.getQuantity()+quantity);
                            break;
                        }
                    }
                }else {
//                    sản phâm ko bị trùng
                    cart.add(newCartItem);
                }

            }
            System.out.println("add to cart success");
            user.setCart(cart);
            userController.update(user);
        }
    }
    public boolean checkCartItemExists(List<CartItem> cart, int id){
        for (CartItem item:cart) {
            if (item.getProduct().getProductId()==id){
                return true;
            }
        }
        return false;
    }
    public void changeQuantityItem(User user){
        List<CartItem> cart = user.getCart();
        System.out.println("Enter cartItem id");
        int idCartItem = Config.scanner().nextInt();
        if (checkCartItemExits(cart,idCartItem)){
            for (CartItem item : cart) {
                if (item.getId()==idCartItem){
                    System.out.println("Enter new quantity , old quantity is "+item.getQuantity());
                    item.setQuantity(Config.scanner().nextInt());
                    user.setCart(cart);
                    userController.update(user);
                    System.out.println("Update success");
                    break;
                }
            }
        }else {
            System.err.println("id not found in cart");
        }
//        boolean check = false;
//        for (CartItem item : cart) {
//            if (item.getId()==idCartItem) {
//                // tồn tại
//                check =true;
//                System.out.println("Enter new quantity , old quantity is "+item.getQuantity());
//                item.setQuantity(Config.scanner().nextInt());
//                user.setCart(cart);
//                userController.update(user);
//                System.out.println("Update success");
//                break;
//            }
//        }
//        if (!check) {
//            System.err.println("id not found in cart");
//        }
    }
    public void deleteCartItem(User user){
        List<CartItem> cart = user.getCart();
        System.out.println("Enter cartItem id");
        int idCartItem = Config.scanner().nextInt();
        if (checkCartItemExits(cart,idCartItem)) {
            for (CartItem item : cart) {
                if (item.getId()==idCartItem){
                    // xoá nó
                    cart.remove(item);
                    user.setCart(cart);
                    userController.update(user);
                    break;
                }
            }
        }else {
            System.err.println("id not found in cart");
        }
    }
    public boolean checkCartItemExits(List<CartItem> cart,int idCartItem) {
        for (CartItem item : cart) {
            if (item.getId()==idCartItem){
                return true;
            }
        }
        return false;
    }
}
