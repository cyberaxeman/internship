package data;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductDA {

    private static ArrayList<ProductPD> arProduct = new ArrayList<>();

    public static void addProduct(ProductPD product) throws DuplicateException {
        for (ProductPD p : arProduct) {
            if (p.getProdID() == product.getProdID()) {
                throw new DuplicateException("The product already exists.");
            }
        }
        arProduct.add(product);
    }

    public static String searchProd(int id) throws NotFoundException {
        for (ProductPD product : arProduct) {
            if (product.getProdID() == id) {
                return product.toString();
            }
        }
        throw new NotFoundException("Product with ID " + id + " not found.");
    }

    public static void removeProd(int id) throws NotFoundException {
        Iterator<ProductPD> iterator = arProduct.iterator();
        while (iterator.hasNext()) {
            ProductPD product = iterator.next();
            if (product.getProdID() == id) {
                iterator.remove();
                return;
            }
        }
        throw new NotFoundException("Product with ID " + id + " not found.");
    }

    public static void listProd() {
        if (arProduct.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (ProductPD product : arProduct) {
                System.out.println(product);
            }
        }
    }

}
