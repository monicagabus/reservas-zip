CREATE TABLE IF NOT EXISTS reserva_schema."reservas" (
    reserva_id UUID NOT NULL,
    usuario_id UUID NOT NULL,
    restaurantes_id UUID NOT NULL,
    activa BOOLEAN DEFAULT TRUE,
    numero_comensales INTEGER NOT NULL,
    PRIMARY KEY (reserva_id),
    FOREIGN KEY (usuario_id) REFERENCES reserva_schema."usuarios"(usuario_id),
    FOREIGN KEY (restaurantes_id) REFERENCES reserva_schema."restaurantes"(restaurantes_id)
);
