//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.02.22 at 11:45:16 AM YEKT 
//


package converter.kpt.kpt;

import javax.xml.bind.annotation.*;


/**
 * Часть элемента (точка)
 * 
 * <p>Java class for tSpelementUnitZUInp complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tSpelementUnitZUInp"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Ordinate"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1}tOrdinateInp"&gt;
 *                 &lt;attribute name="GeopointZacrep" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/2.0.1}s120" /&gt;
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
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tSpelementUnitZUInp", propOrder = {
    "ordinate"
})
public class TSpelementUnitZUInp {

    @XmlElement(name = "Ordinate", required = true)
    protected TSpelementUnitZUInp.Ordinate ordinate;
    @XmlAttribute(name = "TypeUnit", required = true)
    protected STypeUnit typeUnit;

    /**
     * Gets the value of the ordinate property.
     *
     * @return
     *     possible object is
     *     {@link TSpelementUnitZUInp.Ordinate }
     *
     */
    public TSpelementUnitZUInp.Ordinate getOrdinate() {
        return ordinate;
    }

    /**
     * Sets the value of the ordinate property.
     *
     * @param value
     *     allowed object is
     *     {@link TSpelementUnitZUInp.Ordinate }
     *
     */
    public void setOrdinate(TSpelementUnitZUInp.Ordinate value) {
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected         content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1}tOrdinateInp"&gt;
     *       &lt;attribute name="GeopointZacrep" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/2.0.1}s120" /&gt;
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
        extends TOrdinateInp
    {

        @XmlAttribute(name = "GeopointZacrep")
        protected String geopointZacrep;

        /**
         * Gets the value of the geopointZacrep property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getGeopointZacrep() {
            return geopointZacrep;
        }

        /**
         * Sets the value of the geopointZacrep property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setGeopointZacrep(String value) {
            this.geopointZacrep = value;
        }

    }

}
