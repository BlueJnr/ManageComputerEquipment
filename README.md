# ManageComputerEquipment

*Se desarrollo la solución para los requerimientos de una empresa comercializadora de equipos de cómputo que necesita crear una aplicación que le permita:*

1. Gestionar sus Equipos de Cómputo:
	a. Dar mantenimiento a los datos (CRUD) de los equipos de cómputo, para ello se creará la clase Equipo con los atributos: nombre, stock, precio, categoría. (los precios serán de acuerdo a la categoría del equipo: A – S/. 5000, B – S/. 250, C – S/. 150) y estado (Activo o Desactivo). Todos los equipos tienen un fabricante (id, nombre, dirección y RUC)
	b. Listar los equipos por categoría (Indicando el número de elementos y stock valorizado (suma de precios) por categoría.
	c. Dar de baja a un equipo y listar los equipos existentes después de darle baja a algún equipo. Dar de baja solo sería cambiar un estado del producto.
2. Realizar la venta de cierta cantidad de un mismo equipo y generar la Boleta o Factura por dicha venta.
3. Todas las acciones deben ser desarrolladas usando Clases Main a modo de pruebas.
4. Debe usar patrones Singleton, Dao y Dao Fatory para el caso. Genere un buen modelo de clases y demuestre el desacoplamiento. Use ENUMs.