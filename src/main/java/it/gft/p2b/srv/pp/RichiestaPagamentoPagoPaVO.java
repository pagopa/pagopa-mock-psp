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
 * <p>Java class for richiestaPagamentoPagoPaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="richiestaPagamentoPagoPaVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://p2b.gft.it/srv/pp}richiestaPagamentoOnlineVO">
 *       &lt;sequence>
 *         &lt;element name="numeroTelefonicoCriptato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPSP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idPagoPa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "richiestaPagamentoPagoPaVO", propOrder = {
    "numeroTelefonicoCriptato",
    "idPSP",
    "idPagoPa"
})
public class RichiestaPagamentoPagoPaVO
    extends RichiestaPagamentoOnlineVO
{

    protected String numeroTelefonicoCriptato;
    protected String idPSP;
    protected String idPagoPa;

    /**
     * Gets the value of the numeroTelefonicoCriptato property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroTelefonicoCriptato() {
        return numeroTelefonicoCriptato;
    }

    /**
     * Sets the value of the numeroTelefonicoCriptato property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroTelefonicoCriptato(String value) {
        this.numeroTelefonicoCriptato = value;
    }

    /**
     * Gets the value of the idPSP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPSP() {
        return idPSP;
    }

    /**
     * Sets the value of the idPSP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPSP(String value) {
        this.idPSP = value;
    }

    /**
     * Gets the value of the idPagoPa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPagoPa() {
        return idPagoPa;
    }

    /**
     * Sets the value of the idPagoPa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPagoPa(String value) {
        this.idPagoPa = value;
    }

}