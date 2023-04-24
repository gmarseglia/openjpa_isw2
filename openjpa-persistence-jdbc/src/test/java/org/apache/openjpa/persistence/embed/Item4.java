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
package org.apache.openjpa.persistence.embed;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyEnumerated;

@Entity
public class Item4 {
    @Id
    int id;

    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    Map<Catagory, FileName4> images = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Catagory, FileName4> getImages() {
        return images;
    }

    public void addImage(Catagory cat, FileName4 fileName) {
        images.put(cat, fileName);
    }

    public void removeImage(Catagory cat) {
        images.remove(cat);
    }

    public FileName4 getImage(Catagory cat) {
        return images.get(cat);
    }

    public enum Catagory { A1, A2, A3, A4 }

}
