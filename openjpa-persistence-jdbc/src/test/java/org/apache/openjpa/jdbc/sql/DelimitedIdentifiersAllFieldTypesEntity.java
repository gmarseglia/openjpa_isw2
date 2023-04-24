/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.openjpa.jdbc.sql;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.openjpa.persistence.PersistentCollection;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class DelimitedIdentifiersAllFieldTypesEntity {

    public enum EnumType {
        Value1, Value2
    }

    // @Basic types
    private short shortField;
    private int intField;
    private boolean booleanField;
    private long longField;
    private float floatField;
    private char charField;
    private double doubleField;
    private byte byteField;
    private Short wShortField;
    private Integer wIntegerField;
    private Boolean wBooleanField;
    private Long wLongField;
    private Float wFloatField;
    private Character wCharacterField;
    private Double wDoubleField;
    private Byte wByteField;
    private BigInteger bigIntegerField;
    private BigDecimal bigDecimalField;
    private String stringField;
    private Date dateField;
    private Calendar calendarField;
    private java.sql.Date sqlDateField;
    private java.sql.Time sqlTimeField;
    private java.sql.Timestamp sqlTimestampField;
    private byte[] byteLob;
    private Byte[] wByteLob;
    private char[] charLob;
    private Character[] wCharacterLob;
    private EnumType enumField;
    private Serializable serializableField;

    // Additional types
    private Set<String> setOfStrings = new HashSet<>();
    private String[] arrayOfStrings;

    @PersistentCollection
    private int[] arrayOfInts;

    // one-to-one and one-to-many relations to self
    @OneToOne
    private DelimitedIdentifiersAllFieldTypesEntity selfOneOne;
    @OneToMany
    private List<DelimitedIdentifiersAllFieldTypesEntity> selfOneMany = new ArrayList<>();

    // Java8 DateTime types which are required by the JPA-2.2 spec
    private LocalDate localDateField;
    private LocalTime localTimeField;
    private LocalDateTime localDateTimeField;
    private OffsetTime offsetTimeField;
    private OffsetDateTime offsetDateTimeField;

    public void setShortField(short shortField) {
        this.shortField = shortField;
    }

    public short getShortField() {
        return this.shortField;
    }

    public void setIntField(int intField) {
        this.intField = intField;
    }

    public int getIntField() {
        return this.intField;
    }

    public void setBooleanField(boolean booleanField) {
        this.booleanField = booleanField;
    }

    public boolean getBooleanField() {
        return this.booleanField;
    }

    public void setLongField(long longField) {
        this.longField = longField;
    }

    public long getLongField() {
        return this.longField;
    }

    public void setFloatField(float floatField) {
        this.floatField = floatField;
    }

    public float getFloatField() {
        return this.floatField;
    }

    public void setCharField(char charField) {
        this.charField = charField;
    }

    public char getCharField() {
        return this.charField;
    }

    public void setDoubleField(double doubleField) {
        this.doubleField = doubleField;
    }

    public double getDoubleField() {
        return this.doubleField;
    }

    public void setByteField(byte byteField) {
        this.byteField = byteField;
    }

    public byte getByteField() {
        return this.byteField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public String getStringField() {
        return this.stringField;
    }

    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }

    public Date getDateField() {
        return this.dateField;
    }

    public void setSetOfStrings(Set<String> setOfStrings) {
        this.setOfStrings = setOfStrings;
    }

    public Set<String> getSetOfStrings() {
        return this.setOfStrings;
    }

    public void setArrayOfStrings(String[] arrayOfStrings) {
        this.arrayOfStrings = arrayOfStrings;
    }

    public String[] getArrayOfStrings() {
        return this.arrayOfStrings;
    }

    public void setArrayOfInts(int[] arrayOfInts) {
        this.arrayOfInts = arrayOfInts;
    }

    public int[] getArrayOfInts() {
        return arrayOfInts;
    }

    public BigDecimal getBigDecimalField() {
        return bigDecimalField;
    }

    public void setBigDecimalField(BigDecimal bigDecimalField) {
        this.bigDecimalField = bigDecimalField;
    }

    public BigInteger getBigIntegerField() {
        return bigIntegerField;
    }

    public void setBigIntegerField(BigInteger bigIntegerField) {
        this.bigIntegerField = bigIntegerField;
    }

    public byte[] getByteLob() {
        return byteLob;
    }

    public void setByteLob(byte[] byteLob) {
        this.byteLob = byteLob;
    }

    public Calendar getCalendarField() {
        return calendarField;
    }

    public void setCalendarField(Calendar calendarField) {
        this.calendarField = calendarField;
    }

    public char[] getCharLob() {
        return charLob;
    }

    public void setCharLob(char[] charLob) {
        this.charLob = charLob;
    }

    public EnumType getEnumField() {
        return enumField;
    }

    public void setEnumField(EnumType enumField) {
        this.enumField = enumField;
    }

    public Serializable getSerializableField() {
        return serializableField;
    }

    public void setSerializableField(Serializable serializableField) {
        this.serializableField = serializableField;
    }

    public java.sql.Date getSqlDateField() {
        return sqlDateField;
    }

    public void setSqlDateField(java.sql.Date sqlDateField) {
        this.sqlDateField = sqlDateField;
    }

    public java.sql.Time getSqlTimeField() {
        return sqlTimeField;
    }

    public void setSqlTimeField(java.sql.Time sqlTimeField) {
        this.sqlTimeField = sqlTimeField;
    }

    public java.sql.Timestamp getSqlTimestampField() {
        return sqlTimestampField;
    }

    public void setSqlTimestampField(java.sql.Timestamp sqlTimestampField) {
        this.sqlTimestampField = sqlTimestampField;
    }

    public Boolean getWBooleanField() {
        return wBooleanField;
    }

    public void setWBooleanField(Boolean booleanField) {
        wBooleanField = booleanField;
    }

    public Byte getWByteField() {
        return wByteField;
    }

    public void setWByteField(Byte byteField) {
        wByteField = byteField;
    }

    public Byte[] getWByteLob() {
        return wByteLob;
    }

    public void setWByteLob(Byte[] byteLob) {
        wByteLob = byteLob;
    }

    public Character getWCharacterField() {
        return wCharacterField;
    }

    public void setWCharacterField(Character characterField) {
        wCharacterField = characterField;
    }

    public Character[] getWCharacterLob() {
        return wCharacterLob;
    }

    public void setWCharacterLob(Character[] characterLob) {
        wCharacterLob = characterLob;
    }

    public Double getWDoubleField() {
        return wDoubleField;
    }

    public void setWDoubleField(Double doubleField) {
        wDoubleField = doubleField;
    }

    public Float getWFloatField() {
        return wFloatField;
    }

    public void setWFloatField(Float floatField) {
        wFloatField = floatField;
    }

    public Integer getWIntegerField() {
        return wIntegerField;
    }

    public void setWIntegerField(Integer integerField) {
        wIntegerField = integerField;
    }

    public Long getWLongField() {
        return wLongField;
    }

    public void setWLongField(Long longField) {
        wLongField = longField;
    }

    public Short getWShortField() {
        return wShortField;
    }

    public void setWShortField(Short shortField) {
        wShortField = shortField;
    }

    public DelimitedIdentifiersAllFieldTypesEntity getSelfOneOne() {
        return selfOneOne;
    }

    public void setSelfOneOne(DelimitedIdentifiersAllFieldTypesEntity selfOneOne) {
        this.selfOneOne = selfOneOne;
    }

    public List<DelimitedIdentifiersAllFieldTypesEntity> getSelfOneMany() {
        return selfOneMany;
    }

    public void setSelfOneMany(List<DelimitedIdentifiersAllFieldTypesEntity> selfOneMany) {
        this.selfOneMany = selfOneMany;
    }

    public LocalDate getLocalDateField() {
        return localDateField;
    }

    public void setLocalDateField(LocalDate localDateField) {
        this.localDateField = localDateField;
    }

    public LocalTime getLocalTimeField() {
        return localTimeField;
    }

    public void setLocalTimeField(LocalTime localTimeField) {
        this.localTimeField = localTimeField;
    }

    public LocalDateTime getLocalDateTimeField() {
        return localDateTimeField;
    }

    public void setLocalDateTimeField(LocalDateTime localDateTimeField) {
        this.localDateTimeField = localDateTimeField;
    }

    public OffsetTime getOffsetTimeField() {
        return offsetTimeField;
    }

    public void setOffsetTimeField(OffsetTime offsetTimeField) {
        this.offsetTimeField = offsetTimeField;
    }

    public OffsetDateTime getOffsetDateTimeField() {
        return offsetDateTimeField;
    }

    public void setOffsetDateTimeField(OffsetDateTime offsetDateTimeField) {
        this.offsetDateTimeField = offsetDateTimeField;
    }
}
