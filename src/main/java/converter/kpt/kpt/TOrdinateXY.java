//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.02.22 at 11:45:16 AM YEKT 
//


package converter.kpt.kpt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.math.BigInteger;


/**
 * Координата (X, Y)
 * 
 * <p>Java class for tOrdinateXY complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tOrdinateXY"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="X" use="required" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}d38_2" /&gt;
 *       &lt;attribute name="Y" use="required" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}d38_2" /&gt;
 *       &lt;attribute name="NumGeopoint" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}p22" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tOrdinateXY")
public class TOrdinateXY {

    @XmlAttribute(name = "X", required = true)
    protected BigDecimal x;
    @XmlAttribute(name = "Y", required = true)
    protected BigDecimal y;
    @XmlAttribute(name = "NumGeopoint")
    protected BigInteger numGeopoint;

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

}
