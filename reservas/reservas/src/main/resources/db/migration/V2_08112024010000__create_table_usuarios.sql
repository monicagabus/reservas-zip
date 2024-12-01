CREATE TABLE IF NOT EXISTS reserva_schema."usuario" (
    usuario_id UUID NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(100) NOT NULL UNIQUE,
    PRIMARY KEY (usuario_id)
);
