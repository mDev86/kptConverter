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
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CadastralBlocks" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="CadastralBlock" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tCadastralBlock" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="CertificationDoc" type="{urn://x-artefacts-rosreestr-ru/commons/complex-types/certification-doc/1.0}tCertificationDoc"/&gt;
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
    "cadastralBlocks",
    "certificationDoc"
})
@XmlRootElement(name = "KPT", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1")
public class KPT {

    @XmlElement(name = "CadastralBlocks", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1")
    protected KPT.CadastralBlocks cadastralBlocks;
    @XmlElement(name = "CertificationDoc", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1", required = true)
    protected TCertificationDoc certificationDoc;

    /**
     * Gets the value of the cadastralBlocks property.
     *
     * @return
     *     possible object is
     *     {@link KPT.CadastralBlocks }
     *
     */
    public KPT.CadastralBlocks getCadastralBlocks() {
        return cadastralBlocks;
    }

    /**
     * Sets the value of the cadastralBlocks property.
     *
     * @param value
     *     allowed object is
     *     {@link KPT.CadastralBlocks }
     *
     */
    public void setCadastralBlocks(KPT.CadastralBlocks value) {
        this.cadastralBlocks = value;
    }

    /**
     * Gets the value of the certificationDoc property.
     * 
     * @return
     *     possible object is
     *     {@link TCertificationDoc }
     *     
     */
    public TCertificationDoc getCertificationDoc() {
        return certificationDoc;
    }

    /**
     * Sets the value of the certificationDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link TCertificationDoc }
     *     
     */
    public void setCertificationDoc(TCertificationDoc value) {
        this.certificationDoc = value;
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
     *         &lt;element name="CadastralBlock" type="{urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1}tCadastralBlock" maxOccurs="unbounded"/&gt;
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
        "cadastralBlock"
    })
    public static class CadastralBlocks {

        @XmlElement(name = "CadastralBlock", namespace = "urn://x-artefacts-rosreestr-ru/outgoing/kpt/10.0.1", required = true)
        protected List<TCadastralBlock> cadastralBlock;

        /**
         * Gets the value of the cadastralBlock property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the cadastralBlock property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCadastralBlock().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TCadastralBlock }
         * 
         * 
         */
        public List<TCadastralBlock> getCadastralBlock() {
            if (cadastralBlock == null) {
                cadastralBlock = new ArrayList<TCadastralBlock>();
            }
            return this.cadastralBlock;
        }

    }

}
