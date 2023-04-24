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

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Version;

@Entity
public class IdOrderedOneManyParent {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany(mappedBy="explicitParent")
    @OrderBy("id ASC")
    private List<IdOrderedOneManyChild> explicitChildren =
        new ArrayList<>();

    @OneToMany(mappedBy="implicitParent")
    @OrderBy
    private List<IdOrderedOneManyChild> implicitChildren =
        new ArrayList<>();

    @Version
    private int optLock;

    public long getId() {
        return id;
    }

    public List<IdOrderedOneManyChild> getExplicitChildren() {
        return explicitChildren;
    }

    public List<IdOrderedOneManyChild> getImplicitChildren() {
        return implicitChildren;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
