package com.residencia.ecommerce.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidoDTO {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer idPedido;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Date dataPedido;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Date dataEntrega;

	@JsonFormat(pattern = "dd-MM-yyyy")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Date dataEnvio;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Boolean status;
	
	private Integer idCliente;

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

}
