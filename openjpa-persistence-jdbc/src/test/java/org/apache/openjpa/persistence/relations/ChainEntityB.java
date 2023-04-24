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
package org.apache.openjpa.persistence.relations;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;

@Entity
public class ChainEntityB {

	@Id
	@GeneratedValue
	private long bId;

	@Version
	private Integer optLock;

	//cascade = CascadeType.ALL,
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER,
	        mappedBy = "chainEntityB")
	protected Set<ChainEntityC> chainEntityCSet = null;

	public void addChainEntityC (ChainEntityC bean) {
		if (null == chainEntityCSet)
			chainEntityCSet = new LinkedHashSet<> ();
		chainEntityCSet.add (bean);
		bean.setChainEntityB (this);
	}

	public Collection<ChainEntityC> getChainEntityCSet () {
		if (null == chainEntityCSet)
			chainEntityCSet = new LinkedHashSet<> ();
		return chainEntityCSet;
	}

	private String name;

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public long getId () {
		return bId;
	}

	public void setId (long id) {
		this.bId = id;
	}

}
