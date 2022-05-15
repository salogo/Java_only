package cart;

import java.util.Objects;

public class Cart {
    private String custid;
    private String prodid;
    private int price;
    private int qty;

    public Cart() {
        super();
    }

    public Cart(String custid, String prodid, int price, int qty) {
        this.custid = custid;
        this.prodid = prodid;
        this.price = price;
        this.qty = qty;
    }

    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    }

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return price == cart.price && qty == cart.qty && Objects.equals(custid, cart.custid) && Objects.equals(prodid, cart.prodid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(custid, prodid, price, qty);
    }
}
