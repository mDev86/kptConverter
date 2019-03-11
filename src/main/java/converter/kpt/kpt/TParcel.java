//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.02.22 at 11:45:16 AM YEKT 
//


package converter.kpt.kpt;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * Описание земельного участка
 * 
 * <p>Java class for tParcel complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tParcel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Area" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tAreaOut"/&gt;
 *         &lt;element name="Name" type="{urn://x-artefacts-rosreestr-ru/commons/directories/parcels/1.0.1}dParcels"/&gt;
 *         &lt;element name="Location" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tLocation"/&gt;
 *         &lt;element name="Category" type="{urn://x-artefacts-rosreestr-ru/commons/directories/categories/1.0.1}dCategories"/&gt;
 *         &lt;element name="Utilization" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tUtilization"/&gt;
 *         &lt;element name="ParentCadastralNumbers" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tLandUnit" minOccurs="0"/&gt;
 *         &lt;element name="Contours" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Contour" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tContour" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CadastralCost" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/cadastral-cost/1.0}tCadastralCost" minOccurs="0"/&gt;
 *         &lt;element name="EntitySpatial" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1}tEntitySpatialZUOut" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="CadastralNumber" use="required" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s40" /&gt;
 *       &lt;attribute name="State" use="required" type="{urn://x-artefacts-rosreestr-ru/commons/directories/states/1.0.1}dStates" /&gt;
 *       &lt;attribute name="DateCreated" type="{http://www.w3.org/2001/XMLSchema}date" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tParcel", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1", propOrder = {
    "area",
    "name",
    "location",
    "category",
    "utilization",
    "parentCadastralNumbers",
    "contours",
    "cadastralCost",
    "entitySpatial"
})
public class TParcel {

    @XmlElement(name = "Area", required = true)
    protected TAreaOut area;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Location", required = true)
    protected TLocation location;
    @XmlElement(name = "Category", required = true)
    protected String category;
    @XmlElement(name = "Utilization", required = true)
    protected TUtilization utilization;
    @XmlElement(name = "ParentCadastralNumbers")
    protected TLandUnit parentCadastralNumbers;
    @XmlElement(name = "Contours")
    protected TParcel.Contours contours;
    @XmlElement(name = "CadastralCost")
    protected TCadastralCost cadastralCost;
    @XmlElement(name = "EntitySpatial")
    protected TEntitySpatialZUOut entitySpatial;
    @XmlAttribute(name = "CadastralNumber", required = true)
    protected String cadastralNumber;
    @XmlAttribute(name = "State", required = true)
    protected String state;
    @XmlAttribute(name = "DateCreated")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateCreated;

    /**
     * Gets the value of the area property.
     *
     * @return
     *     possible object is
     *     {@link TAreaOut }
     *
     */
    public TAreaOut getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     *
     * @param value
     *     allowed object is
     *     {@link TAreaOut }
     *
     */
    public void setArea(TAreaOut value) {
        this.area = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the location property.
     *
     * @return
     *     possible object is
     *     {@link TLocation }
     *
     */
    public TLocation getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     *
     * @param value
     *     allowed object is
     *     {@link TLocation }
     *
     */
    public void setLocation(TLocation value) {
        this.location = value;
    }

    /**
     * Gets the value of the category property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the utilization property.
     *
     * @return
     *     possible object is
     *     {@link TUtilization }
     *
     */
    public TUtilization getUtilization() {
        return utilization;
    }

    /**
     * Sets the value of the utilization property.
     *
     * @param value
     *     allowed object is
     *     {@link TUtilization }
     *
     */
    public void setUtilization(TUtilization value) {
        this.utilization = value;
    }

    /**
     * Gets the value of the parentCadastralNumbers property.
     *
     * @return
     *     possible object is
     *     {@link TLandUnit }
     *
     */
    public TLandUnit getParentCadastralNumbers() {
        return parentCadastralNumbers;
    }

    /**
     * Sets the value of the parentCadastralNumbers property.
     *
     * @param value
     *     allowed object is
     *     {@link TLandUnit }
     *
     */
    public void setParentCadastralNumbers(TLandUnit value) {
        this.parentCadastralNumbers = value;
    }

    /**
     * Gets the value of the contours property.
     *
     * @return
     *     possible object is
     *     {@link TParcel.Contours }
     *
     */
    public TParcel.Contours getContours() {
        return contours;
    }

    /**
     * Sets the value of the contours property.
     *
     * @param value
     *     allowed object is
     *     {@link TParcel.Contours }
     *
     */
    public void setContours(TParcel.Contours value) {
        this.contours = value;
    }

    /**
     * Gets the value of the cadastralCost property.
     * 
     * @return
     *     possible object is
     *     {@link TCadastralCost }
     *     
     */
    public TCadastralCost getCadastralCost() {
        return cadastralCost;
    }

    /**
     * Sets the value of the cadastralCost property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCadastralCost }
     *     
     */
    public void setCadastralCost(TCadastralCost value) {
        this.cadastralCost = value;
    }

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
     * Gets the value of the cadastralNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCadastralNumber() {
        return cadastralNumber;
    }

    /**
     * Sets the value of the cadastralNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCadastralNumber(String value) {
        this.cadastralNumber = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the dateCreated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the value of the dateCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreated(XMLGregorianCalendar value) {
        this.dateCreated = value;
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
     *         &lt;element name="Contour" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tContour" maxOccurs="unbounded"/&gt;
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
        "contour"
    })
    public static class Contours {

        @XmlElement(name = "Contour", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1", required = true)
        protected List<TContour> contour;

        /**
         * Gets the value of the contour property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the contour property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContour().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TContour }
         * 
         * 
         */
        public List<TContour> getContour() {
            if (contour == null) {
                contour = new ArrayList<TContour>();
            }
            return this.contour;
        }

    }

}