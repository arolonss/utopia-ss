/**
 * 
 */
package com.dss.utopia.model;

/**
 * @author amanda
 *
 */
public class Route {
  
	private Integer id;
	private Airport dest_id;
	private Airport org_id;
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
	 * @return the dest_id
	 */
	public Airport getDest_id() {
		return dest_id;
	}
	/**
	 * @param dest_id the dest_id to set
	 */
	public void setDest_id(Airport dest_id) {
		this.dest_id = dest_id;
	}
	/**
	 * @return the org_id
	 */
	public Airport getOrg_id() {
		return org_id;
	}
	/**
	 * @param org_id the org_id to set
	 */
	public void setOrg_id(Airport org_id) {
		this.org_id = org_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
