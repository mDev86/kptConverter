//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.02.22 at 11:45:16 AM YEKT 
//


package converter.kpt.kpt;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Кадастровая стоимость, реквизиты акта и даты
 * 
 * <p>Java class for tCadastralCostExt complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCadastralCostExt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn://x-artefacts-rosreestr-ru/commons/complex-types/cadastral-cost/1.0}tCadastralCost"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="DateValuation" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="DateEntering" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="DateApproval" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="DocNumber" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s45" minOccurs="0"/&gt;
 *         &lt;element name="DocDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCadastralCostExt", namespace = "urn://x-artefacts-rosreestr-ru/commons/complex-types/cadastral-cost/1.0", propOrder = {
    "dateValuation",
    "dateEntering",
    "dateApproval",
    "docNumber",
    "docDate"
})
public class TCadastralCostExt
    extends TCadastralCost
{

    @XmlElement(name = "DateValuation")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateValuation;
    @XmlElement(name = "DateEntering")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateEntering;
    @XmlElement(name = "DateApproval")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateApproval;
    @XmlElement(name = "DocNumber")
    protected String docNumber;
    @XmlElement(name = "DocDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar docDate;

    /**
     * Gets the value of the dateValuation property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateValuation() {
        return dateValuation;
    }

    /**
     * Sets the value of the dateValuation property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateValuation(XMLGregorianCalendar value) {
        this.dateValuation = value;
    }

    /**
     * Gets the value of the dateEntering property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateEntering() {
        return dateEntering;
    }

    /**
     * Sets the value of the dateEntering property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateEntering(XMLGregorianCalendar value) {
        this.dateEntering = value;
    }

    /**
     * Gets the value of the dateApproval property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateApproval() {
        return dateApproval;
    }

    /**
     * Sets the value of the dateApproval property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateApproval(XMLGregorianCalendar value) {
        this.dateApproval = value;
    }

    /**
     * Gets the value of the docNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocNumber() {
        return docNumber;
    }

    /**
     * Sets the value of the docNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocNumber(String value) {
        this.docNumber = value;
    }

    /**
     * Gets the value of the docDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDocDate() {
        return docDate;
    }

    /**
     * Sets the value of the docDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDocDate(XMLGregorianCalendar value) {
        this.docDate = value;
    }

}