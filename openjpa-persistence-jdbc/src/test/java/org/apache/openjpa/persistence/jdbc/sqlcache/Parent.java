/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.openjpa.persistence.jdbc.sqlcache;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Parent in a bidirectional parent-child relationship.
 *
 * Note:
 * a) there is no mutator for id because it is generated by JPA provider.
 *
 */
@Entity
@IdClass(ParentId.class)
@Table(name="zparent")
public class Parent {
	@Id
	private long id;
	@Id
	private String name;
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addrid")
    private Address addrId;

	/**
     * This field is mapped by the child. The child's table will hold a foreign
     * key linking to the primary key of this Parent's table. In JPA
     * terminology, that makes the Child the owner of this bi-directional
     * relationship.
	 */
	@OneToMany(mappedBy="parent", cascade = CascadeType.ALL)
	private Collection<Child> children;


    public long getId() {
		return id;
	}

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public void setAddrId(Address addr) {
        this.addrId = addr;
    }

    public Address getAddrId() {
        return addrId;
    }

    public Collection<Child> getChildren() {
		return children;
	}

	/**
     * Creates and adds a child to this receiver. Creating child via the parent
     * is the preferred pattern to ensure referential integrity of domain model.
	 */
	public Child newChild(String name) {
		Child child = new Child();
		child.setName(name);
		child.setParent(this);
		if (children == null)
			children = new ArrayList<>();
		children.add(child);
		return child;
	}

	public boolean removeChild(Child child) {
		return children != null && children.remove(child);
	}

	/**
     * Unsafe way of adding a child. Does not warranty referential integrity.
     * The caller has to ensure bi-directionality of parent-child relation is
	 * consistent.
	 */
	public void add(Child child) {
		if (children == null)
			children = new ArrayList<>();
		children.add(child);
	}
}
