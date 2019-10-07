package com.andreitoledo.ac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.ac.dao.TipoAtividadeDAO;
import com.andreitoledo.ac.model.TipoAtividade;

@FacesConverter(forClass = TipoAtividade.class)
public class TipoAtividadeConverter implements Converter {

	@Inject
	private TipoAtividadeDAO tipoAtividadeDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		TipoAtividade retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.tipoAtividadeDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Long codigo = ((TipoAtividade) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
