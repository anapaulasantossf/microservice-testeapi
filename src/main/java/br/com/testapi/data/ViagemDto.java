package br.com.testapi.data;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

public class ViagemDto implements Serializable {

	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;

	private String localDeDestino;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataPartida;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataRetorno;

	private String acompanhante;

	public ViagemDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//@NotNull("Local de Destino é uma informação obrigatória")
	@Length(min = 3, max = 40, message = "Local de Destino deve estar entre 3 e 40 caracteres")
	public String getLocalDeDestino() {
		return localDeDestino;
	}

	public void setLocalDeDestino(String localDeDestino) {
		this.localDeDestino = localDeDestino;
	}

	//@NotNull(message = "Data da Partida é uma informação obrigatória")
	public Date getDataPartida() {
		return dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public String getAcompanhante() {
		return acompanhante;
	}

	public void setAcompanhante(String acompanhante) {
		this.acompanhante = acompanhante;
	}

	@Override
	public String toString() {
		return "ViagemDto [id=" + id + ", localDeDestino=" + localDeDestino + ", dataPartida=" + dataPartida
				+ ", dataRetorno=" + dataRetorno + ", acompanhante=" + acompanhante + "]";
	}
}