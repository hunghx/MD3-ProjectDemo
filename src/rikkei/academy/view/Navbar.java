package rikkei.academy.view;

import rikkei.academy.config.Config;



public class Navbar {
    public Navbar() {
        System.out.println("******************* CATEGORY MANAGE *******************");
        System.out.println("1. Show List Category");
        System.out.println("2. Create Category");
        System.out.println("3. Update Category");
        int chooseMenu = Config.scanner().nextInt();
        switch (chooseMenu) {
            case 1:
                new CategoryView().showFormCategoryList();
                break;
            case 2:
                new CategoryView().formCreateCategory();
                break;
            case 3:
                new CategoryView().formUpdateCategory();
                break;
        }
    }

    public static void main(String[] args) {
        new Navbar();

    }
}