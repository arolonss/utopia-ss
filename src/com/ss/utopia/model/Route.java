/**
 * 
 */
package com.ss.utopia.model;

/**
 * @author amanda
 *
 */
public class Route {
  
	private Integer id;
	private Airport destId;
	private Airport orgId;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Route [id=" + id + ", destId=" + destId + ", orgId=" + orgId + "]";
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the destId
	 */
	public Airport getDestId() {
		return destId;
	}
	/**
	 * @param destId the destId to set
	 */
	public void setDestId(Airport destId) {
		this.destId = destId;
	}
	/**
	 * @return the orgId
	 */
	public Airport getOrgId() {
		return orgId;
	}
	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(Airport orgId) {
		this.orgId = orgId;
	}
	
	
	
	
}
