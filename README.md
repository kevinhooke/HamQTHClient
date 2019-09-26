HamQTHClient
============

Java API for HamQTH.com Amateur Radio Callsign lookup service, using JAX-RS.

This is intended to be used from other apps that need ability to do callsign lookups.

Usage

//initialize and logon
HamQTHClient hamQTHClient = new HamQTHClient();
hamQTHClient.logon(); //expects userid and password values for hamqth.com in hamqthclient.properties

... and then call other method, e.g. search()
