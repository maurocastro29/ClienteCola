package clases;


public class Cliente {
    private int id;
    private String nombre;
    private float saldoActual;
    private String tipOperacion;
    private float valorOperacion;
    private String fechaOperacion;
    private float saldoDespues;
    private Cliente ant;
    
    public Cliente(int id, String nombre, float saldoActual, String tipOperacion, float valorOperacion) {
        this.id = id;
        this.nombre = nombre;
        this.saldoActual = saldoActual;
        this.tipOperacion = tipOperacion;
        this.valorOperacion = valorOperacion;
        this.fechaOperacion = "Sin operacion realizada aun";
        this.saldoDespues = 0;
        this.ant = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(float saldoActual) {
        this.saldoActual = saldoActual;
    }

    public String getTipOperacion() {
        return tipOperacion;
    }

    public void setTipOperacion(String tipOperacion) {
        this.tipOperacion = tipOperacion;
    }

    public float getValorOperacion() {
        return valorOperacion;
    }

    public void setValorOperacion(float valorOperacion) {
        this.valorOperacion = valorOperacion;
    }

    public String getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(String fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public float getSaldoDespues() {
        return saldoDespues;
    }

    public void setSaldoDespues(float saldoDespues) {
        this.saldoDespues = saldoDespues;
    }
    
    public Cliente getAnt() {
        return ant;
    }

    public void setAnt(Cliente ant) {
        this.ant = ant;
    }

    
}
