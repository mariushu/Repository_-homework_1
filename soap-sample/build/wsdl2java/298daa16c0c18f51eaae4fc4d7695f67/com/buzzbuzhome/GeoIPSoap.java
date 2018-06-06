package com.buzzbuzhome;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.4
 * 2018-06-06T09:40:19.633+02:00
 * Generated source version: 3.2.4
 *
 */
@WebService(targetNamespace = "http://buzzbuzhome.com/", name = "GeoIPSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface GeoIPSoap {

    @WebMethod(operationName = "AddLocationHit", action = "http://buzzbuzhome.com/AddLocationHit")
    @RequestWrapper(localName = "AddLocationHit", targetNamespace = "http://buzzbuzhome.com/", className = "com.buzzbuzhome.AddLocationHit")
    @ResponseWrapper(localName = "AddLocationHitResponse", targetNamespace = "http://buzzbuzhome.com/", className = "com.buzzbuzhome.AddLocationHitResponse")
    public void addLocationHit(
        @WebParam(name = "LocationID", targetNamespace = "http://buzzbuzhome.com/")
        int locationID
    );

    @WebMethod(operationName = "GetLocations", action = "http://buzzbuzhome.com/GetLocations")
    @RequestWrapper(localName = "GetLocations", targetNamespace = "http://buzzbuzhome.com/", className = "com.buzzbuzhome.GetLocations")
    @ResponseWrapper(localName = "GetLocationsResponse", targetNamespace = "http://buzzbuzhome.com/", className = "com.buzzbuzhome.GetLocationsResponse")
    @WebResult(name = "GetLocationsResult", targetNamespace = "http://buzzbuzhome.com/")
    public com.buzzbuzhome.ArrayOfBBHLocation getLocations(
        @WebParam(name = "text", targetNamespace = "http://buzzbuzhome.com/")
        java.lang.String text,
        @WebParam(name = "count", targetNamespace = "http://buzzbuzhome.com/")
        int count,
        @WebParam(name = "country", targetNamespace = "http://buzzbuzhome.com/")
        java.lang.String country,
        @WebParam(name = "restrictToCity", targetNamespace = "http://buzzbuzhome.com/")
        boolean restrictToCity
    );

    @WebMethod(operationName = "GetGeoLocations", action = "http://buzzbuzhome.com/GetGeoLocations")
    @RequestWrapper(localName = "GetGeoLocations", targetNamespace = "http://buzzbuzhome.com/", className = "com.buzzbuzhome.GetGeoLocations")
    @ResponseWrapper(localName = "GetGeoLocationsResponse", targetNamespace = "http://buzzbuzhome.com/", className = "com.buzzbuzhome.GetGeoLocationsResponse")
    @WebResult(name = "GetGeoLocationsResult", targetNamespace = "http://buzzbuzhome.com/")
    public com.buzzbuzhome.ArrayOfString getGeoLocations(
        @WebParam(name = "prefixText", targetNamespace = "http://buzzbuzhome.com/")
        java.lang.String prefixText,
        @WebParam(name = "count", targetNamespace = "http://buzzbuzhome.com/")
        int count,
        @WebParam(name = "contextKey", targetNamespace = "http://buzzbuzhome.com/")
        java.lang.String contextKey
    );

    @WebMethod(operationName = "GetUserLocation", action = "http://buzzbuzhome.com/GetUserLocation")
    @RequestWrapper(localName = "GetUserLocation", targetNamespace = "http://buzzbuzhome.com/", className = "com.buzzbuzhome.GetUserLocation")
    @ResponseWrapper(localName = "GetUserLocationResponse", targetNamespace = "http://buzzbuzhome.com/", className = "com.buzzbuzhome.GetUserLocationResponse")
    @WebResult(name = "GetUserLocationResult", targetNamespace = "http://buzzbuzhome.com/")
    public com.buzzbuzhome.BBHLocation getUserLocation(
        @WebParam(name = "ipAddress", targetNamespace = "http://buzzbuzhome.com/")
        java.lang.String ipAddress
    );

    @WebMethod(operationName = "GetGeoLocationsHeader", action = "http://buzzbuzhome.com/GetGeoLocationsHeader")
    @RequestWrapper(localName = "GetGeoLocationsHeader", targetNamespace = "http://buzzbuzhome.com/", className = "com.buzzbuzhome.GetGeoLocationsHeader")
    @ResponseWrapper(localName = "GetGeoLocationsHeaderResponse", targetNamespace = "http://buzzbuzhome.com/", className = "com.buzzbuzhome.GetGeoLocationsHeaderResponse")
    @WebResult(name = "GetGeoLocationsHeaderResult", targetNamespace = "http://buzzbuzhome.com/")
    public com.buzzbuzhome.ArrayOfString getGeoLocationsHeader(
        @WebParam(name = "prefixText", targetNamespace = "http://buzzbuzhome.com/")
        java.lang.String prefixText,
        @WebParam(name = "count", targetNamespace = "http://buzzbuzhome.com/")
        int count,
        @WebParam(name = "contextKey", targetNamespace = "http://buzzbuzhome.com/")
        java.lang.String contextKey
    );
}
