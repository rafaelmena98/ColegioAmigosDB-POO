package modelo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class prestamo {
    private int idPrestamo;
    private String idDocumento; // ID del libro, revista, etc.
    private int idUsuario;      // ID del Alumno o Profesor
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionProgramada;
    private LocalDate fechaDevolucionReal;
    private double montoMora;

    // Configuración de negocio (Según requerimientos de "Configurar Mora")
    private static final double MORA_POR_DIA = 0.50; // Ejemplo de mora diaria

    // Constructor para nuevos préstamos
    public Prestamo(int idUsuario, String idDocumento) {
        this.idUsuario = idUsuario;
        this.idDocumento = idDocumento;
        this.fechaPrestamo = LocalDate.now();
        // Por defecto, damos 7 días para la devolución
        this.fechaDevolucionProgramada = fechaPrestamo.plusDays(7);
        this.montoMora = 0.0;
    }


    public void actualizarMora() {
        LocalDate hoy = LocalDate.now();
        if (hoy.isAfter(fechaDevolucionProgramada)) {
            long diasRetraso = ChronoUnit.DAYS.between(fechaDevolucionProgramada, hoy);
            this.montoMora = diasRetraso * MORA_POR_DIA;
        } else {
            this.montoMora = 0.0;
        }
    }


    public double getMontoMora() {
        actualizarMora(); // Actualizamos antes de devolver el valor
        return montoMora;
    }

    public LocalDate getFechaDevolucionProgramada() {
        return fechaDevolucionProgramada;
    }

}