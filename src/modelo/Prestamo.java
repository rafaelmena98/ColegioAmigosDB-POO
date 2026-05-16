package modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private int id_prestamo;
    private int id_usuario;
    private String codigo_ejemplar;
    private LocalDate fecha_prestamo;
    private LocalDate fecha_limite;
    private LocalDate fecha_devolucion;
    private String estado;

    private static final double MORA_POR_DIA = 0.50;

    public Prestamo() {
    }

    public Prestamo(int id_usuario, String codigo_ejemplar) {
        this.id_usuario = id_usuario;
        this.codigo_ejemplar = codigo_ejemplar;
        this.fecha_prestamo = LocalDate.now();
        this.fecha_limite = this.fecha_prestamo.plusDays(7);
        this.estado = "En curso";
    }

    public double getMontoMora() {
        LocalDate hoy = LocalDate.now();
        if (fecha_devolucion == null && hoy.isAfter(fecha_limite)) {
            long dias = ChronoUnit.DAYS.between(fecha_limite, hoy);
            return dias * MORA_POR_DIA;
        }
        return 0.0;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCodigo_ejemplar() {
        return codigo_ejemplar;
    }

    public void setCodigo_ejemplar(String codigo_ejemplar) {
        this.codigo_ejemplar = codigo_ejemplar;
    }

    public LocalDate getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(LocalDate fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public LocalDate getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(LocalDate fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public LocalDate getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(LocalDate fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}