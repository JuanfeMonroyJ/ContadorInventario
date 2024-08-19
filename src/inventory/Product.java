package inventory;

public class Product {

    // Instance field declarations
    private int numeroElemento;
    private String nombreDelProducto;
    private int numeroDeUnidadesEnExistencia;
    private double precioDeCadaUnidad;
    private boolean activo;

    // Constructor sin parametros
    public Product() {
        this.numeroElemento = 1;
        this.nombreDelProducto = "Greatest Hits";
        this.numeroDeUnidadesEnExistencia = 25;
        this.precioDeCadaUnidad = 9.99;
        this.activo = true;
    }

    // Constructor sobrecargado con parametros
    public Product(int number, String name, int qty, double price, boolean ProductStatus) {
        this.numeroElemento = number;
        this.nombreDelProducto = name;
        this.numeroDeUnidadesEnExistencia = qty;
        this.precioDeCadaUnidad = price;
        this.activo = ProductStatus;
    }

    // Método para calcular el valor del inventario
    public double calcularValorInventario() {
        return (precioDeCadaUnidad * numeroDeUnidadesEnExistencia);
    }

    // Getter y Setter

    // get and set activo
    // GET
    public boolean getActivo() {
        return activo;
    }

    // SET
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // get and set numeroElemento
    // GET
    public int getNumeroElemento() {
        return numeroElemento;
    }

    // SET
    public void setNumeroElemento(int numeroElemento) {
        this.numeroElemento = numeroElemento;
    }

    // get and set nombreDelProducto
    // GET
    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    // SET
    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;
    }

    // get and set numeroDeUnidadesEnExistencia
    // GET
    public int getNumeroDeUnidadesEnExistencia() {
        return numeroDeUnidadesEnExistencia;
    }

    // SET
    public void setNumeroDeUnidadesEnExistencia(int numeroDeUnidadesEnExistencia) {
        this.numeroDeUnidadesEnExistencia = numeroDeUnidadesEnExistencia;
    }

    // get and set precioDeCadaUnidad
    // GET
    public double getPrecioDeCadaUnidad() {
        return precioDeCadaUnidad;
    }

    // SET
    public void setPrecioDeCadaUnidad(double precioDeCadaUnidad) {
        this.precioDeCadaUnidad = precioDeCadaUnidad;
    }

    // Método para añadir unidades al inventario
    public void addToInventory(int cantidad) {
        if (cantidad > 0) {
            this.numeroDeUnidadesEnExistencia += cantidad;
        } else {
            System.out.println("La cantidad debe ser positiva.");
        }
    }

    // Método para deducir unidades del inventario
    public void deductFromInventory(int cantidad) {
        if (cantidad > 0) {
            if (this.numeroDeUnidadesEnExistencia >= cantidad) {
                this.numeroDeUnidadesEnExistencia -= cantidad;
            } else {
                System.out.println("No hay suficientes unidades en existencia para deducir.");
            }
        } else {
            System.out.println("La cantidad debe ser positiva.");
        }
    }

    // Metodo toString
    public String toString() {
        return "Item del Producto: " + numeroElemento + "\n" + "Name: " + nombreDelProducto + "\n"
                + "Unidades Existentes: " + numeroDeUnidadesEnExistencia + "\n" + "Precio Unidad: "
                + String.format("%.2f", precioDeCadaUnidad) + "\n" + "Valor de Inventario: "
                + String.format("%.2f", calcularValorInventario()) + "\n" + "Estado del producto: "
                + (activo ? "Activo" : "Descatalogado");
    }

}