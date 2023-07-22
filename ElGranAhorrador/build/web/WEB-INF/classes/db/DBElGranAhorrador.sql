Drop database if exists DBElGranAhorrador;
Create database DBElGranAhorrador;
use DBElGranAhorrador;


-- --------- Entidades Sin FK --------- --
Create table TipoEmpleado(
    idTipoEmpleado int not null auto_increment,
    tipoEmpleado varchar(100) not null,
    descipcion varchar(100) not null,
    departamento varchar(100) not null,
    primary key PK_idTipoEmpleado(idTipoEmpleado)
);

Create table Sucursales(
	idSucursal int not null auto_increment,
    nombreSucursal varchar(100) not null,
    direccionSucursal varchar(100) not null,
    apertura time not null,
    cierre time not null,
    primary key PK_idSucursal(idSucursal)
);

Create table Login(
	idLogin int not null auto_increment,
    usuario varchar(50) not null,
    contraseña varchar(50) not null,
    tipoUsuario boolean not null,
    foto mediumblob,
    primary key PK_idLogin(idLogin)
);

Create table Afiliado(
	idAfiliado int not null auto_increment,
    rangoAfiliado varchar(50) not null,
    beneficios varchar(50) not null,
    precioRango decimal (10,2) not null,
    fechaExpiracion date not null,
    primary key PK_idAfiliado(idAfiliado)
);

Create table MetodoPago(
	idMetodoPago int not null auto_increment,
    metodoPago varchar(20) not null,
    pagoTotal decimal(10,2) not null,
    banco varchar(20) not null,
    primary key PK_idMetodoPago(idMetodoPago)
);

Create table Cupones(
	idCupon int not null auto_increment,
    fechaCaducidad date not null,
    descuento decimal(10,2) not null,
    validez boolean not null,
    primary key PK_idCupon(idCupon)
);

Create table TipoProducto(
	idTipoProducto int not null auto_increment,
    tipoProducto varchar(50) not null,
    descripcion varchar(100) not null,
    categoria varchar(50) not null,
    primary key PK_idTipoProducto(idTipoProducto)
);

Create table Inventario(
	idInventario int not null auto_increment,
    cantidadDisponible int not null,
    direccionDisponibilidad varchar(100) not null,
    disponibilidad boolean not null,
    primary key PK_idInventario(idInventario)
);

-- --------- Entidades Con FK --------- --
Create table Empleados(
	idEmpleado int not null auto_increment,
    nombreEmpleado varchar(50) not null,
    apellidoEmpleado varchar(50) not null,
    sueldo decimal(10,2) not null,
    idTipoEmpleado int not null,
    idSucursal int not null,
    primary key PK_idEmpleado(idEmpleado),
    constraint FK_Empleados_TipoEmpleado foreign key
		(idTipoEmpleado) references TipoEmpleado(idTipoEmpleado),
	constraint FK_Empleados_Sucursales foreign key
		(idSucursal) references Sucursales(idSucursal)
);

Create table Clientes(
	idCliente int not null auto_increment,
    nombreCliente varchar(50) not null,
    apellidoCliente varchar(50) not null,
    telefonoCliente varchar(8) not null,
    direccionCliente varchar(100) not null,
    idLogin int not null,
    idAfiliado int not null,
    primary key PK_idCliente(idCliente),
    constraint FK_Clientes_Login foreign key
		(idLogin) references Login(idLogin),
	constraint FK_Clientes_Afiliado foreign key
		(idAfiliado) references Afiliado(idAfiliado)
);

Create table Envio(
	idEnvio int not null auto_increment,
    direccionEnvio varchar(100),
	telefonoContacto varchar(8) not null,
    idEmpleado int not null,
    primary key PK_idEnvio(idEnvio),
    constraint FK_Envio_Empleados foreign key
		(idEmpleado) references Empleados(idEmpleado)
);

Create table Productos(
	idProducto int not null auto_increment,
    nombreProducto varchar(100) not null,
    precioProducto decimal(10,2) not null,
    marca varchar(50) not null,
    fechaVencimiento date not null,
    idTipoProducto int not null,
    idInventario int not null,
    primary key PK_idProducto(idProducto),
    constraint FK_Productos_TipoProducto foreign key
		(idTipoProducto) references TipoProducto(idTipoProducto),
	constraint FK_Productos_Inventario foreign key
		(idInventario) references Inventario(idInventario)
);

Create table Proveedores(
	idProveedor int not null auto_increment,
    proveedor varchar(100) not null,
    cantidadAdquirida int not null,
    totalPagar decimal(10,2) not null,
    idProducto int not null,
    primary key PK_idProveedor(idProveedor),
    constraint FK_Proveedores_Productos foreign key
		(idProducto) references Productos(idProducto)
);

Create table Compra(
	idCompra int not null auto_increment,
    cantidadProducto int not null,
    idEmpleado int not null,
    idCliente int not null,
    idProducto int not null,
    primary key PK_idCompra(idCompra),
    constraint FK_Compra_Empleados foreign key
		(idEmpleado) references Empleados(idEmpleado),
	constraint FK_Compra_Clientes foreign key
		(idCliente) references Clientes(idCliente),
	constraint FK_Compra_Productos foreign key
		(idProducto) references Productos(idProducto)
);

Create table Factura(
	idFactura int not null auto_increment,
    fecha date not null,
    idCompra int not null,
    idEnvio int not null,
    idMetodoPago int not null,
    idCupon int not null,
    primary key PK_idFactura(idFactura),
    constraint FK_Factura_Compra foreign key
		(idCompra) references Compra(idCompra),
	constraint FK_Factura_Envio foreign key
		(idEnvio) references Envio(idEnvio),
	constraint FK_Factura_MetodoPago foreign key
		(idMetodoPago) references MetodoPago(idMetodoPago),
	constraint FK_Factura_Cupones foreign key
		(idCupon) references Cupones(idCupon)
);

-- ------------------ Insertar Datos ---------------------


-- ----- Sin FK ----- --
-- TipoEmpleado
Insert into TipoEmpleado(tipoEmpleado, descipcion, departamento)
	values	('Cajero','Manejan el dinero y tienen que cuadrar las cajas.','Caja'),
			('Reponedor','Reciben el producto, ayudan a descargarlo y a distribuirlo.','Almacén');

-- Sucursales
Insert into Sucursales(nombreSucursal, direccionSucursal, apertura, cierre)
	values	('Alamos','0 Calle 0-60, zona 7 Villa Hermosa 1, Carr. a Villa Canales',"07:00","22:00"),
			('Atanasio','Calz. Atanasio Tzul, Guatemala',"07:00","22:00");

-- Login
Insert into Login(usuario, contraseña, tipoUsuario) -- , foto)
	values	('martinez','12345',true), -- ,load_file('ruta de imagen')),
			('ejemplo','54321',true); -- ,load_file('ruta de imagen'));

-- Afiliado
Insert into Afiliado(rangoAfiliado, beneficios, precioRango, fechaExpiracion)
	values	('platino','50% de descuento','500.00','2024-05-20'),
			('Oro','30% de descuento','250.00','2024-05-20');
-- MetodoPago
Insert into MetodoPago(metodoPago, pagoTotal, banco)
	values	('Efectivo','30.00','Banrural'),
			('Paypal','25.00','BI');

-- Cupones
Insert into Cupones(fechaCaducidad, descuento, validez)
	values	('2025-12-30','50.00',true),
			('2022-12-30','25.00',false);

-- TipoProducto
Insert into TipoProducto(tipoProducto, descripcion, categoria)
	values	('Leche entera','Leche con Lactosa','Lacteo'),
			('Queso Blanco','Queso de carbra blanco','Lacteo');
            
-- Inventario
Insert into Inventario(cantidadDisponible, direccionDisponibilidad, disponibilidad)
	values	('15','pasillo 4',true),
			('8','pasillo 5',true);




-- ----------------Con FK----------------------------

-- Empleados
Insert into Empleados(nombreEmpleado, apellidoEmpleado, sueldo, idTipoEmpleado, idSucursal)
	values	('Alfonzo','Peres','4000.00',1,1),
			('Pedro','Cancinos','6000.00',2,2);
            
-- Clientes
Insert into Clientes(nombreCliente, apellidoCliente, telefonoCliente, direccionCliente, idLogin, idAfiliado)
	values	('Karen','Martinez','12345678','22 calle 33-88 mixco',1,1),
			('Carlos','Morales','87654321','33calle 8-8 Alamos',2,2);

-- Envio
Insert into Envio(direccionEnvio, telefonoContacto, idEmpleado)
	values	('22 calle 33-88 mixco','36985789',2),
			('33calle 8-8 Alamos','36985789',2);
            
-- Productos
Insert into Productos(nombreProducto, precioProducto, marca, fechaVencimiento, idTipoProducto, idInventario)
	values	('NutriLeche','30.00','Trebolac','2024-02-12',1,1),
			('QuesoCabra','25.00','Trebolac','2023-12-15',2,2);

-- Proveedores
Insert into Proveedores(proveedor, cantidadAdquirida, totalPagar, idProducto)
	values	('Trebolac','20','600.00',1),
			('Trebolac','20','500.00',2);
            
-- Compra
Insert into Compra(cantidadProducto, idEmpleado, idCliente, idProducto)
	values	('1',1,1,1),
			('1',1,2,2);
            
-- Factura
Insert into Factura(fecha, idCompra, idEnvio, idMetodoPago, idCupon)
	values	('2023-07-05',1,1,1,1),
			('2023-07-08',2,2,2,1);