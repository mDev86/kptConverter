//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.02.22 at 11:45:16 AM YEKT 
//


package converter.kpt.kpt;

import javax.xml.bind.annotation.*;


/**
 * Разрешенное использование
 * 
 * <p>Java class for tPermittedUse complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPermittedUse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TypePermittedUse" type="{urn://x-artefacts-rosreestr-ru/commons/directories/permit-use/1.0.1}dPermitUse"/&gt;
 *         &lt;element name="LandUse" type="{urn://x-artefacts-rosreestr-ru/commons/directories/allowed-use/2.0.1}dAllowedUse" minOccurs="0"/&gt;
 *         &lt;element name="Utilization" type="{urn://x-artefacts-rosreestr-ru/commons/directories/utilizations/1.0.1}dUtilizations" minOccurs="0"/&gt;
 *         &lt;element name="PermittedUse" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s4000"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPermittedUse", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1", propOrder = {
    "typePermittedUse",
    "landUse",
    "utilization",
    "permittedUse"
})
@XmlSeeAlso({
    TPermittedUseAll.class
})
public class TPermittedUse {

    @XmlElement(name = "TypePermittedUse", required = true)
    protected String typePermittedUse;
    @XmlElement(name = "LandUse")
    protected String landUse;
    @XmlElement(name = "Utilization")
    protected String utilization;
    @XmlElement(name = "PermittedUse", required = true)
    protected String permittedUse;

    /**
     * Gets the value of the typePermittedUse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypePermittedUse() {
        return typePermittedUse;
    }

    /**
     * Sets the value of the typePermittedUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypePermittedUse(String value) {
        this.typePermittedUse = value;
    }

    /**
     * Gets the value of the landUse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLandUse() {
        return landUse;
    }

    /**
     * Sets the value of the landUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLandUse(String value) {
        this.landUse = value;
    }

    /**
     * Gets the value of the utilization property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUtilization() {
        return utilization;
    }

    /**
     * Sets the value of the utilization property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUtilization(String value) {
        this.utilization = value;
    }

    /**
     * Gets the value of the permittedUse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermittedUse() {
        return permittedUse;
    }

    /**
     * Sets the value of the permittedUse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermittedUse(String value) {
        this.permittedUse = value;
    }

}
