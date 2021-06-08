package com.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class AbstractDomainObject<T extends Serializable> implements DomainObject<T> {
	private Date createTstamp;
	private Date modifyTstamp;

	public Date getCreateTstamp() {
		return createTstamp;
	}
	public void setCreateTstamp(Date createTstamp) {
		this.createTstamp = createTstamp;
	}
	public Date getModifyTstamp() {
		return modifyTstamp;
	}
	public void setModifyTstamp(Date modifyTstamp) {
		this.modifyTstamp = modifyTstamp;
	}

	@PreUpdate
    @PrePersist
    public void updateTimeStamps() {
		modifyTstamp = new Date();
        if (createTstamp == null) {
        	createTstamp = new Date();
        }
    }
}
