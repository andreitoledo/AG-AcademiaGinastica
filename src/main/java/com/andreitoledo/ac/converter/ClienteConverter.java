package com.andreitoledo.ac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.ac.dao.ClienteDAO;
import com.andreitoledo.ac.model.Cliente;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter {

	@Inject
	private ClienteDAO clienteDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Cliente retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.clienteDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Long codigo = ((Cliente) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
