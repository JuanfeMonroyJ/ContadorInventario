package inventory;

public class CD extends Product {
    private String artista;
    private int numeroDeCanciones;
    private String discografica;

    public CD(int numeroElemento, String nombreDelProducto, int numeroDeUnidadesEnExistencia, double precioDeCadaUnidad, boolean activo,
              String artista, int numeroDeCanciones, String discografica) {
        super(numeroElemento, nombreDelProducto, numeroDeUnidadesEnExistencia, precioDeCadaUnidad, activo);
        this.artista = artista;
        this.numeroDeCanciones = numeroDeCanciones;
        this.discografica = discografica;
    }

    // Getters y Setters
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getNumeroDeCanciones() {
        return numeroDeCanciones;
    }

    public void setNumeroDeCanciones(int numeroDeCanciones) {
        this.numeroDeCanciones = numeroDeCanciones;
    }

    public String getDiscografica() {
        return discografica;
    }

    public void setDiscografica(String discografica) {
        this.discografica = discografica;
    }

    @Override
    public String toString() {
        return "Item Number: " + getNumeroElemento() + "\n" +
                "Name: " + getNombreDelProducto() + "\n" +
                "Artist: " + artista + "\n" +
                "Songs on Album: " + numeroDeCanciones + "\n" +
                "Record label: " + discografica + "\n" +
                "Quantity in stock: " + getNumeroDeUnidadesEnExistencia() + "\n" +
                "Price: " + String.format("%.2f", getPrecioDeCadaUnidad()) + "\n" +
                "Stock Value: " + String.format("%.2f", calcularValorInventario()) + "\n" +
                "Product Status: " + (getActivo() ? "Active" : "Discontinued");
    }

}
