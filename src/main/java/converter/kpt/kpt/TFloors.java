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


/**
 * Количество этажей
 * 
 * <p>Java class for tFloors complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tFloors"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="Floors" use="required" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/4.1.1}sNe200" /&gt;
 *       &lt;attribute name="UndergroundFloors" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s200" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tFloors", namespace = "urn://x-artefacts-rosreestr-ru/commons/complex-types/parameters-oks/2.0.1")
public class TFloors {

    @XmlAttribute(name = "Floors", required = true)
    protected String floors;
    @XmlAttribute(name = "UndergroundFloors")
    protected String undergroundFloors;

    /**
     * Gets the value of the floors property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFloors() {
        return floors;
    }

    /**
     * Sets the value of the floors property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFloors(String value) {
        this.floors = value;
    }

    /**
     * Gets the value of the undergroundFloors property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUndergroundFloors() {
        return undergroundFloors;
    }

    /**
     * Sets the value of the undergroundFloors property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUndergroundFloors(String value) {
        this.undergroundFloors = value;
    }

}