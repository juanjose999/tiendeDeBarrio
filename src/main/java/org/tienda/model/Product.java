package org.tienda.model;

public class Product {
    private static int countProduct = 1;
    private int idProduct;
    private String name;
    private int stock;
    private String description;
    private String category;
    private String tags;
    private float price;

    public Product(String name, int stock, String description, String category, String tags, float price) {
        this.idProduct = countProduct++;
        this.name = name;
        this.stock = stock;
        this.description = description;
        this.category = category;
        this.tags = tags;
        this.price = price;
    }

    public Product(String name, String description, String category, String tags, float price) {
        this.idProduct = countProduct++;
        this.name = name;
        this.description = description;
        this.category = category;
        this.tags = tags;
        this.price = price;
    }

    public static int getCountProduct() {
        return countProduct;
    }

    public static void setCountProduct(int countProduct) {
        Product.countProduct = countProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProducto) {
        this.idProduct = idProducto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if(stock <= 0){
            System.out.println("producto agotado");
        }else {
            this.stock = stock;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String countStock(int stock, int pedido) {
        int calculo = pedido-stock;
        if (calculo<=-1) {
            return "solo tengo disponible, " + getStock();
        }else {
            setStock(calculo);
            return "quedan " + calculo + " en stock.";
        }
    }
    //metodo para validar si el precio del producto es mayor o menor a uno ingresado por el usuario
    public String esPrecioMayorOMenor(double valorComparacion, double precio) {
        if(precio < valorComparacion){
            return "el precio del producto es menor, puedes llevar otro producto.";
        } else {
            return "el precio del producto es mayor, no te alcanza.";
        }
    }

    //metodo para validar si una palabra pasado existe como numbre de una instancia de producto
    public String contienePalabra(String palabra, String buscar) {
        if(palabra.equalsIgnoreCase(buscar)){
            return "el nombre del producto si existe en nuestro inventario.";
        } else {
            return "producto no disponible.";
        }
    }


    @Override
    public String toString() {
        return "Product{" +
                " codigo producto =" + idProduct +
                ", nombre ='" + name + '\'' +
                ", cantidad disponible  =" + stock +
                ", descripcion ='" + description + '\'' +
                ", categoria ='" + category + '\'' +
                ", etiquetas ='" + tags + '\'' +
                ", precio =" + price +
                '}';
    }
}
