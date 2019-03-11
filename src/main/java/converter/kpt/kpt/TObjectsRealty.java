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
import java.util.ArrayList;
import java.util.List;


/**
 * Сведения о зданиях, сооружениях, объектах незавершенного строительства
 * 
 * <p>Java class for tObjectsRealty complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tObjectsRealty"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ObjectRealty" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;choice&gt;
 *                   &lt;element name="Building" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tBuilding"/&gt;
 *                   &lt;element name="Construction"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;extension base="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tConstruction"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="ConditionalPartLinear" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tConditionalPartLinear" minOccurs="0"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Uncompleted" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tUncompleted"/&gt;
 *                 &lt;/choice&gt;
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
@XmlType(name = "tObjectsRealty", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1", propOrder = {
    "objectRealty"
})
public class TObjectsRealty {

    @XmlElement(name = "ObjectRealty", required = true)
    protected List<ObjectRealty> objectRealty;

    /**
     * Gets the value of the objectRealty property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectRealty property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectRealty().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TObjectsRealty.ObjectRealty }
     *
     *
     */
    public List<ObjectRealty> getObjectRealty() {
        if (objectRealty == null) {
            objectRealty = new ArrayList<ObjectRealty>();
        }
        return this.objectRealty;
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
     *       &lt;choice&gt;
     *         &lt;element name="Building" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tBuilding"/&gt;
     *         &lt;element name="Construction"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;extension base="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tConstruction"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="ConditionalPartLinear" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tConditionalPartLinear" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/extension&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Uncompleted" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tUncompleted"/&gt;
     *       &lt;/choice&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "building",
        "construction",
        "uncompleted"
    })
    public static class ObjectRealty {

        @XmlElement(name = "Building", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1")
        protected TBuilding building;
        @XmlElement(name = "Construction", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1")
        protected TObjectsRealty.ObjectRealty.Construction construction;
        @XmlElement(name = "Uncompleted", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1")
        protected TUncompleted uncompleted;

        /**
         * Gets the value of the building property.
         *
         * @return
         *     possible object is
         *     {@link TBuilding }
         *
         */
        public TBuilding getBuilding() {
            return building;
        }

        /**
         * Sets the value of the building property.
         *
         * @param value
         *     allowed object is
         *     {@link TBuilding }
         *
         */
        public void setBuilding(TBuilding value) {
            this.building = value;
        }

        /**
         * Gets the value of the construction property.
         *
         * @return
         *     possible object is
         *     {@link TObjectsRealty.ObjectRealty.Construction }
         *
         */
        public TObjectsRealty.ObjectRealty.Construction getConstruction() {
            return construction;
        }

        /**
         * Sets the value of the construction property.
         *
         * @param value
         *     allowed object is
         *     {@link TObjectsRealty.ObjectRealty.Construction }
         *
         */
        public void setConstruction(TObjectsRealty.ObjectRealty.Construction value) {
            this.construction = value;
        }

        /**
         * Gets the value of the uncompleted property.
         * 
         * @return
         *     possible object is
         *     {@link TUncompleted }
         *     
         */
        public TUncompleted getUncompleted() {
            return uncompleted;
        }

        /**
         * Sets the value of the uncompleted property.
         * 
         * @param value
         *     allowed object is
         *     {@link TUncompleted }
         *     
         */
        public void setUncompleted(TUncompleted value) {
            this.uncompleted = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected         content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;extension base="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tConstruction"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="ConditionalPartLinear" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tConditionalPartLinear" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *     &lt;/extension&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "conditionalPartLinear"
        })
        public static class Construction
            extends TConstruction
        {

            @XmlElement(name = "ConditionalPartLinear", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1")
            protected TConditionalPartLinear conditionalPartLinear;

            /**
             * Gets the value of the conditionalPartLinear property.
             * 
             * @return
             *     possible object is
             *     {@link TConditionalPartLinear }
             *     
             */
            public TConditionalPartLinear getConditionalPartLinear() {
                return conditionalPartLinear;
            }

            /**
             * Sets the value of the conditionalPartLinear property.
             * 
             * @param value
             *     allowed object is
             *     {@link TConditionalPartLinear }
             *     
             */
            public void setConditionalPartLinear(TConditionalPartLinear value) {
                this.conditionalPartLinear = value;
            }

        }

    }

}