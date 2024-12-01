CREATE TABLE IF NOT EXISTS reserva_schema."reserva" (
    reserva_id UUID NOT NULL,
    usuario_id UUID NOT NULL,
    restaurante_id UUID NOT NULL,
    activa BOOLEAN DEFAULT TRUE,
    numero_comensales INTEGER NOT NULL,
    PRIMARY KEY (reserva_id),
    FOREIGN KEY (usuario_id) REFERENCES reserva_schema."usuario"(usuario_id),
    FOREIGN KEY (restaurante_id) REFERENCES reserva_schema."restaurante"(restaurante_id)
);
