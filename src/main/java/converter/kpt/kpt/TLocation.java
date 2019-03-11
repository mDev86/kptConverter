//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.02.22 at 11:45:16 AM YEKT 
//


package converter.kpt.kpt;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Уточнение местоположения и адрес (описание местоположения) земельного участка
 * 
 * <p>Java class for tLocation complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tLocation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="inBounds" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/2.0.1}sInBounds" minOccurs="0"/&gt;
 *         &lt;element name="Placed" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s6" minOccurs="0"/&gt;
 *         &lt;element name="Elaboration" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tElaborationLocation" minOccurs="0"/&gt;
 *         &lt;element name="Address" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/address-output/4.0.1}tAddressOut" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tLocation", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1", propOrder = {
    "inBounds",
    "placed",
    "elaboration",
    "address"
})
public class TLocation {

    protected String inBounds;
    @XmlElement(name = "Placed")
    protected String placed;
    @XmlElement(name = "Elaboration")
    protected TElaborationLocation elaboration;
    @XmlElement(name = "Address")
    protected TAddressOut address;

    /**
     * Gets the value of the inBounds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInBounds() {
        return inBounds;
    }

    /**
     * Sets the value of the inBounds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInBounds(String value) {
        this.inBounds = value;
    }

    /**
     * Gets the value of the placed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaced() {
        return placed;
    }

    /**
     * Sets the value of the placed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaced(String value) {
        this.placed = value;
    }

    /**
     * Gets the value of the elaboration property.
     * 
     * @return
     *     possible object is
     *     {@link TElaborationLocation }
     *     
     */
    public TElaborationLocation getElaboration() {
        return elaboration;
    }

    /**
     * Sets the value of the elaboration property.
     * 
     * @param value
     *     allowed object is
     *     {@link TElaborationLocation }
     *     
     */
    public void setElaboration(TElaborationLocation value) {
        this.elaboration = value;
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

}
