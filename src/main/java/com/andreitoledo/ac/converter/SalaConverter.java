package com.andreitoledo.ac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.ac.dao.SalaDAO;
import com.andreitoledo.ac.model.Sala;

@FacesConverter(forClass = Sala.class)
public class SalaConverter implements Converter {

	@Inject
	private SalaDAO salaDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		Sala retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.salaDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Long codigo = ((Sala) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
