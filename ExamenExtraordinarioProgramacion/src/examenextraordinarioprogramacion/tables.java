/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenextraordinarioprogramacion;

/**
 *
 * @author Fabian salinas
 */
public class tables extends Productos{
    String Categoria , marca , sistema_operativo;

    public tables(String Categoria, String marca, String sistema_operativo, int id, String nombre, double precio, int stock) {
        super(id, nombre, precio, stock);
        this.Categoria = Categoria;
        this.marca = marca;
        this.sistema_operativo = sistema_operativo;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSistema_operativo() {
        return sistema_operativo;
    }

    public void setSistema_operativo(String sistema_operativo) {
        this.sistema_operativo = sistema_operativo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "tables" + "Categoria=" + Categoria + ", marca=" + marca + ", sistema_operativo=" + sistema_operativo;
    }
    
    
    
}
