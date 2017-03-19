package Models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Pedidos")
public class Pedido {

	@Id
	@Column
	private int CodigoPedido;
	@Column
	private Date FechaPedido;
	@Column
	private Date FechaEsperada;
	@Column
	private Date FechaEntrega;
	@Column(name="Comentarios", columnDefinition="TEXT")
	private String Comentarios;
	@Column
	private String Estado;
	@Column
	private int CodigoCliente;
	
	@ManyToMany
    @JoinTable(
      name="DetallePedidos",
      joinColumns=@JoinColumn(name="CodigoPedido", referencedColumnName="CodigoPedido"),
      inverseJoinColumns=@JoinColumn(name="CodigoProducto", referencedColumnName="CodigoProducto"))
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Producto> Productos;

	public Pedido() {
	}

	public int getCodigoPedido() {
		return CodigoPedido;
	}

	public void setCodigoPedido(int codigoPedido) {
		CodigoPedido = codigoPedido;
	}

	public Date getFechaPedido() {
		return FechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		FechaPedido = fechaPedido;
	}

	public Date getFechaEsperada() {
		return FechaEsperada;
	}

	public void setFechaEsperada(Date fechaEsperada) {
		FechaEsperada = fechaEsperada;
	}

	public Date getFechaEntrega() {
		return FechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		FechaEntrega = fechaEntrega;
	}

	public String getComentarios() {
		return Comentarios;
	}

	public void setComentarios(String comentarios) {
		Comentarios = comentarios;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public int getCodigoCliente() {
		return CodigoCliente;
	}

	public void setCodigoCliente(int codigoCliente) {
		CodigoCliente = codigoCliente;
	}

	public List<Producto> getProductos() {
		return Productos;
	}

	public void setProductos(List<Producto> productos) {
		Productos = productos;
	}

	

}
