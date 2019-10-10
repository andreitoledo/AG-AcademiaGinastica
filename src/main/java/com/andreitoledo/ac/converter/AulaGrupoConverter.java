package com.andreitoledo.ac.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.andreitoledo.ac.dao.AulaGrupoDAO;
import com.andreitoledo.ac.model.AulaGrupo;

@FacesConverter(forClass = AulaGrupo.class)
public class AulaGrupoConverter implements Converter {

	@Inject
	private AulaGrupoDAO aulaGrupoDAO;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		AulaGrupo retorno = null;

		if (StringUtils.isNotEmpty(value)) {
			retorno = this.aulaGrupoDAO.buscarPeloCodigo(new Long(value));

		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Long codigo = ((AulaGrupo) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;

		}

		return "";
	}

}
