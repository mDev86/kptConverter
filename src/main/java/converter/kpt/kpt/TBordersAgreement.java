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
 * Сведения о частях границ (от точки до точки) и отметка о наличии земельного спора
 * 
 * <p>Java class for tBordersAgreement complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tBordersAgreement"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Border" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/entity-spatial/5.0.1}tBorderAgreement" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tBordersAgreement", propOrder = {
    "border"
})
public class TBordersAgreement {

    @XmlElement(name = "Border", required = true)
    protected List<TBorderAgreement> border;

    /**
     * Gets the value of the border property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the border property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBorder().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TBorderAgreement }
     * 
     * 
     */
    public List<TBorderAgreement> getBorder() {
        if (border == null) {
            border = new ArrayList<TBorderAgreement>();
        }
        return this.border;
    }

}
