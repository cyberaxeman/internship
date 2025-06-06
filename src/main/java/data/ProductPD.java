package data;

public class ProductPD {
    private int prodID;
    private double prodPrice;
    private String prodDescription;
    private String prodName;

    public ProductPD() {}

    public ProductPD(int prodID, String prodName, String prodDescription, double prodPrice) {
        setProdID(prodID);
        setProdPrice(prodPrice);
        setProdDescription(prodDescription);
        setProdName(prodName);
    }

    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        if (prodPrice < 0)
            throw new IllegalArgumentException("Product price must be non-negative.");
        this.prodPrice = prodPrice;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public static void addProduct(ProductPD product) throws DuplicateException {
        ProductDA.addProduct(product);
    }

    public static String searchProd(int id) throws NotFoundException {
        return ProductDA.searchProd(id);
    }

    public static void removeProd(int id) throws NotFoundException {
        ProductDA.removeProd(id);
    }

    public static void listProd() {
        ProductDA.listProd();
    }

    @Override
    public String toString() {
        return "ProductPD{" +
                "prodID=" + prodID +
                ", prodPrice=" + prodPrice +
                ", prodDescription='" + prodDescription + '\'' +
                ", prodName='" + prodName + '\'' +
                '}';
    }
}
