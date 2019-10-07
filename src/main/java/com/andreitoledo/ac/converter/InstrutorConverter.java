package com.andreitoledo.ac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.ac.dao.InstrutorDAO;
import com.andreitoledo.ac.model.Instrutor;

@FacesConverter(forClass = Instrutor.class)
public class InstrutorConverter implements Converter {

	@Inject
	private InstrutorDAO instrutorDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Instrutor retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.instrutorDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Long codigo = ((Instrutor) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
