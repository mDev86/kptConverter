//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1-b171012.0423 
//         See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
//         Any modifications to this file will be lost upon recompilation of the source schema. 
//         Generated on: 2019.02.22 at 11:45:16 AM YEKT 
//


package converter.kpt.kpt;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Описание элементов контура (характерных точек контура) здания, сооружения, объекта незавершенного строительства (и их частей)
 * 
 * <p>Java class for tEntitySpatialOKSOut complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tEntitySpatialOKSOut"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SpatialElement" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;extension base="{urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1}tSpatialElementOKSOut"&gt;
 *                 &lt;attribute name="Number" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s255" /&gt;
 *                 &lt;attribute name="Underground"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *                       &lt;enumeration value="0"/&gt;
 *                       &lt;enumeration value="1"/&gt;
 *                       &lt;enumeration value="2"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *               &lt;/extension&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="EntSys" use="required" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}sIDREF255" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tEntitySpatialOKSOut", propOrder = {
    "spatialElement"
})
public class TEntitySpatialOKSOut {

    @XmlElement(name = "SpatialElement", required = true)
    protected List<SpatialElement> spatialElement;
    @XmlAttribute(name = "EntSys", required = true)
    @XmlIDREF
    protected Object entSys;

    /**
     * Gets the value of the spatialElement property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the spatialElement property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSpatialElement().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TEntitySpatialOKSOut.SpatialElement }
     *
     *
     */
    public List<SpatialElement> getSpatialElement() {
        if (spatialElement == null) {
            spatialElement = new ArrayList<SpatialElement>();
        }
        return this.spatialElement;
    }

    /**
     * Gets the value of the entSys property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getEntSys() {
        return entSys;
    }

    /**
     * Sets the value of the entSys property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setEntSys(Object value) {
        this.entSys = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected         content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;extension base="{urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1}tSpatialElementOKSOut"&gt;
     *       &lt;attribute name="Number" type="{urn://x-artefacts-rosreestr-ru/commons/simple-types/1.0}s255" /&gt;
     *       &lt;attribute name="Underground"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
     *             &lt;enumeration value="0"/&gt;
     *             &lt;enumeration value="1"/&gt;
     *             &lt;enumeration value="2"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *     &lt;/extension&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class SpatialElement
        extends TSpatialElementOKSOut
    {

        @XmlAttribute(name = "Number")
        protected String number;
        @XmlAttribute(name = "Underground")
        protected String underground;

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
         * Gets the value of the underground property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnderground() {
            return underground;
        }

        /**
         * Sets the value of the underground property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnderground(String value) {
            this.underground = value;
        }

    }

}
