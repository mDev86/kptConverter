//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.02.22 at 11:45:16 AM YEKT 
//


package converter.kpt.kpt;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;


/**
 * Здание
 * 
 * <p>Java class for tBuilding complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tBuilding"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ObjectType"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{urn://x-artefacts-rosreestr-ru/commons/directories/realty/3.0.1}dRealty"&gt;
 *               &lt;pattern value="002001002000"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="AssignationBuilding" type="{urn://x-artefacts-rosreestr-ru/commons/directories/ass-building/1.0.1}dAssBuilding"/&gt;
 *         &lt;element name="Area" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/2.0.1}d21_1" minOccurs="0"/&gt;
 *         &lt;element name="Address" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}tAddressOut"/&gt;
 *         &lt;element name="CadastralCost" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/cadastral-cost/1.0}tCadastralCost" minOccurs="0"/&gt;
 *         &lt;element name="EntitySpatial" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1}tEntitySpatialOKSOut" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="CadastralNumber" use="required" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s40" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tBuilding", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1", propOrder = {
    "objectType",
    "assignationBuilding",
    "area",
    "address",
    "cadastralCost",
    "entitySpatial"
})
public class TBuilding {

    @XmlElement(name = "ObjectType", required = true)
    protected String objectType;
    @XmlElement(name = "AssignationBuilding", required = true)
    protected String assignationBuilding;
    @XmlElement(name = "Area")
    protected BigDecimal area;
    @XmlElement(name = "Address", required = true)
    protected TAddressOut address;
    @XmlElement(name = "CadastralCost")
    protected TCadastralCost cadastralCost;
    @XmlElement(name = "EntitySpatial")
    protected TEntitySpatialOKSOut entitySpatial;
    @XmlAttribute(name = "CadastralNumber", required = true)
    protected String cadastralNumber;

    /**
     * Gets the value of the objectType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjectType() {
        return objectType;
    }

    /**
     * Sets the value of the objectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjectType(String value) {
        this.objectType = value;
    }

    /**
     * Gets the value of the assignationBuilding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignationBuilding() {
        return assignationBuilding;
    }

    /**
     * Sets the value of the assignationBuilding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignationBuilding(String value) {
        this.assignationBuilding = value;
    }

    /**
     * Gets the value of the area property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setArea(BigDecimal value) {
        this.area = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link TAddressOut }
     *     
     */
    public TAddressOut getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAddressOut }
     *     
     */
    public void setAddress(TAddressOut value) {
        this.address = value;
    }

    /**
     * Gets the value of the cadastralCost property.
     * 
     * @return
     *     possible object is
     *     {@link TCadastralCost }
     *     
     */
    public TCadastralCost getCadastralCost() {
        return cadastralCost;
    }

    /**
     * Sets the value of the cadastralCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCadastralCost }
     *     
     */
    public void setCadastralCost(TCadastralCost value) {
        this.cadastralCost = value;
    }

    /**
     * Gets the value of the entitySpatial property.
     * 
     * @return
     *     possible object is
     *     {@link TEntitySpatialOKSOut }
     *     
     */
    public TEntitySpatialOKSOut getEntitySpatial() {
        return entitySpatial;
    }

    /**
     * Sets the value of the entitySpatial property.
     * 
     * @param value
     *     allowed object is
     *     {@link TEntitySpatialOKSOut }
     *     
     */
    public void setEntitySpatial(TEntitySpatialOKSOut value) {
        this.entitySpatial = value;
    }

    /**
     * Gets the value of the cadastralNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCadastralNumber() {
        return cadastralNumber;
    }

    /**
     * Sets the value of the cadastralNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCadastralNumber(String value) {
        this.cadastralNumber = value;
    }

}
