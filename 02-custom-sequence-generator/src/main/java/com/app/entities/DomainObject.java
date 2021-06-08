package com.app.entities;

import java.io.Serializable;

public interface DomainObject<T extends Serializable> {
	T getId();
	void setId(T t);
}
