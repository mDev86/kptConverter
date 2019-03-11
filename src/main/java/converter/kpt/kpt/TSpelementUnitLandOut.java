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
 * Часть элемента (точка)
 * 
 * <p>Java class for tSpelementUnitLandOut complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tSpelementUnitLandOut"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Ordinate"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1}tOrdinateOut"&gt;
 *                 &lt;attribute name="GeopointOpred" type="{urn://x-artefacts-rosreestr-ru/commons/directories/geopoint-opred/1.0.1}dGeopointOpred" /&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="TypeUnit" use="required"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}sType_Unit"&gt;
 *             &lt;pattern value="Точка"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="SuNmb" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}p22" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSpelementUnitLandOut", propOrder = {
    "ordinate"
})
public class TSpelementUnitLandOut {

    @XmlElement(name = "Ordinate", required = true)
    protected TSpelementUnitLandOut.Ordinate ordinate;
    @XmlAttribute(name = "TypeUnit", required = true)
    protected STypeUnit typeUnit;
    @XmlAttribute(name = "SuNmb")
    protected BigInteger suNmb;

    /**
     * Gets the value of the ordinate property.
     *
     * @return
     *     possible object is
     *     {@link TSpelementUnitLandOut.Ordinate }
     *
     */
    public TSpelementUnitLandOut.Ordinate getOrdinate() {
        return ordinate;
    }

    /**
     * Sets the value of the ordinate property.
     *
     * @param value
     *     allowed object is
     *     {@link TSpelementUnitLandOut.Ordinate }
     *
     */
    public void setOrdinate(TSpelementUnitLandOut.Ordinate value) {
        this.ordinate = value;
    }

    /**
     * Gets the value of the typeUnit property.
     * 
     * @return
     *     possible object is
     *     {@link STypeUnit }
     *     
     */
    public STypeUnit getTypeUnit() {
        return typeUnit;
    }

    /**
     * Sets the value of the typeUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link STypeUnit }
     *     
     */
    public void setTypeUnit(STypeUnit value) {
        this.typeUnit = value;
    }

    /**
     * Gets the value of the suNmb property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSuNmb() {
        return suNmb;
    }

    /**
     * Sets the value of the suNmb property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSuNmb(BigInteger value) {
        this.suNmb = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected         content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1}tOrdinateOut"&gt;
     *       &lt;attribute name="GeopointOpred" type="{urn://x-artefacts-rosreestr-ru/commons/directories/geopoint-opred/1.0.1}dGeopointOpred" /&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Ordinate
        extends TOrdinateOut
    {

        @XmlAttribute(name = "GeopointOpred")
        protected String geopointOpred;

        /**
         * Gets the value of the geopointOpred property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGeopointOpred() {
            return geopointOpred;
        }

        /**
         * Sets the value of the geopointOpred property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGeopointOpred(String value) {
            this.geopointOpred = value;
        }

    }

}
