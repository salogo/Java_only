package cart;

import java.util.Objects;

public class Product {
    private String prodid;
    private String prodname;
    private String category;
    private int price;
    private int qoh;
    public Product(String prodid, String prodname, String category, int price, int qoh) {
        super();
        this.prodid = prodid;
        this.prodname = prodname;
        this.category = category;
        this.price = price;
        this.qoh = qoh;
    }

    public String getProdid() {
        return prodid;
    }

    public void setProdid(String prodid) {
        this.prodid = prodid;
    }

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getQoh() {
        return qoh;
    }
    public void setQoh(int qoh) {
        this.qoh = qoh;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && qoh == product.qoh && Objects.equals(prodid, product.prodid) && Objects.equals(prodname, product.prodname) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodid, prodname, category, price, qoh);
    }
}
