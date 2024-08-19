package inventory;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ProductTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxSize, menuChoice;

        maxSize = getNumProducts(in);
        if (maxSize == 0) {
            System.out.println("No products required!");
        } else {
            Product[] products = new Product[maxSize];
            addToInventory(products, in);

            do {
                menuChoice = getMenuOption(in);
                executeMenuChoice(menuChoice, products, in);
            } while (menuChoice != 0);
        }

        in.close();
    }

    public static int getMenuOption(Scanner in) {
        int menuOption = -1;
        while (menuOption < 0 || menuOption > 4) {
            System.out.println("1. View Inventory");
            System.out.println("2. Add Stock");
            System.out.println("3. Deduct Stock");
            System.out.println("4. Discontinue Product");
            System.out.println("0. Exit");
            System.out.print("Please enter a menu option: ");

            try {
                menuOption = in.nextInt();
                if (menuOption < 0 || menuOption > 4) {
                    System.out.println("Opción no válida, por favor ingrese un número entre 0 y 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tipo de datos incorrecto introducido.");
                in.next();
            }
        }
        return menuOption;
    }

    public static void addCDToInventory(Product[] products, Scanner in, int i) {
        String tempName;
        String tempArtist;
        String tempRecordLabel;
        int tempNumberOfSongs;
        int tempQty;
        double tempPrice;
        int tempItemNumber;
        boolean tempProductStatus;

        System.out.println("Introduzca los detalles del CD " + (i + 1) + ":");

        System.out.print("Nombre del CD: ");
        tempName = in.nextLine();

        System.out.print("Nombre del artista: ");
        tempArtist = in.nextLine();

        System.out.print("Nombre de la discográfica: ");
        tempRecordLabel = in.nextLine();

        System.out.print("Número de canciones: ");
        tempNumberOfSongs = in.nextInt();

        System.out.print("Cantidad del CD: ");
        tempQty = in.nextInt();

        System.out.print("Precio del CD: ");
        tempPrice = in.nextDouble();

        System.out.print("Número del CD: ");
        tempItemNumber = in.nextInt();

        System.out.print("Estado del CD (true para disponible, false para no disponible): ");
        tempProductStatus = in.nextBoolean();

        products[i] = new CD(tempItemNumber, tempName, tempQty, tempPrice, tempProductStatus, tempArtist, tempNumberOfSongs, tempRecordLabel);
    }

    public static void addDVDToInventory(Product[] products, Scanner in, int i) {
        String tempName;
        int tempDuration;
        String tempAgeRating;
        String tempFilmStudio;
        int tempQty;
        double tempPrice;
        int tempItemNumber;
        boolean tempProductStatus;

        System.out.println("Introduzca los detalles del DVD " + (i + 1) + ":");

        System.out.print("Nombre del DVD: ");
        tempName = in.nextLine();

        System.out.print("Estudio cinematográfico: ");
        tempFilmStudio = in.nextLine();

        System.out.print("Clasificación de edad: ");
        tempAgeRating = in.nextLine();

        System.out.print("Duración en minutos: ");
        tempDuration = in.nextInt();

        System.out.print("Cantidad del DVD: ");
        tempQty = in.nextInt();

        System.out.print("Precio del DVD: ");
        tempPrice = in.nextDouble();

        System.out.print("Número del DVD: ");
        tempItemNumber = in.nextInt();

        System.out.print("Estado del DVD (true para disponible, false para no disponible): ");
        tempProductStatus = in.nextBoolean();

        products[i] = new DVD(tempItemNumber, tempName, tempQty, tempPrice, tempProductStatus, tempDuration, tempAgeRating, tempFilmStudio);
    }

    public static void addToInventory(Product[] products, Scanner in) {
        int productType;
        for (int i = 0; i < products.length; i++) {
            System.out.println("Seleccione el tipo de producto:");
            System.out.println("1: CD");
            System.out.println("2: DVD");

            while (true) {
                System.out.print("Por favor, ingrese el tipo de producto (1 o 2): ");
                try {
                    productType = in.nextInt();
                    if (productType == 1 || productType == 2) {
                        break;
                    } else {
                        System.out.println("Opción no válida, por favor ingrese 1 o 2.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Tipo de datos incorrecto introducido.");
                    in.next();
                }
            }
            in.nextLine(); // consume el salto de línea

            if (productType == 1) {
                addCDToInventory(products, in, i);
            } else if (productType == 2) {
                addDVDToInventory(products, in, i);
            }
        }
    }

    public static void executeMenuChoice(int menuChoice, Product[] products, Scanner in) {
        int tempItemNumber;
        int tempQty;

        switch (menuChoice) {
            case 1: // View Inventory
                for (Product product : products) {
                    if (product != null) {
                        System.out.println(product);
                    }
                }
                break;

            case 2: // Add Stock
                System.out.print("Introduzca el número de producto para agregar stock: ");
                tempItemNumber = in.nextInt();
                System.out.print("Introduzca la cantidad de stock a agregar: ");
                tempQty = in.nextInt();

                for (Product product : products) {
                    if (product != null && product.getNumeroElemento() == tempItemNumber) {
                        product.setNumeroDeUnidadesEnExistencia(product.getNumeroDeUnidadesEnExistencia() + tempQty);
                        System.out.println("Stock actualizado.");
                        break;
                    }
                }
                break;

            case 3: // Deduct Stock
                System.out.print("Introduzca el número de producto para deducir stock: ");
                tempItemNumber = in.nextInt();
                System.out.print("Introduzca la cantidad de stock a deducir: ");
                tempQty = in.nextInt();

                for (Product product : products) {
                    if (product != null && product.getNumeroElemento() == tempItemNumber) {
                        int currentStock = product.getNumeroDeUnidadesEnExistencia();
                        if (tempQty <= currentStock) {
                            product.setNumeroDeUnidadesEnExistencia(currentStock - tempQty);
                            System.out.println("Stock actualizado.");
                        } else {
                            System.out.println("No hay suficiente stock para deducir.");
                        }
                        break;
                    }
                }
                break;

            case 4: // Discontinue Product
                System.out.print("Introduzca el número de producto para discontinuar: ");
                tempItemNumber = in.nextInt();

                for (Product product : products) {
                    if (product != null && product.getNumeroElemento() == tempItemNumber) {
                        product.setActivo(false);
                        System.out.println("Producto discontinuado.");
                        break;
                    }
                }
                break;

            case 0: // Exit
                System.out.println("Saliendo...");
                break;
        }
    }

    public static int getNumProducts(Scanner in) {
        int maxSize = 0;

        while (maxSize <= 0) {
            System.out.print("¿Cuántos productos desea ingresar? ");
            try {
                maxSize = in.nextInt();
                if (maxSize <= 0) {
                    System.out.println("El número de productos debe ser mayor que 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Tipo de datos incorrecto introducido.");
                in.next();
            }
        }

        return maxSize;
    }
}