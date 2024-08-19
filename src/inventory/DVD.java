package inventory;

public class DVD extends Product {
    private int duracion; // duración en minutos
    private String clasificacionEdad;
    private String estudioCinematografico;

    public DVD(int numeroElemento, String nombreDelProducto, int numeroDeUnidadesEnExistencia, double precioDeCadaUnidad, boolean activo,
               int duracion, String clasificacionEdad, String estudioCinematografico) {
        super(numeroElemento, nombreDelProducto, numeroDeUnidadesEnExistencia, precioDeCadaUnidad, activo);
        this.duracion = duracion;
        this.clasificacionEdad = clasificacionEdad;
        this.estudioCinematografico = estudioCinematografico;
    }

    // Getters y Setters
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(String clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public String getEstudioCinematografico() {
        return estudioCinematografico;
    }

    public void setEstudioCinematografico(String estudioCinematografico) {
        this.estudioCinematografico = estudioCinematografico;
    }

    // Sobrescribir el método calcularValorInventario
    @Override
    public double calcularValorInventario() {
        return super.calcularValorInventario() * 1.05; // Añadir una tasa de devolución del 5%
    }

    @Override
    public String toString() {
        return "Item Number: " + getNumeroElemento() + "\n" +
                "Name: " + getNombreDelProducto() + "\n" +
                "Movie Length: " + duracion + "\n" +
                "Age Rating: " + clasificacionEdad + "\n" +
                "Film Studio: " + estudioCinematografico + "\n" +
                "Quantity in stock: " + getNumeroDeUnidadesEnExistencia() + "\n" +
                "Price: " + String.format("%.2f", getPrecioDeCadaUnidad()) + "\n" +
                "Stock Value: " + String.format("%.2f", calcularValorInventario()) + "\n" +
                "Product Status: " + (getActivo() ? "Active" : "Discontinued");
    }

}

