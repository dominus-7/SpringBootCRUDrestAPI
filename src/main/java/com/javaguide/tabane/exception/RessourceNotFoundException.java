package com.javaguide.tabane.exception;

public class RessourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String RessourceName;
	private String fieldName;
	private Object fieldValue;

	public RessourceNotFoundException(String ressourceName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : %s", ressourceName, fieldName, fieldValue));
		RessourceName = ressourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getRessourceName() {
		return RessourceName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

}
