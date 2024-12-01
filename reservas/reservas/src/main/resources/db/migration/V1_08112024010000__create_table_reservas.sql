CREATE TABLE IF NOT EXISTS reserva_schema."restaurante" (
    restaurante_id UUID NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    capacidad INTEGER NOT NULL,
    tipo_comida VARCHAR(50) NOT NULL,
    comensales_actuales INTEGER DEFAULT 0,
    PRIMARY KEY (restaurante_id)
);