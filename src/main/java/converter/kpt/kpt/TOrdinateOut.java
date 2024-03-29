//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.02.22 at 11:45:16 AM YEKT 
//


package converter.kpt.kpt;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * Координата
 * 
 * <p>Java class for tOrdinateOut complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tOrdinateOut"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="X" use="required" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}d38_2" /&gt;
 *       &lt;attribute name="Y" use="required" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}d38_2" /&gt;
 *       &lt;attribute name="OrdNmb" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}p22" /&gt;
 *       &lt;attribute name="NumGeopoint" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}p22" /&gt;
 *       &lt;attribute name="DeltaGeopoint" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}d20_2" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tOrdinateOut")
@XmlSeeAlso({
        converter.kpt.kpt.TSpelementUnitZUOut.Ordinate.class,
        converter.kpt.kpt.TSpelementUnitOKSOut.Ordinate.class,
        converter.kpt.kpt.TSpelementUnitLandOut.Ordinate.class,
        converter.kpt.kpt.TSpelementUnitLandKVOut.Ordinate.class
})
public class TOrdinateOut {

    @XmlAttribute(name = "X", required = true)
    protected BigDecimal x;
    @XmlAttribute(name = "Y", required = true)
    protected BigDecimal y;
    @XmlAttribute(name = "OrdNmb")
    protected BigInteger ordNmb;
    @XmlAttribute(name = "NumGeopoint")
    protected BigInteger numGeopoint;
    @XmlAttribute(name = "DeltaGeopoint")
    protected BigDecimal deltaGeopoint;

    /**
     * Gets the value of the x property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setX(BigDecimal value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setY(BigDecimal value) {
        this.y = value;
    }

    /**
     * Gets the value of the ordNmb property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrdNmb() {
        return ordNmb;
    }

    /**
     * Sets the value of the ordNmb property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrdNmb(BigInteger value) {
        this.ordNmb = value;
    }

    /**
     * Gets the value of the numGeopoint property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumGeopoint() {
        return numGeopoint;
    }

    /**
     * Sets the value of the numGeopoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumGeopoint(BigInteger value) {
        this.numGeopoint = value;
    }

    /**
     * Gets the value of the deltaGeopoint property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDeltaGeopoint() {
        return deltaGeopoint;
    }

    /**
     * Sets the value of the deltaGeopoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDeltaGeopoint(BigDecimal value) {
        this.deltaGeopoint = value;
    }

}
