package com.ss.utopia.model;

public class Airplane {
	
	private Integer id;
	private AirplaneType typeId;
	
	@Override
	public String toString() {
		return "Airplane [id=" + id + ", typeId=" + typeId + "]";
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the typeId
	 */
	public AirplaneType getTypeId() {
		return typeId;
	}
	/**
	 * @param typeId the typeId to set
	 */
	public void setTypeId(AirplaneType typeId) {
		this.typeId = typeId;
	}
	
}
