package cart;

import java.util.ArrayList;
import java.util.List;

public class CartUtility {
    public static List<Cart> cartList = new ArrayList<>();

    public static void addProductToCart(Cart cart) {
        int index  = -1;
        Cart temp = null;
        for (Cart c: cartList) {
            index++;
            if (c.getCustid().equals(cart.getCustid()) && c.getProdid().equals(cart.getProdid()) ) {//
                temp = c;
                break;
            }
        }

        if (temp == null) {
            cartList.add(cart);
            System.out.println("Cart Added...");
        } else {
            temp.setQty(temp.getQty() + cart.getQty());
            cartList.set(index, temp);
            System.out.println("Cart updeted...");
        }

        Product p = ProductUtility.findProduct(cart.getProdid());
        p.setQoh( p.getQoh() - cart.getQty() );










    }
}
