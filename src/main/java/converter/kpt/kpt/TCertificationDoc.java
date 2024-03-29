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
 * Сведения об удостоверении документа
 * 
 * <p>Java class for tCertificationDoc complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCertificationDoc"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Organization" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s500"/&gt;
 *         &lt;element name="Date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="Number" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s100"/&gt;
 *         &lt;element name="Official" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Appointment" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s1_255"/&gt;
 *                   &lt;group ref="{urn://x-artefacts-smev-gov-ru/supplementary/commons/1.0.1}PhysicalPersonQualifiedName-ModelGroup"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCertificationDoc", namespace = "urn://x-artefacts-rosreestr-ru/commons/complex-types/certification-doc/1.0", propOrder = {
    "organization",
    "date",
    "number",
    "official"
})
public class TCertificationDoc {

    @XmlElement(name = "Organization", required = true)
    protected String organization;
    @XmlElement(name = "Date", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    @XmlElement(name = "Number", required = true)
    protected String number;
    @XmlElement(name = "Official")
    protected TCertificationDoc.Official official;

    /**
     * Gets the value of the organization property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * Sets the value of the organization property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOrganization(String value) {
        this.organization = value;
    }

    /**
     * Gets the value of the date property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the number property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumber(String value) {
        this.number = value;
    }

    /**
     * Gets the value of the official property.
     *
     * @return
     *     possible object is
     *     {@link TCertificationDoc.Official }
     *
     */
    public TCertificationDoc.Official getOfficial() {
        return official;
    }

    /**
     * Sets the value of the official property.
     *
     * @param value
     *     allowed object is
     *     {@link TCertificationDoc.Official }
     *
     */
    public void setOfficial(TCertificationDoc.Official value) {
        this.official = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected         content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Appointment" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s1_255"/&gt;
     *         &lt;group ref="{urn://x-artefacts-smev-gov-ru/supplementary/commons/1.0.1}PhysicalPersonQualifiedName-ModelGroup"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "appointment",
        "familyName",
        "firstName",
        "patronymic"
    })
    public static class Official {

        @XmlElement(name = "Appointment", namespace = "urn://x-artefacts-rosreestr-ru/commons/complex-types/certification-doc/1.0", required = true)
        protected String appointment;
        @XmlElement(name = "FamilyName", namespace = "urn://x-artefacts-smev-gov-ru/supplementary/commons/1.0.1", required = true)
        protected String familyName;
        @XmlElement(name = "FirstName", namespace = "urn://x-artefacts-smev-gov-ru/supplementary/commons/1.0.1", required = true)
        protected String firstName;
        @XmlElement(name = "Patronymic", namespace = "urn://x-artefacts-smev-gov-ru/supplementary/commons/1.0.1")
        protected String patronymic;

        /**
         * Gets the value of the appointment property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAppointment() {
            return appointment;
        }

        /**
         * Sets the value of the appointment property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAppointment(String value) {
            this.appointment = value;
        }

        /**
         * Gets the value of the familyName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFamilyName() {
            return familyName;
        }

        /**
         * Sets the value of the familyName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFamilyName(String value) {
            this.familyName = value;
        }

        /**
         * Gets the value of the firstName property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * Sets the value of the firstName property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFirstName(String value) {
            this.firstName = value;
        }

        /**
         * Gets the value of the patronymic property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPatronymic() {
            return patronymic;
        }

        /**
         * Sets the value of the patronymic property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPatronymic(String value) {
            this.patronymic = value;
        }

    }

}
