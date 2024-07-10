CREATE TRIGGER tr_agregar_medicamento ON Inventario
AFTER INSERT, UPDATE
AS
BEGIN
    -- Sumar la CantidadComprada a Medicamentos.Existencias
    UPDATE m
    SET cantidadDisponible = m.cantidadDisponible + i.cantidadinsumoComprada
    FROM dbo.Insumo m
    INNER JOIN inserted i ON m.id = i.id;
END;