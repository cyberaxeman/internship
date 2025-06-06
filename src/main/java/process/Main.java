package process;

import data.DuplicateException;
import data.NotFoundException;
import data.ProductPD;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean login = true;
        Scanner in = new Scanner(System.in);
        int selectinOne;

        while (login) {
            System.out.println("\n\t\tWelcome to Inventory System\n");
            System.out.println("1. Add Product\t2. Delete Product");
            System.out.println("3. Search Product by ID\t4. List Products");
            System.out.println("5. Exit");
            System.out.print("Select your option: ");
            selectinOne = in.nextInt();
            in.nextLine();

            switch (selectinOne) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int prodID = in.nextInt();
                    in.nextLine();

                    System.out.print("Enter Product Name: ");
                    String prodName = in.nextLine();

                    System.out.print("Enter Product Description: ");
                    String prodDescription = in.nextLine();

                    System.out.print("Enter Product Price: ");
                    double prodPrice = in.nextDouble();

                    ProductPD objProd = new ProductPD(prodID, prodName, prodDescription, prodPrice);

                    try {
                        ProductPD.addProduct(objProd);
                        System.out.println("Product added successfully.");
                    } catch (DuplicateException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter Product ID to delete: ");
                    int deleteProd = in.nextInt();
                    try {
                        ProductPD.removeProd(deleteProd);
                        System.out.println("Product deleted successfully.");
                    } catch (NotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to search: ");
                    int searchedProd = in.nextInt();
                    try {
                        String result = ProductPD.searchProd(searchedProd);
                        System.out.println("Product Found: " + result);
                    } catch (NotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    ProductPD.listProd();
                    break;

                case 5:
                    System.out.println("Thank you for using the Inventory System.");
                    login = false;
                    break;

                default:
                    System.out.println("Invalid option. Please select between 1 and 5.");
            }
        }

        in.close();
    }
}
