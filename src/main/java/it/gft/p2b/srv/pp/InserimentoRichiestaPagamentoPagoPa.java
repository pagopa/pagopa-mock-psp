//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.01.26 at 09:55:13 AM CET 
//


package it.gft.p2b.srv.pp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for inserimentoRichiestaPagamentoPagoPa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="inserimentoRichiestaPagamentoPagoPa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://p2b.gft.it/srv/pp}requestInserimentoRichiestaPagamentoPagoPaVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "inserimentoRichiestaPagamentoPagoPa", propOrder = {
    "arg0"
})
public class InserimentoRichiestaPagamentoPagoPa {

    protected RequestInserimentoRichiestaPagamentoPagoPaVO arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link RequestInserimentoRichiestaPagamentoPagoPaVO }
     *     
     */
    public RequestInserimentoRichiestaPagamentoPagoPaVO getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestInserimentoRichiestaPagamentoPagoPaVO }
     *     
     */
    public void setArg0(RequestInserimentoRichiestaPagamentoPagoPaVO value) {
        this.arg0 = value;
    }

}
