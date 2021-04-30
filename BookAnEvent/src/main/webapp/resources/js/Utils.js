/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getXmlHttpObj() {
    var xmlHttpObj;
    try     // Firefox, Opera 8.0+, Safari
    {
        xmlHttpObj = new XMLHttpRequest();
        return xmlHttpObj;
    } catch (e)
    {
        try  // Internet Explorer
        {
            xmlHttpObj = new ActiveXObject("Msxml2.XMLHTTP");
            return xmlHttpObj;
        } catch (e)
        {
            try
            {
                xmlHttpObj = new ActiveXObject("Microsoft.XMLHTTP");
                return xmlHttpObj;
            } catch (e)
            {
                return null;
            }
        }
    }
}

