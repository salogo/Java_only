package cart;

import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);
    public static Customer customer = null;
    public static String prodid = "";
    public static int qty = 0;

    public static void main(String[] args) {
        int choice = 0;
        do {
            displayProducts();
            System.out.println();
            System.out.println("1. Add Product To Cart");
            System.out.println("2. View Cart Items");
            System.out.println("3. Delete Cart");
            System.out.println("4. Exit");
            System.out.println("Enter your choice");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    if(customer == null) {
                        readCustomerDetails();
                    }
                    displayProducts();
                    readProductDetails();
                    creaateCartOAndAddToCartList();

                    break;
                case 2:
                    displayCartItens();
                case 3:
                    deleteCart();
                    break;
                default:
                    System.out.println("Thank you!");
            }

        } while (choice < 4);
    }

    private static void creaateCartOAndAddToCartList() {
        Cart cart = new Cart(customer.getCustid(), prodid, ProductUtility.getProductPrice(prodid), qty);
        CartUtility.addProductToCart(cart);
    }

    private static void readProductDetails() {
        System.out.println("Enter the product id");
        prodid = scan.next();
        System.out.println("Enter qty");
        qty = scan.nextInt();
    }

    private static void readCustomerDetails() {
        customer = new Customer();
        String custid = "";
        String custname = "";
        String city = "";
        System.out.println("Enter cust id");
        custid = scan.next();
        System.out.println("Enter cust name");
        custname = scan.next();
        System.out.println("Enter city");
        city = scan.next();
    }

    private static void deleteCart() {
        Cart temp = null;
        for (Cart c: CartUtility.cartList) {
            //if (c.getCustid().equals(customer.getCustid())) {
            if (c.getCustid() == customer.getCustid()) {
                temp = c;
                break;
            }
        }
        CartUtility.cartList.remove(temp);
        System.out.println("Cart removed...");
    }

    private static void displayCartItens() {
        System.out.println("Prod name-Price-Qty-ItemTotal");
        for (Cart c: CartUtility.cartList) {
            int price = ProductUtility.getProductPrice(c.getCustid());
            String prodname = ProductUtility.getProductName(c.getProdid());
            System.out.println(prodname + "-" + c.getPrice() + "-" + (c.getQty() + c.getQty()*price));
        }
        System.out.println();

    }

    public static void addProductToCart() {
        System.out.println("Add product to cart");
    }

    public static void displayProducts() {
        System.out.printf("%-8s%-15s%-8s%-12s%-8s", "PROD-ID", "PRODUCT-NAME","PRICE","CATEGORY", "STOCK");
        System.out.println();
        System.out.println("---------------------------------------------");
        for(Product p: ProductUtility.productList) {
            System.out.printf("%-8s%-15s%-8s%-12s%-8d", p.getProdid(), p.getProdname(),"$"+ p.getPrice(),p.getCategory(), p.getQoh());
            System.out.println();
        }
    }
}















