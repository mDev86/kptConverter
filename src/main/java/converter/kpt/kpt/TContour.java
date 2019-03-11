//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.02.22 at 11:45:16 AM YEKT 
//


package converter.kpt.kpt;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * Описание контура участка
 * 
 * <p>Java class for tContour complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tContour"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EntitySpatial" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1}tEntitySpatialZUOut" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="NumberRecord" use="required" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}p10" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tContour", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1", propOrder = {
    "entitySpatial"
})
public class TContour {

    @XmlElement(name = "EntitySpatial")
    protected TEntitySpatialZUOut entitySpatial;
    @XmlAttribute(name = "NumberRecord", required = true)
    protected BigInteger numberRecord;

    /**
     * Gets the value of the entitySpatial property.
     * 
     * @return
     *     possible object is
     *     {@link TEntitySpatialZUOut }
     *     
     */
    public TEntitySpatialZUOut getEntitySpatial() {
        return entitySpatial;
    }

    /**
     * Sets the value of the entitySpatial property.
     * 
     * @param value
     *     allowed object is
     *     {@link TEntitySpatialZUOut }
     *     
     */
    public void setEntitySpatial(TEntitySpatialZUOut value) {
        this.entitySpatial = value;
    }

    /**
     * Gets the value of the numberRecord property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberRecord() {
        return numberRecord;
    }

    /**
     * Sets the value of the numberRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberRecord(BigInteger value) {
        this.numberRecord = value;
    }

}