package Models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Productos")
public class Producto {
	
	@Id
	@Column
	private String CodigoProducto;
	@Column
	private String Nombre;
	@Column
	private String Gama;
	@Column
	private String Dimensiones;
	@Column
	private String Proveedor;
	@Column(name="Descripcion", columnDefinition="TEXT")
	private String Descripcion;
	@Column
	private short CantidadEnStock;
	
	public BigDecimal getPrecioProveedor() {
		return PrecioProveedor;
	}

	public void setPrecioProveedor(BigDecimal precioProveedor) {
		PrecioProveedor = precioProveedor;
	}

	public BigDecimal getPrecioVenta() {
		return PrecioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		PrecioVenta = precioVenta;
	}

	@Column
	private BigDecimal PrecioProveedor;
	@Column
	private BigDecimal PrecioVenta;
	
	@ManyToMany
    @JoinTable(
      name="DetallePedidos",
      joinColumns=@JoinColumn(name="CodigoProducto", referencedColumnName="CodigoProducto"),
      inverseJoinColumns=@JoinColumn(name="CodigoPedido", referencedColumnName="CodigoPedido"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Pedido> Pedidos;

	public String getCodigoProducto() {
		return CodigoProducto;
	}

	public void setCodigoProducto(String codigoProducto) {
		CodigoProducto = codigoProducto;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getGama() {
		return Gama;
	}

	public void setGama(String gama) {
		Gama = gama;
	}

	public String getDimensiones() {
		return Dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		Dimensiones = dimensiones;
	}

	public String getProveedor() {
		return Proveedor;
	}

	public void setProveedor(String proveedor) {
		Proveedor = proveedor;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getCantidadEnStock() {
		return CantidadEnStock;
	}

	public void setCantidadEnStock(short cantidadEnStock) {
		CantidadEnStock = cantidadEnStock;
	}

	public List<Pedido> getPedidos() {
		return Pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		Pedidos = pedidos;
	}
	
	

}
