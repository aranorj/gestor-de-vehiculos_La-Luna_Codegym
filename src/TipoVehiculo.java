public enum TipoVehiculo {
    COCHE(1),
    MOTO(2),
    CAMION(3);

    private final int codigo;

    TipoVehiculo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static TipoVehiculo obtenerTipoDesdeInt(int entrada) {
        for (TipoVehiculo tipo : TipoVehiculo.values()) {
            if (tipo.getCodigo() == entrada) {
                return tipo;
            }
        }
        return null;
    }
}
